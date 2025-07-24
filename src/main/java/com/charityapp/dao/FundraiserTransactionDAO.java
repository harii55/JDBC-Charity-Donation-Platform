package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.FundraiserTransaction;

import java.sql.SQLException;
import java.util.List;

public interface FundraiserTransactionDAO {

    boolean makeFundraiserDonation(FundraiserTransaction transaction) throws SQLException;

    List<FundraiserTransaction> getTransactionsByFundraiser(int fcampaignId) throws SQLException;

    List<FundraiserTransaction> getTransactionsByDonor(int donorId) throws SQLException;
}
