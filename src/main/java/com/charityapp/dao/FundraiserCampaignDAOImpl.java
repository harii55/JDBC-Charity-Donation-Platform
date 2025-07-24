package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.FundraiserCampaign;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FundraiserCampaignDAOImpl implements FundraiserCampaignDAO {

    private FundraiserCampaign getCampaign(ResultSet rs) throws SQLException {
        FundraiserCampaign c = new FundraiserCampaign();
        c.setFcampaignId(rs.getInt("fcampaign_id"));
        c.setCharityId(rs.getInt("charity_id"));
        c.setTitle(rs.getString("title"));
        c.setCategory(rs.getString("category"));
        c.setGoal(rs.getDouble("goal"));
        c.setStartDate(rs.getDate("start_date"));
        c.setEndDate(rs.getDate("end_date"));
        c.setActive(rs.getBoolean("is_active"));
        c.setRecUrl(rs.getString("rec_url"));
        c.setAckUrl(rs.getString("ack_url"));
        c.setDescription(rs.getString("description"));
        c.setCreatedAt(rs.getTimestamp("created_at"));
        return c;
    }

    @Override
    public boolean addCampaign(FundraiserCampaign c) throws SQLException {
        String sql = "INSERT INTO FundraiserCampaign (charity_id, title, category, goal, start_date, end_date, is_active, rec_url, ack_url, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getCharityId());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getCategory());
            ps.setDouble(4, c.getGoal());
            ps.setDate(5, c.getStartDate());
            ps.setDate(6, c.getEndDate());
            ps.setBoolean(7, c.isActive());
            ps.setString(8, c.getRecUrl());
            ps.setString(9, c.getAckUrl());
            ps.setString(10, c.getDescription());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public FundraiserCampaign getfCampaignById(int id) throws SQLException {
        String sql = "SELECT * FROM FundraiserCampaign WHERE fcampaign_id=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return getCampaign(rs);
        }
        return null;
    }

    @Override
    public List<FundraiserCampaign> getAllfCampaigns() throws SQLException {
        List<FundraiserCampaign> list = new ArrayList<>();
        String sql = "SELECT * FROM FundraiserCampaign";
        try (Connection conn = dbUtil.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public List<FundraiserCampaign> getAllfCampaignsByCharity(int charityId) throws SQLException {
        List<FundraiserCampaign> list = new ArrayList<>();
        String sql = "SELECT * FROM FundraiserCampaign WHERE charity_id=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, charityId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public List<FundraiserCampaign> getActivefCampaignsByCharity(int charityId) throws SQLException {
        List<FundraiserCampaign> list = new ArrayList<>();
        String sql = "SELECT * FROM FundraiserCampaign WHERE charity_id=? AND is_active=TRUE";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, charityId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public List<FundraiserCampaign> getActivefCampaigns() throws SQLException {
        List<FundraiserCampaign> list = new ArrayList<>();
        String sql = "SELECT * FROM FundraiserCampaign WHERE is_active=TRUE";
        try (Connection conn = dbUtil.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public boolean updatefCampaign(FundraiserCampaign c) throws SQLException {
        String sql = "UPDATE FundraiserCampaign SET charity_id=?, title=?, category=?, goal=?, start_date=?, end_date=?, is_active=?, rec_url=?, ack_url=?, description=? WHERE fcampaign_id=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getCharityId());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getCategory());
            ps.setDouble(4, c.getGoal());
            ps.setDate(5, c.getStartDate());
            ps.setDate(6, c.getEndDate());
            ps.setBoolean(7, c.isActive());
            ps.setString(8, c.getRecUrl());
            ps.setString(9, c.getAckUrl());
            ps.setString(10, c.getDescription());
            ps.setInt(11, c.getFcampaignId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deletefCampaign(int id) throws SQLException {
        String sql = "UPDATE FundraiserCampaign SET is_active=FALSE WHERE fcampaign_id=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
