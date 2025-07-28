package test;

import main.java.com.charityapp.dto.FundraiserCampaignDTO;
import main.java.com.charityapp.service.FundraiserCampaignService;

import java.sql.Date;
import java.util.List;

public class FundraiserServiceTest {
    public static void main(String[] args) {
        FundraiserCampaignService service = new FundraiserCampaignService();

        try {
            // ✅ 1. Add new fundraiser campaign
            FundraiserCampaignDTO newCampaign = new FundraiserCampaignDTO();
            newCampaign.setCharityId(1); // ⚠️ Make sure this ID exists in your DB
            newCampaign.setTitle("Monsoon Relief Fund");
            newCampaign.setCategory("Disaster Relief");
            newCampaign.setGoal(100000);
            newCampaign.setStartDate(Date.valueOf("2025-08-01"));
            newCampaign.setEndDate(Date.valueOf("2025-11-01"));
            newCampaign.setRecUrl("https://relief.org/receipt");
            newCampaign.setAckUrl("https://relief.org/thanks");
            newCampaign.setDescription("Providing aid for monsoon-affected families");
            newCampaign.setActive(true);

            boolean added = service.addfCampaign(newCampaign);
            System.out.println("Add fundraiser campaign: " + (added ? "Success" : "Failed"));

            // ✅ 2. Fetch all fundraiser campaigns
            List<FundraiserCampaignDTO> all = service.getAllfCampaigns();
            System.out.println("Total Fundraiser Campaigns: " + all.size());
            for (FundraiserCampaignDTO c : all) {
                System.out.println(" - " + c.getTitle() + " | Goal: " + c.getGoal() + " | Active: " + c.isActive());
            }

            // ✅ 3. Get campaign by ID
            FundraiserCampaignDTO first = all.get(0);
            FundraiserCampaignDTO fetched = service.getfCampaignById(first.getFcampaignId());
            if (fetched != null) {
                System.out.println("Fetched Fundraiser Campaign: " + fetched.getTitle() + " | ID: " + fetched.getFcampaignId());
            }

            // ✅ 4. Update campaign
            fetched.setTitle("Monsoon Relief Updated");
            fetched.setActive(false);
            boolean updated = service.updatefCampaign(fetched);
            System.out.println("Update campaign: " + (updated ? "Success" : "Failed"));

            // ✅ 5. Confirm update
            FundraiserCampaignDTO updatedCampaign = service.getfCampaignById(fetched.getFcampaignId());
            if (updatedCampaign != null) {
                System.out.println("Updated Title: " + updatedCampaign.getTitle());
                System.out.println("Active Status: " + updatedCampaign.isActive());
            }

            // ✅ 6. Soft delete campaign
            boolean deleted = service.deletefCampaign(fetched.getFcampaignId());
            System.out.println("Soft delete campaign: " + (deleted ? "Success" : "Failed"));

            // ✅ 7. Get active campaigns only
            List<FundraiserCampaignDTO> activeCampaigns = service.getActivefCampaigns();
            System.out.println("Active Fundraiser Campaigns: " + activeCampaigns.size());

            // ✅ 8. Get all campaigns by charity
            List<FundraiserCampaignDTO> charityCampaigns = service.getAllfCampaignsByCharity(101);
            System.out.println("Total by Charity 101: " + charityCampaigns.size());

            // ✅ 9. Get active campaigns by charity
            List<FundraiserCampaignDTO> activeByCharity = service.getActivefCampaignsByCharity(101);
            System.out.println("Active by Charity 101: " + activeByCharity.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
