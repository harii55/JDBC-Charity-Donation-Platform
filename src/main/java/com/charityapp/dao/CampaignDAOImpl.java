package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.Campaign;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAOImpl implements CampaignDAO {

    private Campaign getCampaign(ResultSet rs) throws SQLException {
        Campaign c = new Campaign();
        c.setCampaignId(rs.getInt("campaign_id"));
        c.setCharityId(rs.getInt("charity_id"));
        c.setTitle(rs.getString("title"));
        c.setCategory(rs.getString("category"));
        c.setDescription(rs.getString("description"));
        c.setRecUrl(rs.getString("rec_url"));
        c.setAckUrl(rs.getString("ack_url"));
        c.setActive(rs.getBoolean("is_active"));
        c.setStartDate(rs.getDate("start_date"));
        c.setEndDate(rs.getDate("end_date"));
        return c;
    }

    @Override
    public boolean addCampaign(Campaign c) throws SQLException {
        String sql = "INSERT INTO Campaign (charity_id, title, category, description, rec_url, ack_url, is_active, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getCharityId());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getCategory());
            ps.setString(4, c.getDescription());
            ps.setString(5, c.getRecUrl());
            ps.setString(6, c.getAckUrl());
            ps.setBoolean(7, c.isActive());
            ps.setDate(8, c.getStartDate());
            ps.setDate(9, c.getEndDate());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Campaign getCampaignById(int campaignId) throws SQLException {
        String sql = "SELECT * FROM Campaign WHERE campaign_id=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, campaignId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return getCampaign(rs);
        }
        return null;
    }

    @Override
    public List<Campaign> getAllCampaigns() throws SQLException {
        List<Campaign> list = new ArrayList<>();
        String sql = "SELECT * FROM Campaign";
        try (Connection conn = dbUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public List<Campaign> getActiveCampaigns() throws SQLException {
        List<Campaign> list = new ArrayList<>();
        String sql = "SELECT * FROM Campaign WHERE is_active = TRUE";
        try (Connection conn = dbUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public List<Campaign> getAllCampaignsByCharity(int charityId) throws SQLException {
        List<Campaign> list = new ArrayList<>();
        String sql = "SELECT * FROM Campaign WHERE charity_id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, charityId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }

    @Override
    public List<Campaign> getActiveCampaignsByCharity(int charityId) throws SQLException {
        List<Campaign> list = new ArrayList<>();
        String sql = "SELECT * FROM Campaign WHERE charity_id = ? AND is_active = TRUE";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, charityId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(getCampaign(rs));
        }
        return list;
    }



    @Override
    public boolean updateCampaign(Campaign c) throws SQLException {
        String sql = "UPDATE Campaign SET charity_id=?, title=?, category=?, description=?, rec_url=?, ack_url=?, is_active=?, start_date=?, end_date=? WHERE campaign_id=?";
        try (Connection conn = dbUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getCharityId());
            ps.setString(2, c.getTitle());
            ps.setString(3, c.getCategory());
            ps.setString(4, c.getDescription());
            ps.setString(5, c.getRecUrl());
            ps.setString(6, c.getAckUrl());
            ps.setBoolean(7, c.isActive());
            ps.setDate(8, c.getStartDate());
            ps.setDate(9, c.getEndDate());
            ps.setInt(10, c.getCampaignId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteCampaign(int campaignId) throws SQLException {
        String sql = "UPDATE Campaign SET is_active = false WHERE campaign_id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, campaignId);
            return ps.executeUpdate() > 0;
        }
    }

}
