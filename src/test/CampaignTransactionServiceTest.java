package test;

import main.java.com.charityapp.dto.CampaignTransactionDTO;
import main.java.com.charityapp.service.CampaignTransactionService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class CampaignTransactionServiceTest {
    public static void main(String[] args) {
        CampaignTransactionService service = new CampaignTransactionService();

        try {
            // ✅ 1. Make a donation
            CampaignTransactionDTO donation = new CampaignTransactionDTO();
            donation.setDonorId(1); // must exist
            donation.setCampaignId(1); // must exist
            donation.setAmount(new BigDecimal("500.00"));
            donation.setTimestamp(new Timestamp(System.currentTimeMillis()));
            donation.setReceiptStatus("SENT");

            boolean donated = service.makeCampaignDonation(donation);
            System.out.println("Donation Success: " + donated);

            // ✅ 2. Get transactions by campaign
            List<CampaignTransactionDTO> byCampaign = service.getTransactionsByCampaign(1);
            System.out.println("Transactions for Campaign 1: " + byCampaign.size());

            // ✅ 3. Get transactions by donor
            List<CampaignTransactionDTO> byDonor = service.getTransactionsByDonor(1);
            System.out.println("Transactions by Donor 1: " + byDonor.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
