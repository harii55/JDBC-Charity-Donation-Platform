package test;

import main.java.com.charityapp.dto.CharityDTO;
import main.java.com.charityapp.service.CharityService;

import java.sql.Timestamp;
import java.util.List;

public class CharityServiceTest {
    public static void main(String[] args) {
        CharityService charityService = new CharityService();

        try {
            // ✅ 1. Add a new charity
            CharityDTO newCharity = new CharityDTO();
//            newCharity.setCharityId(109); // set using auto-increment
            newCharity.setName("Dear Trees with out id");
            newCharity.setEmail("contact@helpinghands.org");
            newCharity.setCategory("Healthcare");
            newCharity.setDescription("Helping Hands Foundation");
            newCharity.setWebsiteUrl("https://helpinghands.org");
            newCharity.setAckUrl("https://helpinghands.org/thanks");
            newCharity.setReceiptUrl("https://helpinghands.org/receipt");
            newCharity.setIs_active(true);
            newCharity.setPassword("charitySecurePass123"); // set hashed in real app
            newCharity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            System.out.println(newCharity.getName());
            boolean added = charityService.addCharity(newCharity);
            System.out.println("Add charity: " + (added ? "Success" : "Failed"));

            // ✅ 2. Get by ID
            CharityDTO fetched = charityService.getCharityById(1);
            if (fetched != null) {
                System.out.println("Fetched by ID: " + fetched.getName() + ", Email: " + fetched.getEmail());
            }

            // ✅ 3. Update
            fetched.setCategory("Disaster Relief");
            fetched.setIs_active(false);

            boolean updated = charityService.updateCharity(fetched);
            System.out.println("Update charity: " + (updated ? "Success" : "Failed"));

            // ✅ 4. Re-fetch to confirm update
            CharityDTO updatedCharity = charityService.getCharityById(fetched.getCharityId());
            if (updatedCharity != null) {
                System.out.println("Updated Category: " + updatedCharity.getCategory());
                System.out.println("Active Status: " + updatedCharity.isIs_active());
            }

            // ✅ 5. Get all charities
            List<CharityDTO> allCharities = charityService.getAllCharities();
            System.out.println("Total Charities: " + allCharities.size());
            for (CharityDTO c : allCharities) {
                System.out.println(" - " + c.getName() + " | Active: " + c.isIs_active());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
