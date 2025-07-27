package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.CampaignTransaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CampaignTransactionDAOImpl implements CampaignTransactionDAO {

    @Override
    public boolean makeCampaignDonation(CampaignTransaction ct) throws SQLException {
        String sql = "INSERT INTO CampaignTransactions (donor_id, campaign_id, amount, timestamp, receipt_status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ct.getDonorId());
            ps.setInt(2, ct.getCampaignId());
            ps.setBigDecimal(3, ct.getAmount());
            ps.setTimestamp(4, ct.getTimestamp());
            ps.setString(5, ct.getReceiptStatus());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<CampaignTransaction> getTransactionsByCampaign(int campaignId) throws SQLException {
        String sql = "SELECT * FROM CampaignTransactions WHERE campaign_id = ?";
        List<CampaignTransaction> transactions = new ArrayList<>();

        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, campaignId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CampaignTransaction ct = new CampaignTransaction();
                ct.setTransactionId(rs.getInt("transaction_id"));
                ct.setDonorId(rs.getInt("donor_id"));
                ct.setCampaignId(rs.getInt("campaign_id"));
                ct.setAmount(rs.getBigDecimal("amount"));
                ct.setTimestamp(rs.getTimestamp("timestamp"));
                ct.setReceiptStatus(rs.getString("receipt_status"));
                transactions.add(ct);
            }
        }
        return transactions;
    }

    @Override
    public List<CampaignTransaction> getTransactionsByDonor(int donorId) throws SQLException {
        String sql = "SELECT * FROM CampaignTransactions WHERE donor_id = ?";
        List<CampaignTransaction> transactions = new ArrayList<>();

        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CampaignTransaction ct = new CampaignTransaction();
                ct.setTransactionId(rs.getInt("transaction_id"));
                ct.setDonorId(rs.getInt("donor_id"));
                ct.setCampaignId(rs.getInt("campaign_id"));
                ct.setAmount(rs.getBigDecimal("amount"));
                ct.setTimestamp(rs.getTimestamp("timestamp"));
                ct.setReceiptStatus(rs.getString("receipt_status"));
                transactions.add(ct);
            }
        }
        return transactions;
    }
}
