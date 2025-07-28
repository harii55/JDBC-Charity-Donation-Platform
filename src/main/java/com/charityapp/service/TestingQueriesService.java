package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.TestingQueriesDAO;
import main.java.com.charityapp.dao.TestingQueriesDAOImpl;
import main.java.com.charityapp.dto.TestingQueriesDTO.*;

import java.sql.SQLException;
import java.util.List;

public class TestingQueriesService {

    private final TestingQueriesDAO dao;

    public TestingQueriesService() throws SQLException {
        this.dao = new TestingQueriesDAOImpl();
    }

    public List<CampaignDonationDTO> getTotalDonationsPerCampaign() throws Exception {
        return dao.getTotalDonationsPerCampaign();
    }

    public List<DonorSegmentDTO> getAvgDonationByAge() throws Exception {
        return dao.getAvgDonationByAge();
    }

    public List<DonorSegmentDTO> getAvgDonationByIncomeRange() throws Exception {
        return dao.getAvgDonationByIncomeRange();
    }

    public List<DonorSegmentDTO> getAvgDonationByGender() throws Exception {
        return dao.getAvgDonationByGender();
    }

    public List<CampaignGoalProgressDTO> getCampaignsNearingGoal() throws Exception {
        return dao.getFundraiserNearingGoal();
    }

    public List<ReceiptStatusDTO> getFundraiserReceiptIssuanceStatus() throws Exception {
        return dao.getFundraiserReceiptIssuanceStatus();
    }

    public List<ReceiptStatusDTO> getCampaignReceiptIssuanceStatus() throws Exception {
        return dao.getCampaignReceiptIssuanceStatus();
    }

    public List<DonorAcquisitionDTO> getDonorAcquisitionTrends() throws Exception {
        return dao.getDonorAcquisitionTrends();
    }
}
