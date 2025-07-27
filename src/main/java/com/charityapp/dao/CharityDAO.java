package main.java.com.charityapp.dao;


import main.java.com.charityapp.model.Charity;

import java.sql.SQLException;
import java.util.List;

public interface CharityDAO {
    boolean addCharity(Charity charity) throws SQLException;
    Charity getCharityById(int id) throws SQLException;
    Charity getCharityByEmail(String email) throws SQLException;
    List<Charity> getAllCharities() throws SQLException;
    boolean updateCharity(Charity charity) throws SQLException;


}
