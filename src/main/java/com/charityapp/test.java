package main.java.com.charityapp;

import main.java.com.charityapp.dto.DonorDTO;
import main.java.com.charityapp.enums.Gender;
import main.java.com.charityapp.model.Donor;
import main.java.com.charityapp.service.DonorService;

import java.sql.Timestamp;
import java.time.Instant;

    public class test {

        public static void main(String[] args) {
            DonorService donorService = new DonorService();

            try {
                // Step 1: Add a new donor (optional if already present)
                Donor newDonor = new Donor(
                        0, // Let DB auto-increment
                        "Test User5",
                        "testuser@example.com",
                        "securePassword12893",
                        "Mumbai",
                        "Maharashtra",
                        "India",
                        25,
                        Gender.FEMALE,
                        "5-10LPA",
                        Timestamp.from(Instant.now())
                );

                boolean added = donorService.addDonor(newDonor);
                System.out.println(added ? "✅ Donor added." : "❌ Failed to add donor.");
                System.out.println(newDonor.getPassword());

                // Step 2: Fetch by email
                DonorDTO dto = donorService.getDonarByEmail("testuser@example.com");
                if (dto != null) {
                    System.out.println("🎯 Donor found: " + dto.getName() + " from " + dto.getCity());
                } else {
                    System.out.println("❌ Donor not found.");
                    return;
                }

                System.out.println(dto.getPassword());

                // Step 3: Update donor
                dto.setCity("Pune");
                dto.setAge(26);
                dto.setState("Maharashtra");
                dto.setIncomeRange("10-15LPA");

                boolean updated = donorService.updateDonor(dto);
                System.out.println(updated ? "✅ Donor updated." : "❌ Donor update failed.");

                // Step 4: Fetch again to verify update
                DonorDTO updatedDTO = donorService.getDonarByEmail("testuser@example.com");
                if (updatedDTO != null) {
                    System.out.println("✅ Updated Info:");
                    System.out.println("Name: " + updatedDTO.getName());
                    System.out.println("City: " + updatedDTO.getCity());
                    System.out.println("Age: " + updatedDTO.getAge());
                    System.out.println("Income Range: " + updatedDTO.getIncomeRange());
                    System.out.println("Password: " + updatedDTO.getPassword());
                    System.out.println("Email: " + updatedDTO.getEmail());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

