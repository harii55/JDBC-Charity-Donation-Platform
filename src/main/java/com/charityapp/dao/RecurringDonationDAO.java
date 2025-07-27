package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.RecurringDonation;
import java.sql.Date;
import java.util.List;

public interface RecurringDonationDAO {
    boolean createRecurringDonation(RecurringDonation r) throws Exception;
    List<RecurringDonation> getRecurringDonationsByDonorId(int donorId) throws Exception;
    boolean cancelRecurringDonation(int id) throws Exception;
    boolean updateNextInstallmentDate(int recurringDonationId, Date nextDate) throws Exception;
    List<RecurringDonation> getAllRecurringDonationsByCharityId(int charityId) throws Exception;
}
