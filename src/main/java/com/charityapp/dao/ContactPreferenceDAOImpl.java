package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.ContactPreference;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactPreferenceDAOImpl implements ContactPreferenceDAO {

    private int getNextPrefRank(Connection conn, int donorId) throws SQLException {
        String sql = "SELECT COALESCE(MAX(pref_rank), 0) + 1 FROM ContactPreference WHERE donor_id = ? AND is_active = TRUE";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 1;
    }

    @Override
    public boolean addContactPreference(ContactPreference cp) throws Exception {
        String sql = "INSERT INTO ContactPreference (donor_id, contact_via, value, pref_rank, is_active) VALUES (?, ?, ?, ?, TRUE)";
        try (Connection conn = dbUtil.getConnection()) {
            if (cp.getPrefRank() == 0) {
                cp.setPrefRank(getNextPrefRank(conn, cp.getDonorId()));
            }
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, cp.getDonorId());
                ps.setString(2, cp.getContactVia());
                ps.setString(3, cp.getValue());
                ps.setInt(4, cp.getPrefRank());
                return ps.executeUpdate() > 0;
            }
        }
    }

    @Override
    public boolean deleteContactPreference(int id) throws Exception {
        String sql = "UPDATE ContactPreference SET is_active = FALSE WHERE id = ?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<ContactPreference> getPreferencesByDonorId(int donorId) throws Exception {
        List<ContactPreference> list = new ArrayList<>();
        String sql = "SELECT * FROM ContactPreference WHERE donor_id = ? AND is_active = TRUE ORDER BY pref_rank";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ContactPreference cp = new ContactPreference();
                cp.setId(rs.getInt("id"));
                cp.setDonorId(rs.getInt("donor_id"));
                cp.setContactVia(rs.getString("contact_via"));
                cp.setValue(rs.getString("value"));
                cp.setPrefRank(rs.getInt("pref_rank"));
                cp.setActive(rs.getBoolean("is_active"));
                list.add(cp);
            }
        }
        return list;
    }

    @Override
    public ContactPreference getPrimaryContactByDonorId(int donorId) throws Exception {
        String sql = "SELECT * FROM ContactPreference WHERE donor_id = ? AND is_active = TRUE ORDER BY pref_rank LIMIT 1";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, donorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ContactPreference cp = new ContactPreference();
                cp.setId(rs.getInt("id"));
                cp.setDonorId(rs.getInt("donor_id"));
                cp.setContactVia(rs.getString("contact_via"));
                cp.setValue(rs.getString("value"));
                cp.setPrefRank(rs.getInt("pref_rank"));
                cp.setActive(rs.getBoolean("is_active"));
                return cp;
            }
        }
        return null;
    }
}
