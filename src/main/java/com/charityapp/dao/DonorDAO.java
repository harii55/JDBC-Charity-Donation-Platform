package main.java.com.charityapp.dao;
import main.java.com.charityapp.model.Donor;
import java.sql.SQLException;

public interface DonorDAO {


    boolean addDonor(Donor d) throws SQLException;

    Donor getDonorById(int id) throws SQLException;

    Donor getDonorByEmail(String email) throws SQLException;

    boolean updateDonor(Donor d) throws SQLException;

}
