package test;

import main.java.com.charityapp.dto.FundraiserTransactionDTO;
import main.java.com.charityapp.service.FundraiserTransactionService;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class FundraiserTransactionServiceTest {
    public static void main(String[] args) throws Exception {
        FundraiserTransactionService service = new FundraiserTransactionService();

        try {
            // ✅ 1. Make a donation
            FundraiserTransactionDTO donation = new FundraiserTransactionDTO();
            donation.setDonorId(1); // must exist
            donation.setFcampaignId(2); // must exist
            donation.setAmount(new BigDecimal("80000.00"));
            donation.setTimestamp(new Timestamp(System.currentTimeMillis()));
            donation.setReceiptStatus("PENDING");

            boolean donated = service.makeFundraiserDonation(donation);
            System.out.println("Fundraiser Donation Success: " + donated);

            // ✅ 2. Get transactions by fundraiser
            List<FundraiserTransactionDTO> byFundraiser = service.getTransactionsByFundraiser(1);
            System.out.println("Transactions for Fundraiser 1: " + byFundraiser.size());

            // ✅ 3. Get transactions by donor
            List<FundraiserTransactionDTO> byDonor = service.getTransactionsByDonor(1);
            System.out.println("Transactions by Donor 1: " + byDonor.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
