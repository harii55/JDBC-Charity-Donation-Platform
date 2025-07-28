package test;

import main.java.com.charityapp.dto.ContactPreferenceDTO;
import main.java.com.charityapp.service.ContactPreferenceService;

import java.util.List;

public class ContactPrefTest {
    public static void main(String[] args) {
        try {
            ContactPreferenceService service = new ContactPreferenceService();

            // ✅ Add a new contact preference
            ContactPreferenceDTO dto = new ContactPreferenceDTO();
            dto.setDonorId(3); // Make sure donor with ID 1 exists
            dto.setContactVia("Email");
            dto.setValue("theprimary3.2");
//            dto.setPrefRank(1);

            boolean added = service.addContactPreference(dto);
            System.out.println("✅ Added: " + added);

            // ✅ Fetch preferences for the donor
            List<ContactPreferenceDTO> prefs = service.getPreferencesByDonorId(3);
            System.out.println("📋 All Preferences for Donor 1:");
            for (ContactPreferenceDTO pref : prefs) {
                System.out.println("  • " + pref.getContactVia() + " = " + pref.getValue());
            }

//             ✅ Get primary contact
            ContactPreferenceDTO primary = service.getPrimaryContactByDonorId(3);
            if (primary != null) {
                System.out.println("🌟 Primary Contact: " + primary.getContactVia() + " = " + primary.getValue());
            } else {
                System.out.println("⚠️ No primary contact found.");
            }

//            // ✅ Delete (soft) a contact preference
            if (!prefs.isEmpty()) {
                int idToDelete = prefs.get(0).getId();
                boolean deleted = service.deleteContactPreference(idToDelete);
                System.out.println("🗑️ Deleted ID " + idToDelete + ": " + deleted);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
