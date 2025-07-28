package main.java.com.charityapp.dao;
import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.dto.TestingQueriesDTO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestingQueriesDAOImpl implements TestingQueriesDAO {

    private Connection connection;

    public TestingQueriesDAOImpl() throws SQLException {
        this.connection = dbUtil.getConnection();
    }


    @Override
    public List<CampaignDonationDTO> getTotalDonationsPerCampaign() throws Exception {
        String query = """
                SELECT c.title, SUM(ct.amount) AS total_donated
                FROM Campaign c
                JOIN CampaignTransactions ct ON c.campaign_id = ct.campaign_id
                GROUP BY c.title
                """;
        List<CampaignDonationDTO> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                CampaignDonationDTO dto = new CampaignDonationDTO();
                dto.setCampaignTitle(rs.getString("title"));
                dto.setTotalDonated(rs.getDouble("total_donated"));
                result.add(dto);
            }
        }
        return result;
    }

    @Override
    public List<DonorSegmentDTO> getAvgDonationByAge() throws Exception {
        List<DonorSegmentDTO> results = new ArrayList<>();

        String sql = """
        SELECT
            CASE
                WHEN d.age <= 25 THEN 'Youth'
                WHEN d.age BETWEEN 26 AND 50 THEN 'Adult'
                ELSE 'Senior'
            END AS donor_segment,
            ROUND(AVG(dds.total_amount), 2) AS average_amount
        FROM DonorDonationSummary dds
        JOIN donor d ON dds.donor_id = d.id
        GROUP BY donor_segment
        ORDER BY average_amount DESC
    """;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DonorSegmentDTO dto = new DonorSegmentDTO();
                dto.setDonorSegment(rs.getString("donor_segment"));
                dto.setAverageAmount(rs.getDouble("average_amount"));
                results.add(dto);
            }
        }

        return results;
    }

    @Override
    public List<DonorSegmentDTO> getAvgDonationByIncomeRange() throws Exception {
        List<DonorSegmentDTO> results = new ArrayList<>();

        String sql = """
        SELECT
            d.income_range AS donor_segment,
            ROUND(AVG(dds.total_amount), 2) AS average_amount
        FROM DonorDonationSummary dds
        JOIN Donor d ON dds.donor_id = d.id
        GROUP BY d.income_range
        ORDER BY average_amount DESC
    """;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DonorSegmentDTO dto = new DonorSegmentDTO();
                dto.setDonorSegment(rs.getString("donor_segment")); // income_range
                dto.setAverageAmount(rs.getDouble("average_amount"));
                results.add(dto);
            }
        }

        return results;
    }


    @Override
    public List<DonorSegmentDTO> getAvgDonationByGender() throws Exception {
        List<DonorSegmentDTO> results = new ArrayList<>();

        String sql = """
        SELECT
            d.gender AS donor_segment,
            ROUND(AVG(dds.total_amount), 2) AS average_amount
        FROM DonorDonationSummary dds
        JOIN Donor d ON dds.donor_id = d.id
        GROUP BY d.gender
        ORDER BY average_amount DESC
    """;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DonorSegmentDTO dto = new DonorSegmentDTO();
                dto.setDonorSegment(rs.getString("donor_segment")); // gender
                dto.setAverageAmount(rs.getDouble("average_amount"));
                results.add(dto);
            }
        }

        return results;
    }

    @Override
    public List<CampaignGoalProgressDTO> getFundraiserNearingGoal() throws Exception {
        String sql = "SELECT fc.title, fs.total_amount_raised, fc.goal " +
                "FROM FundraiserCampaign fc " +
                "JOIN FundraiserSummary fs ON fc.fcampaign_id = fs.fcampaign_id " +
                "WHERE fs.total_amount_raised >= 0.8 * fc.goal";

        List<CampaignGoalProgressDTO> result = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CampaignGoalProgressDTO dto = new CampaignGoalProgressDTO();
                dto.setTitle(rs.getString("title"));
                dto.setTotalRaised(rs.getDouble("total_amount_raised"));
                dto.setGoal(rs.getDouble("goal"));
                result.add(dto);
            }
        }
        return result;
    }

    @Override
    public List<ReceiptStatusDTO> getFundraiserReceiptIssuanceStatus() throws Exception {
        String sql = """
        SELECT 
            fc.title AS receipt_status,
            COUNT(*) AS total_receipts,
            SUM(CASE WHEN ft.receipt_status = 'PENDING' THEN 1 ELSE 0 END) AS pending_receipts
        FROM FundraiserTransactions ft
        JOIN FundraiserCampaign fc ON ft.fcampaign_id = fc.fcampaign_id
        GROUP BY fc.title
        ORDER BY fc.title
    """;

        List<ReceiptStatusDTO> result = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ReceiptStatusDTO dto = new ReceiptStatusDTO();
                dto.setReceiptStatus(rs.getString("receipt_status"));  // Title
                dto.setCount(rs.getInt("total_receipts"));             // Total
                dto.setPendingCount(rs.getInt("pending_receipts"));    // Add to DTO
                result.add(dto);
            }
        }
        return result;
    }

    @Override
    public List<ReceiptStatusDTO> getCampaignReceiptIssuanceStatus() throws Exception {
        String sql = """
        SELECT 
            c.title AS receipt_status,
            COUNT(*) AS total_receipts,
            SUM(CASE WHEN ct.receipt_status = 'PENDING' THEN 1 ELSE 0 END) AS pending_receipts
        FROM CampaignTransactions ct
        JOIN Campaign c ON ct.campaign_id = c.campaign_id
        GROUP BY c.title
        ORDER BY c.title
    """;

        List<ReceiptStatusDTO> result = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ReceiptStatusDTO dto = new ReceiptStatusDTO();
                dto.setReceiptStatus(rs.getString("receipt_status")); // Title used here
                dto.setCount(rs.getInt("total_receipts"));            // Total receipts
                dto.setPendingCount(rs.getInt("pending_receipts"));   // Add this field to DTO
                result.add(dto);
            }
        }
        return result;
    }



    @Override
    public List<DonorAcquisitionDTO> getDonorAcquisitionTrends() throws Exception {
        String sql = "SELECT \n" +
                "    DATE_FORMAT(created_at, '%Y-%m') AS month_joined,\n" +
                "    COUNT(*) AS count\n" +
                "FROM Donor\n" +
                "GROUP BY month_joined\n" +
                "ORDER BY month_joined;\n";

        List<DonorAcquisitionDTO> result = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DonorAcquisitionDTO dto = new DonorAcquisitionDTO();
                dto.setDateJoined(rs.getString("month_joined"));
                dto.setCount(rs.getInt("count"));
                result.add(dto);
            }
        }
        return result;
    }
}