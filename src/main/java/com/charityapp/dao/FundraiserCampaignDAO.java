package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.FundraiserCampaign;

import java.sql.SQLException;
import java.util.List;

public interface FundraiserCampaignDAO {
    boolean addCampaign(FundraiserCampaign campaign) throws SQLException;
    FundraiserCampaign getfCampaignById(int fcampaignId) throws SQLException;
    List<FundraiserCampaign> getAllfCampaigns() throws SQLException;
    List<FundraiserCampaign> getAllfCampaignsByCharity(int charityId) throws SQLException;
    List<FundraiserCampaign> getActivefCampaignsByCharity(int charityId) throws SQLException;
    List<FundraiserCampaign> getActivefCampaigns() throws SQLException;
    boolean updatefCampaign(FundraiserCampaign campaign) throws SQLException;
    boolean deletefCampaign(int fcampaignId) throws SQLException;

}
