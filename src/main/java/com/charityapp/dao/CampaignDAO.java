package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.Campaign;

import java.sql.SQLException;
import java.util.List;

public interface CampaignDAO {
    boolean addCampaign(Campaign campaign) throws SQLException;
    Campaign getCampaignById(int campaignId) throws SQLException;
    List<Campaign> getAllCampaigns() throws SQLException;
    List<Campaign> getAllCampaignsByCharity(int charityId) throws SQLException;
    List<Campaign> getActiveCampaignsByCharity(int charityId) throws SQLException;
    List<Campaign> getActiveCampaigns() throws SQLException;
    boolean updateCampaign(Campaign campaign) throws SQLException;
    boolean deleteCampaign(int campaignId) throws SQLException;
}
