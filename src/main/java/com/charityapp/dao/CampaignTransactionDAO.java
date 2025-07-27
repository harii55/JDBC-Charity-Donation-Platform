package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.CampaignTransaction;

import java.sql.SQLException;
import java.util.List;

public interface CampaignTransactionDAO {

    boolean makeCampaignDonation(CampaignTransaction transaction) throws SQLException;

    List<CampaignTransaction> getTransactionsByCampaign(int campaignId) throws SQLException;

    List<CampaignTransaction> getTransactionsByDonor(int donorId) throws SQLException;
}
