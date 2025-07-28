package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.DonorDonationSummaryDAO;
import main.java.com.charityapp.dao.DonorDonationSummaryDAOImpl;
import java.math.BigDecimal;


public class DonorDonationSummaryService {
    private DonorDonationSummaryDAO dao;

    public DonorDonationSummaryService() {
        dao = new DonorDonationSummaryDAOImpl();
    }

    public void updateDonorSummary(int donorId, String donationType, BigDecimal amount) {
        dao.updateDonorStats(donorId, donationType, amount);
    }
}
