package test;

import main.java.com.charityapp.dto.TestingQueriesDTO.*;
import main.java.com.charityapp.service.TestingQueriesService;

import java.util.List;

public class TestingQueriesServiceTest {
    public static void main(String[] args) {
        try {
            TestingQueriesService service = new TestingQueriesService();

            // 1. Total Donations per Campaign
            System.out.println("=== Total Donations per Campaign ===");
            List<CampaignDonationDTO> campaignDonations = service.getTotalDonationsPerCampaign();
            for (CampaignDonationDTO dto : campaignDonations) {
                System.out.println("Campaign: " + dto.getCampaignTitle() + ", Total Donated: ₹" + dto.getTotalDonated());
            }

            // 2. Average Donation by Age
            System.out.println("\n=== Average Donation by Age Segment ===");
            List<DonorSegmentDTO> ageSegments = service.getAvgDonationByAge();
            for (DonorSegmentDTO dto : ageSegments) {
                System.out.println("Age Segment: " + dto.getDonorSegment() + ", Avg Donation: ₹" + dto.getAverageAmount());
            }

            // 3. Average Donation by Income Range
            System.out.println("\n=== Average Donation by Income Range ===");
            List<DonorSegmentDTO> incomeSegments = service.getAvgDonationByIncomeRange();
            for (DonorSegmentDTO dto : incomeSegments) {
                System.out.println("Income Range: " + dto.getDonorSegment() + ", Avg Donation: ₹" + dto.getAverageAmount());
            }

            // 4. Average Donation by Gender
            System.out.println("\n=== Average Donation by Gender ===");
            List<DonorSegmentDTO> genderSegments = service.getAvgDonationByGender();
            for (DonorSegmentDTO dto : genderSegments) {
                System.out.println("Gender: " + dto.getDonorSegment() + ", Avg Donation: ₹" + dto.getAverageAmount());
            }

            // 5. Fundraiser Campaigns Nearing Goal
            System.out.println("\n=== Fundraiser Campaigns Nearing Goal ===");
            List<CampaignGoalProgressDTO> nearGoals = service.getCampaignsNearingGoal();
            for (CampaignGoalProgressDTO dto : nearGoals) {
                System.out.println("Campaign: " + dto.getTitle() + ", Raised: ₹" + dto.getTotalRaised() + ", Goal: ₹" + dto.getGoal());
            }

            // 6. Fundraiser Receipt Issuance Status
            System.out.println("\n=== Fundraiser Receipt Issuance Status ===");
            List<ReceiptStatusDTO> fundraiserReceipts = service.getFundraiserReceiptIssuanceStatus();
            for (ReceiptStatusDTO dto : fundraiserReceipts) {
                System.out.println("Fundraiser: " + dto.getReceiptStatus() +
                        ", Total Receipts: " + dto.getCount() +
                        ", Pending: " + dto.getPendingCount());
            }

            // 7. Campaign Receipt Issuance Status
            System.out.println("\n=== Campaign Receipt Issuance Status ===");
            List<ReceiptStatusDTO> campaignReceipts = service.getCampaignReceiptIssuanceStatus();
            for (ReceiptStatusDTO dto : campaignReceipts) {
                System.out.println("Campaign: " + dto.getReceiptStatus() +
                        ", Total Receipts: " + dto.getCount() +
                        ", Pending: " + dto.getPendingCount());
            }

            // 8. Donor Acquisition Trends
            System.out.println("\n=== Donor Acquisition Trends ===");
            List<DonorAcquisitionDTO> acquisitions = service.getDonorAcquisitionTrends();
            for (DonorAcquisitionDTO dto : acquisitions) {
                System.out.println("Month: " + dto.getDateJoined() + ", New Donors: " + dto.getCount());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
