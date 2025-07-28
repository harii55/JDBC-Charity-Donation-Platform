package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.ContactPreferenceDAO;
import main.java.com.charityapp.dao.ContactPreferenceDAOImpl;
import main.java.com.charityapp.dto.ContactPreferenceDTO;
import main.java.com.charityapp.mapper.ContactPreferenceMapper;
import main.java.com.charityapp.model.ContactPreference;
import java.util.ArrayList;
import java.util.List;

public class ContactPreferenceService {
    private final ContactPreferenceDAO dao = new ContactPreferenceDAOImpl();

    public boolean addContactPreference(ContactPreferenceDTO dto) throws Exception {
        return dao.addContactPreference(ContactPreferenceMapper.toModel(dto));
    }

    public boolean deleteContactPreference(int id) throws Exception {
        return dao.deleteContactPreference(id);
    }

    public List<ContactPreferenceDTO> getPreferencesByDonorId(int donorId) throws Exception {
        List<ContactPreference> list = dao.getPreferencesByDonorId(donorId);
        List<ContactPreferenceDTO> dtos = new ArrayList<>();
        for (ContactPreference cp : list) {
            dtos.add(ContactPreferenceMapper.toDTO(cp));
        }
        return dtos;
    }

    public ContactPreferenceDTO getPrimaryContactByDonorId(int donorId) throws Exception {
        ContactPreference cp = dao.getPrimaryContactByDonorId(donorId);
        return (cp != null) ? ContactPreferenceMapper.toDTO(cp) : null;
    }
}
