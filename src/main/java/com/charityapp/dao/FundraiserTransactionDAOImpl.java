package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.FundraiserTransaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FundraiserTransactionDAOImpl implements FundraiserTransactionDAO {

    @Override
    public boolean makeFundraiserDonation(FundraiserTransaction ft) throws SQLException {
        String sql = "INSERT INTO FundraiserTransactions (donor_id, fcampaign_id, amount, timestamp, receipt_status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ft.getDonorId());
            ps.setInt(2, ft.getFcampaignId());
            ps.setBigDecimal(3, ft.getAmount());
            ps.setTimestamp(4, ft.getTimestamp());
            ps.setString(5, ft.getReceiptStatus());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<FundraiserTransaction> getTransactionsByFundraiser(int fcampaignId) throws SQLException {
        String sql = "SELECT * FROM FundraiserTransactions WHERE fcampaign_id = ?";
        List<FundraiserTransaction> transactions = new ArrayList<>();

        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fcampaignId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FundraiserTransaction ft = new FundraiserTransaction();
                ft.setTransactionId(rs.getInt("transaction_id"));
                ft.setDonorId(rs.getInt("donor_id"));
                ft.setFcampaignId(rs.getInt("fcampaign_id"));
                ft.setAmount(rs.getBigDecimal("amount"));
                ft.setTimestamp(rs.getTimestamp("timestamp"));
                ft.setReceiptStatus(rs.getString("receipt_status"));
                transactions.add(ft);
            }
        }
        return transactions;
    }

    @Override
    public List<FundraiserTransaction> getTransactionsByDonor(int donorId) throws SQLException {
        String sql = "SELECT * FROM FundraiserTransactions WHERE donor_id = ?";
        List<FundraiserTransaction> transactions = new ArrayList<>();

        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FundraiserTransaction ft = new FundraiserTransaction();
                ft.setTransactionId(rs.getInt("transaction_id"));
                ft.setDonorId(rs.getInt("donor_id"));
                ft.setFcampaignId(rs.getInt("fcampaign_id"));
                ft.setAmount(rs.getBigDecimal("amount"));
                ft.setTimestamp(rs.getTimestamp("timestamp"));
                ft.setReceiptStatus(rs.getString("receipt_status"));
                transactions.add(ft);
            }
        }
        return transactions;
    }
}
