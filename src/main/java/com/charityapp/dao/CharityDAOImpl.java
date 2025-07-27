package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.model.Charity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharityDAOImpl implements CharityDAO {

    @Override
    public boolean addCharity(Charity charity) throws SQLException {
        String sql = "insert into charity(charity_id,name,email,category,description,websiteUrl,created_at,ackUrl,receiptUrl,is_active) values(?,?,?,?,?,?,?,?,?,?)";

        try(Connection conn = dbUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, charity.getCharityId());
            ps.setString(2, charity.getName());
            ps.setString(3, charity.getEmail());
            ps.setString(4, charity.getCategory());
            ps.setString(5, charity.getDescription());
            ps.setString(6, charity.getWebsiteUrl());
            ps.setTimestamp(7, charity.getCreatedAt());
            ps.setString(8, charity.getAckUrl());
            ps.setString(9, charity.getReceiptUrl());
            ps.setBoolean(10,charity.isIs_active());
            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;

        }

    }

    @Override
    public Charity getCharityById(int id) throws SQLException {
        String sql = "select * from charity where charity_id=?";
        try(Connection conn = dbUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Charity charity = new Charity();
                    charity.setCharityId(id);
                    return getCharity(rs, charity);
                }
            }
        }
        return null;
    }

    //extract charity from result set
    private Charity getCharity(ResultSet rs, Charity charity) throws SQLException {
        charity.setName(rs.getString("name"));
        charity.setEmail(rs.getString("email"));
        charity.setCategory(rs.getString("category"));
        charity.setDescription(rs.getString("description"));
        charity.setWebsiteUrl(rs.getString("websiteUrl"));
        charity.setCreatedAt(rs.getTimestamp("created_at"));
        charity.setAckUrl(rs.getString("ackUrl"));
        charity.setReceiptUrl(rs.getString("receiptUrl"));
        charity.setIs_active(rs.getBoolean("is_active"));
        return charity;
    }

    @Override
    public Charity getCharityByEmail(String email) throws SQLException {
        String sql = "select * from charity where email=?";
        try(Connection conn = dbUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Charity charity = new Charity();
                    charity.setCharityId(rs.getInt("charity_id"));
                    return getCharity(rs, charity);
                }
            }
        }
        return null;
    }

    @Override
    public List<Charity> getAllCharities() throws SQLException {
        String sql = "select * from charity";
        List<Charity> charityList = new ArrayList<>();

        try(Connection conn = dbUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                Charity charity = new Charity();
                charity.setCharityId(rs.getInt("charity_id"));
                charityList.add(getCharity(rs,charity));
            }

        }

        return charityList;
    }

    @Override
    public boolean updateCharity(Charity charity) throws SQLException {
        String sql = "UPDATE charity SET name=?, email=?, category=?, description=?, websiteUrl=?, ackUrl=?, receiptUrl=?, is_active=? WHERE charity_id=?";
            try (Connection conn = dbUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, charity.getName());
                ps.setString(2, charity.getEmail());
                ps.setString(3, charity.getCategory());
                ps.setString(4, charity.getDescription());
                ps.setString(5, charity.getWebsiteUrl());
                ps.setString(6, charity.getAckUrl());
                ps.setString(7, charity.getReceiptUrl());
                ps.setBoolean(8, charity.isIs_active());
                ps.setInt(9, charity.getCharityId());
                int rowsUpdated = ps.executeUpdate();


                return rowsUpdated > 0;
            }
        }

    }

