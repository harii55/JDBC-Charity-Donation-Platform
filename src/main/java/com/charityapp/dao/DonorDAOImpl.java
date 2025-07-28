package main.java.com.charityapp.dao;

import main.java.com.charityapp.db.dbUtil;
import main.java.com.charityapp.enums.GenderType;
import main.java.com.charityapp.model.Donor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonorDAOImpl implements DonorDAO {


    public boolean addDonor(Donor d) throws SQLException {
        String insertDonorSql = "INSERT INTO donor (name, email, password, city, state, country, age, gender, income_range,created_at) VALUES (?,?,?,?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertDonorSql)) {
            ps.setString(1, d.getName());
            ps.setString(2, d.getEmail());
            ps.setString(3, d.getPassword());
            ps.setString(4, d.getCity());
            ps.setString(5, d.getState());
            ps.setString(6, d.getCountry());
            ps.setInt(7, d.getAge());
            ps.setString(8, d.getGender().name());
            ps.setString(9, d.getIncomeRange());

            ps.setTimestamp(10,d.getCreatedAt());
            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        }

    }

    public Donor getDonorById(int id) throws SQLException {
        String sql = "SELECT * FROM donor WHERE id = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Donor d = new Donor();
                d.setDonorId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setEmail(rs.getString("email"));
                d.setCity(rs.getString("city"));
                d.setState(rs.getString("state"));
                d.setCountry(rs.getString("country"));
                d.setAge(rs.getInt("age"));
                d.setGender(GenderType.valueOf(rs.getString("gender").toUpperCase()));
                d.setIncomeRange(rs.getString("income_range"));
                d.setCreatedAt(rs.getTimestamp("created_at"));
                return d;
            }
        }
        return null;
    }

    public Donor getDonorByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM donor WHERE email = ?";
        try (Connection conn = dbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Donor d = new Donor();
                d.setDonorId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setEmail(rs.getString("email"));
                d.setCity(rs.getString("city"));
                d.setState(rs.getString("state"));
                d.setCountry(rs.getString("country"));
                d.setAge(rs.getInt("age"));
                d.setGender(GenderType.valueOf(rs.getString("gender").toUpperCase()));
                d.setIncomeRange(rs.getString("income_range"));
                d.setCreatedAt(rs.getTimestamp("created_at"));

                return d;

            }
        }
        return null;
    }


    public boolean updateDonor(Donor d) throws SQLException {
        //The Donordto will be updated one with old-same Donor id

            String sql = "UPDATE donor SET name = ?, email = ?, password = ?, city = ?, state = ?, " +
                    "country = ?, age = ?, gender = ?, income_range = ? WHERE id = ?";

            try (Connection conn = dbUtil.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, d.getName());
                ps.setString(2, d.getEmail());
                ps.setString(3, d.getPassword());
                ps.setString(4, d.getCity());
                ps.setString(5, d.getState());
                ps.setString(6, d.getCountry());
                ps.setInt(7, d.getAge());
                ps.setString(8, d.getGender().toString());
                ps.setString(9, d.getIncomeRange());
                ps.setInt(10, d.getDonorId());

                int rowsUpdated = ps.executeUpdate();

                return rowsUpdated > 0;
            }

    }

}
