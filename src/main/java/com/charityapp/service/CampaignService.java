package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.CampaignDAO;
import main.java.com.charityapp.dao.CampaignDAOImpl;
import main.java.com.charityapp.dto.CampaignDTO;
import main.java.com.charityapp.mapper.CampaignMapper;
import main.java.com.charityapp.mapper.CharityMapper;
import main.java.com.charityapp.model.Campaign;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampaignService {
    private CampaignDAO campaignDAO;

    public CampaignService() {
        campaignDAO = new CampaignDAOImpl();
    }

    public boolean addCampaign(CampaignDTO dto) throws SQLException {
        return campaignDAO.addCampaign(CampaignMapper.toEntity(dto));
    }

    public CampaignDTO getCampaignById(int id) throws SQLException {
        Campaign campaign = campaignDAO.getCampaignById(id);
        if(campaign != null) {
            return CampaignMapper.toDTO(campaign);
        }
        return null;
    }

    public boolean updateCampaign(CampaignDTO dto) throws SQLException {
        return campaignDAO.updateCampaign(CampaignMapper.toEntity(dto));
    }

    public boolean deleteCampaign(int id) throws SQLException {
        return campaignDAO.deleteCampaign(id);
    }

    public List<CampaignDTO> getAllCampaigns() throws SQLException {
        List<Campaign> campaigns = campaignDAO.getAllCampaigns();
        List<CampaignDTO> dtos = new ArrayList<>();
        for (Campaign c : campaigns) {
            dtos.add(CampaignMapper.toDTO(c));
        }
        return dtos;
    }

    public List<CampaignDTO> getActiveCampaigns() throws SQLException {
        List<Campaign> campaigns = campaignDAO.getActiveCampaigns();
        List<CampaignDTO> dtos = new ArrayList<>();
        for (Campaign c : campaigns) {
            dtos.add(CampaignMapper.toDTO(c));
        }
        return dtos;
    }

    public List<CampaignDTO> getAllCampaignsByCharity(int charityId) throws SQLException {
        List<Campaign> campaigns = campaignDAO.getAllCampaignsByCharity(charityId);
        List<CampaignDTO> dtos = new ArrayList<>();
        for (Campaign c : campaigns) {
            dtos.add(CampaignMapper.toDTO(c));
        }
        return dtos;
    }

    public List<CampaignDTO> getActiveCampaignsByCharity(int charityId) throws SQLException {
        List<Campaign> campaigns = campaignDAO.getActiveCampaignsByCharity(charityId);
        List<CampaignDTO> dtos = new ArrayList<>();
        for (Campaign c : campaigns) {
            dtos.add(CampaignMapper.toDTO(c));
        }
        return dtos;
    }
}
