package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonorDonationSummaryDAOImpl implements DonorDonationSummaryDAO {
    @Override
    public void updateDonorStats(int donorId, String donationType, BigDecimal amount) {
        String sql = "INSERT INTO DonorDonationSummary (donor_id, donation_type, total_amount, donation_count, last_updated) " +
                "VALUES (?, ?, ?, 1, NOW()) " +
                "ON DUPLICATE KEY UPDATE total_amount = total_amount + VALUES(total_amount), " +
                "donation_count = donation_count + 1, last_updated = NOW()";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, donorId);
            stmt.setString(2, donationType);
            stmt.setBigDecimal(3, new BigDecimal(String.valueOf(amount)));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating DonorDonationSummary: " + e.getMessage());
        }
    }


}
