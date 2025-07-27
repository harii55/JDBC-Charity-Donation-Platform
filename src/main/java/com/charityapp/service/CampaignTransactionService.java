package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.CampaignTransactionDAO;
import main.java.com.charityapp.dao.CampaignTransactionDAOImpl;
import main.java.com.charityapp.dto.CampaignTransactionDTO;
import main.java.com.charityapp.mapper.CampaignTransactionMapper;
import main.java.com.charityapp.model.CampaignTransaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampaignTransactionService {
    private CampaignTransactionDAO transactionDAO = new CampaignTransactionDAOImpl();

    public boolean makeCampaignDonation(CampaignTransactionDTO dto) throws SQLException {
        return transactionDAO.makeCampaignDonation(CampaignTransactionMapper.toEntity(dto));
    }

    public List<CampaignTransactionDTO> getTransactionsByCampaign(int campaignId) throws SQLException {

        List<CampaignTransaction> list = transactionDAO.getTransactionsByCampaign(campaignId);
        List<CampaignTransactionDTO> dtoList = new ArrayList<>();
        for (CampaignTransaction ct : list) {
            dtoList.add(CampaignTransactionMapper.toDTO(ct));
        }
        return dtoList;
    }

    public List<CampaignTransactionDTO> getTransactionsByDonor(int donorId) throws SQLException {
        List<CampaignTransaction> list = transactionDAO.getTransactionsByDonor(donorId);
        List<CampaignTransactionDTO> dtoList = new ArrayList<>();
        for (CampaignTransaction ct : list) {
            dtoList.add(CampaignTransactionMapper.toDTO(ct));
        }
        return dtoList;
    }
}
