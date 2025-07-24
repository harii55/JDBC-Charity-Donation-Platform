package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.DonorDAO;
import main.java.com.charityapp.dao.DonorDAOImpl;
import main.java.com.charityapp.dto.DonorDTO;
import main.java.com.charityapp.mapper.DonorMapper;
import main.java.com.charityapp.model.Donor;

import java.sql.SQLException;

public class DonorService {
    private DonorDAO donorDAO;

    public DonorService() {
        donorDAO = new DonorDAOImpl();
    }

    public boolean addDonor(Donor d) throws SQLException {
        return donorDAO.addDonor(d);
    }

    public DonorDTO getDonorById(int donorId) throws SQLException {
        Donor donor = donorDAO.getDonorById(donorId);

        try {
            if (donor != null) {
                return DonorMapper.toDTO(donor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public DonorDTO getDonarByEmail(String email) throws SQLException {
        Donor donor = donorDAO.getDonorByEmail(email);
        try {
            if (donor != null) {
                return DonorMapper.toDTO(donor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean updateDonor(DonorDTO d) throws SQLException {
        try {
            // Fetch existing donor to preserve password & createdAt
            Donor existing = donorDAO.getDonorById(d.getDonorId()); //fetching the existing one
            if (existing == null) return false;

            Donor updated = DonorMapper.toEntity(d, existing.getPassword()); //updated is passed through params, converting it to model-entity

            return donorDAO.updateDonor(updated);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
