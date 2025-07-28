package main.java.com.charityapp.dao;
import main.java.com.charityapp.enums.PaymentMethodType;
import main.java.com.charityapp.model.PaymentMethod;
import main.java.com.charityapp.db.dbUtil;

import java.sql.*;
import java.util.*;

public class PaymentMethodDAOImpl implements PaymentMethodDAO {
    private final dbUtil dbUtil = new dbUtil();

    @Override
    public boolean createPaymentMethod(PaymentMethod pm) {
        String sql = "INSERT INTO PaymentMethods (donor_id, method_type, details, is_active) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pm.getDonorId());
            stmt.setString(2, pm.getMethodType().name());
            stmt.setString(3, pm.getDetails());
            stmt.setBoolean(4, pm.isActive());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        @Override
    public List<PaymentMethod> getPaymentMethodsByDonorId(int donorId) {
        List<PaymentMethod> list = new ArrayList<>();
        String sql = "SELECT * FROM PaymentMethods WHERE donor_id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, donorId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deactivatePaymentMethod(int id) {
        String sql = "UPDATE PaymentMethods SET is_active = false WHERE id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static PaymentMethod map(ResultSet rs) throws SQLException {
        return new PaymentMethod(
                rs.getInt("id"),
                rs.getInt("donor_id"),
                PaymentMethodType.valueOf(rs.getString("method_type")),
                rs.getString("details"),
                rs.getBoolean("is_active"),
                rs.getTimestamp("created_at")
        );
    }
}
