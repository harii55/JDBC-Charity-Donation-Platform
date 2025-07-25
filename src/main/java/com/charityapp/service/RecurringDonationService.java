package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.RecurringDonationDAO;
import main.java.com.charityapp.dao.RecurringDonationDAOImpl;
import main.java.com.charityapp.dto.RecurringDonationDTO;
import main.java.com.charityapp.mapper.RecurringDonationMapper;
import main.java.com.charityapp.model.RecurringDonation;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecurringDonationService {
    private RecurringDonationDAO recurringDonationDAO;

    public RecurringDonationService() {
        this.recurringDonationDAO = new RecurringDonationDAOImpl();
    }

    public boolean createRecurringDonation(RecurringDonationDTO dto) throws Exception {
        RecurringDonation entity = RecurringDonationMapper.toEntity(dto);
        return recurringDonationDAO.createRecurringDonation(entity);
    }


    public List<RecurringDonationDTO> getRecurringDonationsByDonorId(int donorId) throws Exception {
        List<RecurringDonation> donations = recurringDonationDAO.getRecurringDonationsByDonorId(donorId);
        List<RecurringDonationDTO> dtos = new ArrayList<>();
        for (RecurringDonation r : donations) {
            dtos.add(RecurringDonationMapper.toDTO(r));
        }
        return dtos;
    }

    public boolean cancelRecurringDonation(int id) throws Exception {
        return recurringDonationDAO.cancelRecurringDonation(id);
    }

    public boolean updateNextInstallmentDate(int id, Date nextInstallment) throws Exception {
        return recurringDonationDAO.updateNextInstallmentDate(id, nextInstallment);
    }

    public List<RecurringDonationDTO> getAllRecurringDonationsByCharityId(int charityId) throws Exception {
        List<RecurringDonation> donations = recurringDonationDAO.getAllRecurringDonationsByCharityId(charityId);
        List<RecurringDonationDTO> dtos = new ArrayList<>();
        for (RecurringDonation r : donations) {
            dtos.add(RecurringDonationMapper.toDTO(r));
        }
        return dtos;
    }
}
