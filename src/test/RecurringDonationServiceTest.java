package test;

import main.java.com.charityapp.dto.RecurringDonationDTO;
import main.java.com.charityapp.service.RecurringDonationService;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class RecurringDonationServiceTest {
    public static void main(String[] args) {
        RecurringDonationService service = new RecurringDonationService();

        try {
            // ✅ 1. Add new recurring donation
            RecurringDonationDTO newDonation = new RecurringDonationDTO();
            newDonation.setDonorId(1); // ⚠️ Must exist in DB
            newDonation.setEntityType("CAMPAIGN");
            newDonation.setEntityId(1001); // ⚠️ Ensure this exists or is optional
            newDonation.setCharityId(101); // ⚠️ Must exist
            newDonation.setRecurringRate("MONTHLY");
            newDonation.setAmount(new BigDecimal("500.00"));
            newDonation.setNextInstallment(Date.valueOf("2025-08-01"));
            newDonation.setStartDate(Date.valueOf("2025-07-25"));
            newDonation.setEndDate(Date.valueOf("2025-12-25"));
            newDonation.setActive(true);
            newDonation.setPrimaryPaymentMethodId(1); // ⚠️ Should be valid

            boolean added = service.createRecurringDonation(newDonation);
            System.out.println("Add recurring donation: " + (added ? "Success" : "Failed"));

            // ✅ 2. Fetch all recurring donations by donor
            List<RecurringDonationDTO> donorDonations = service.getRecurringDonationsByDonorId(1);
            System.out.println("Donor 1 has " + donorDonations.size() + " recurring donations.");
            for (RecurringDonationDTO r : donorDonations) {
                System.out.println(" - ID: " + r.getRecurringDonationId() + " | Amount: ₹" + r.getAmount());
            }

            // ✅ 3. Update next installment date
            if (!donorDonations.isEmpty()) {
                RecurringDonationDTO donation = donorDonations.get(0);
                Date newNextDate = Date.valueOf("2025-09-01");
                boolean updated = service.updateNextInstallmentDate(donation.getRecurringDonationId(), newNextDate);
                System.out.println("Update next installment date: " + (updated ? "Success" : "Failed"));
            }

            // ✅ 4. Cancel donation
            if (!donorDonations.isEmpty()) {
                int idToCancel = donorDonations.get(0).getRecurringDonationId();
                boolean cancelled = service.cancelRecurringDonation(idToCancel);
                System.out.println("Cancel recurring donation: " + (cancelled ? "Success" : "Failed"));
            }

            // ✅ 5. Get all recurring donations by charity
            List<RecurringDonationDTO> charityDonations = service.getAllRecurringDonationsByCharityId(101);
            System.out.println("Charity 101 has " + charityDonations.size() + " recurring donations.");
            for (RecurringDonationDTO r : charityDonations) {
                System.out.println(" - Donor ID: " + r.getDonorId() + " | Amount: ₹" + r.getAmount());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
