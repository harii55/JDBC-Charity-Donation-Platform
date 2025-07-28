package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.ContactPreferenceDTO;
import main.java.com.charityapp.model.ContactPreference;

public class ContactPreferenceMapper {
    public static ContactPreference toModel(ContactPreferenceDTO dto) {
        ContactPreference cp = new ContactPreference();
        cp.setId(dto.getId());
        cp.setDonorId(dto.getDonorId());
        cp.setContactVia(dto.getContactVia());
        cp.setValue(dto.getValue());
        cp.setPrefRank(dto.getPrefRank());
        cp.setActive(true);
        return cp;
    }

    public static ContactPreferenceDTO toDTO(ContactPreference cp) {
        ContactPreferenceDTO dto = new ContactPreferenceDTO();
        dto.setId(cp.getId());
        dto.setDonorId(cp.getDonorId());
        dto.setContactVia(cp.getContactVia());
        dto.setValue(cp.getValue());
        dto.setPrefRank(cp.getPrefRank());
        return dto;
    }
}