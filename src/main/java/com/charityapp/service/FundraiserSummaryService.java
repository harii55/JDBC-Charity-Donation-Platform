package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.FundraiserSummaryDAO;
import main.java.com.charityapp.dao.FundraiserSummaryDAOImpl;

import java.math.BigDecimal;

public class FundraiserSummaryService {

    private FundraiserSummaryDAO dao;

    public FundraiserSummaryService() throws Exception {
        this.dao = new FundraiserSummaryDAOImpl();
    }

    public void updateSummary(int fcampaignId, BigDecimal amount) throws Exception {
        dao.updateFundraiserSummary(fcampaignId, amount);
    }
}
