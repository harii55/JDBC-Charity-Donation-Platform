package test;

import main.java.com.charityapp.dto.CampaignDTO;
import main.java.com.charityapp.service.CampaignService;

import java.sql.Date;
import java.util.List;

public class CampaignServiceTest {
    public static void main(String[] args) {
        CampaignService campaignService = new CampaignService();

        try {
            // ✅ 1. Add a new campaign
            CampaignDTO newCampaign = new CampaignDTO();
            newCampaign.setCharityId(1); // make sure this ID exists in DB
            newCampaign.setTitle("Tree Plantation Drive");
            newCampaign.setCategory("Environment");
            newCampaign.setDescription("Planting trees in urban areas");
            newCampaign.setRecUrl("https://green.org/receipt");
            newCampaign.setAckUrl("https://green.org/acknowledgement");
            newCampaign.setActive(true);
            newCampaign.setStartDate(Date.valueOf("2025-08-01"));
            newCampaign.setEndDate(Date.valueOf("2025-12-31"));

            boolean added = campaignService.addCampaign(newCampaign);
            System.out.println("Add campaign: " + (added ? "Success" : "Failed"));

            // ✅ 2. Fetch all campaigns
            List<CampaignDTO> all = campaignService.getAllCampaigns();
            System.out.println("Total Campaigns: " + all.size());
            for (CampaignDTO c : all) {
                System.out.println(" - " + c.getTitle() + " | Active: " + c.isActive());
            }

            // ✅ 3. Get by ID
            CampaignDTO first = all.get(0);
            CampaignDTO fetched = campaignService.getCampaignById(first.getCampaignId());
            if (fetched != null) {
                System.out.println("Fetched Campaign: " + fetched.getTitle() + " | ID: " + fetched.getCampaignId());
            }

            // ✅ 4. Update campaign
            fetched.setTitle("Tree Plantation Updated");
            fetched.setActive(false);
            boolean updated = campaignService.updateCampaign(fetched);
            System.out.println("Update campaign: " + (updated ? "Success" : "Failed"));

            // ✅ 5. Get updated campaign
            CampaignDTO updatedCampaign = campaignService.getCampaignById(fetched.getCampaignId());
            if (updatedCampaign != null) {
                System.out.println("Updated Title: " + updatedCampaign.getTitle());
                System.out.println("Active Status: " + updatedCampaign.isActive());
            }

            // ✅ 6. Soft delete campaign (set is_active = false)
            boolean deleted = campaignService.deleteCampaign(fetched.getCampaignId());
            System.out.println("Soft delete: " + (deleted ? "Success" : "Failed"));

            // ✅ 7. Fetch active campaigns only
            List<CampaignDTO> activeOnly = campaignService.getActiveCampaigns();
            System.out.println("Active Campaigns: " + activeOnly.size());

            // ✅ 8. Campaigns by charity
            List<CampaignDTO> byCharity = campaignService.getAllCampaignsByCharity(8);
            System.out.println("Campaigns by Charity: " + byCharity.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
