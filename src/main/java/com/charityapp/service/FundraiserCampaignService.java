package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.FundraiserCampaignDAO;
import main.java.com.charityapp.dao.FundraiserCampaignDAOImpl;
import main.java.com.charityapp.dto.FundraiserCampaignDTO;
import main.java.com.charityapp.mapper.FundraiserCampaignMapper;
import main.java.com.charityapp.model.FundraiserCampaign;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FundraiserCampaignService {
    private FundraiserCampaignDAO fcampaignDAO ;

    public FundraiserCampaignService() {
        fcampaignDAO = new FundraiserCampaignDAOImpl();
    }


    public boolean addfCampaign(FundraiserCampaignDTO dto) throws SQLException {
        return fcampaignDAO.addCampaign(FundraiserCampaignMapper.toEntity(dto));
    }

    public FundraiserCampaignDTO getfCampaignById(int id) throws SQLException {
        FundraiserCampaign campaign = fcampaignDAO.getfCampaignById(id);
        if(campaign != null){
            return FundraiserCampaignMapper.toDTO(campaign);
        }
        return null;
    }

    public boolean updatefCampaign(FundraiserCampaignDTO dto) throws SQLException {
        return fcampaignDAO.updatefCampaign(FundraiserCampaignMapper.toEntity(dto));
    }

    public boolean deletefCampaign(int id) throws SQLException {
        return fcampaignDAO.deletefCampaign(id);
    }

    public List<FundraiserCampaignDTO> getAllfCampaigns() throws SQLException {
        List<FundraiserCampaign> campaigns = fcampaignDAO.getAllfCampaigns();
        List<FundraiserCampaignDTO> dtos = new ArrayList<>();
        for (FundraiserCampaign campaign : campaigns) {
            dtos.add(FundraiserCampaignMapper.toDTO(campaign));
        }
        return dtos;
    }

    public List<FundraiserCampaignDTO> getActivefCampaigns() throws SQLException {
        List<FundraiserCampaign> campaigns = fcampaignDAO.getActivefCampaigns();
        List<FundraiserCampaignDTO> dtos = new ArrayList<>();
        for (FundraiserCampaign campaign : campaigns) {
            dtos.add(FundraiserCampaignMapper.toDTO(campaign));
        }
        return dtos;
    }

    public List<FundraiserCampaignDTO> getAllfCampaignsByCharity(int charityId) throws SQLException {
        List<FundraiserCampaign> campaigns = fcampaignDAO.getAllfCampaignsByCharity(charityId);
        List<FundraiserCampaignDTO> dtos = new ArrayList<>();
        for (FundraiserCampaign campaign : campaigns) {
            dtos.add(FundraiserCampaignMapper.toDTO(campaign));
        }
        return dtos;
    }

    public List<FundraiserCampaignDTO> getActivefCampaignsByCharity(int charityId) throws SQLException {
        List<FundraiserCampaign> campaigns = fcampaignDAO.getActivefCampaignsByCharity(charityId);
        List<FundraiserCampaignDTO> dtos = new ArrayList<>();
        for (FundraiserCampaign campaign : campaigns) {
            dtos.add(FundraiserCampaignMapper.toDTO(campaign));
        }
        return dtos;
    }
}
