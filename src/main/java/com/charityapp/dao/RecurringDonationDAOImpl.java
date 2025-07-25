package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.RecurringDonation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecurringDonationDAOImpl implements RecurringDonationDAO {

    @Override
    public boolean createRecurringDonation(RecurringDonation r) throws SQLException {
        String sql = "INSERT INTO RecurringDonation (donor_id, entity_type, entity_id, charity_id, recurring_rate, amount, last_installment, next_installment, start_date, end_date, is_active, primary_payment_method_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getDonorId());
            ps.setString(2, r.getEntityType());
            ps.setInt(3, r.getEntityId());
            ps.setInt(4, r.getCharityId());
            ps.setString(5, r.getRecurringRate());
            ps.setBigDecimal(6, r.getAmount());
            ps.setDate(7, r.getLastInstallment());
            ps.setDate(8, r.getNextInstallment());
            ps.setDate(9, r.getStartDate());
            ps.setDate(10, r.getEndDate());
            ps.setBoolean(11, r.isActive());
            ps.setInt(12, r.getPrimaryPaymentMethodId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<RecurringDonation> getRecurringDonationsByDonorId(int donorId) throws SQLException {
        String sql = "SELECT * FROM RecurringDonation WHERE donor_id = ?";
        List<RecurringDonation> list = new ArrayList<>();
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRecurringDonation(rs));
            }
        }
        return list;
    }

    @Override
    public boolean cancelRecurringDonation(int id) throws SQLException {
        String sql = "UPDATE RecurringDonation SET is_active = false WHERE recurring_donation_id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateNextInstallmentDate(int recurringDonationId, Date nextDate) throws SQLException {
        String sql = "UPDATE RecurringDonation SET next_installment = ? WHERE recurring_donation_id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, nextDate);
            ps.setInt(2, recurringDonationId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<RecurringDonation> getAllRecurringDonationsByCharityId(int charityId) throws SQLException {
        String sql = "SELECT * FROM RecurringDonation WHERE charity_id = ?";
        List<RecurringDonation> list = new ArrayList<>();
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, charityId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRecurringDonation(rs));
            }
        }
        return list;
    }

    private RecurringDonation mapRecurringDonation(ResultSet rs) throws SQLException {
        RecurringDonation r = new RecurringDonation();
        r.setRecurringDonationId(rs.getInt("recurring_donation_id"));
        r.setDonorId(rs.getInt("donor_id"));
        r.setEntityType(rs.getString("entity_type"));
        r.setEntityId(rs.getInt("entity_id"));
        r.setCharityId(rs.getInt("charity_id"));
        r.setRecurringRate(rs.getString("recurring_rate"));
        r.setAmount(rs.getBigDecimal("amount"));
        r.setLastInstallment(rs.getDate("last_installment"));
        r.setNextInstallment(rs.getDate("next_installment"));
        r.setStartDate(rs.getDate("start_date"));
        r.setEndDate(rs.getDate("end_date"));
        r.setActive(rs.getBoolean("is_active"));
        r.setPrimaryPaymentMethodId(rs.getInt("primary_payment_method_id"));
        return r;
    }
}
