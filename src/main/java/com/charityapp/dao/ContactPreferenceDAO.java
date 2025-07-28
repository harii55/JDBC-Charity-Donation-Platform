package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.ContactPreference;
import java.util.List;

public interface ContactPreferenceDAO {
    boolean addContactPreference(ContactPreference cp) throws Exception;
    boolean deleteContactPreference(int id) throws Exception;
    List<ContactPreference> getPreferencesByDonorId(int donorId) throws Exception;
    ContactPreference getPrimaryContactByDonorId(int donorId) throws Exception;
}
