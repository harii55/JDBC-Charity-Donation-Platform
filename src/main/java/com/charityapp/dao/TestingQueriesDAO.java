package main.java.com.charityapp.dao;

import main.java.com.charityapp.dto.TestingQueriesDTO.*;

import java.util.List;

public interface TestingQueriesDAO {
    List<CampaignDonationDTO> getTotalDonationsPerCampaign() throws Exception;
    List<DonorSegmentDTO> getAvgDonationByAge() throws Exception;
    List<DonorSegmentDTO> getAvgDonationByIncomeRange() throws Exception;
    List<DonorSegmentDTO> getAvgDonationByGender() throws Exception;
    List<CampaignGoalProgressDTO> getFundraiserNearingGoal() throws Exception;
    List<ReceiptStatusDTO> getFundraiserReceiptIssuanceStatus() throws Exception;
    List<ReceiptStatusDTO> getCampaignReceiptIssuanceStatus() throws Exception;
    List<DonorAcquisitionDTO> getDonorAcquisitionTrends() throws Exception;
}
