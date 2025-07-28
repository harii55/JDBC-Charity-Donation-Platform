package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.FundraiserTransactionDAO;
import main.java.com.charityapp.dao.FundraiserTransactionDAOImpl;
import main.java.com.charityapp.dto.FundraiserTransactionDTO;
import main.java.com.charityapp.mapper.FundraiserTransactionMapper;
import main.java.com.charityapp.model.FundraiserTransaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FundraiserTransactionService {
    private FundraiserTransactionDAO transactionDAO;

    private FundraiserSummaryService fundraiserSummaryService;
    private DonorDonationSummaryService donorDonationSummaryService;
    public FundraiserTransactionService() throws Exception {
        this.fundraiserSummaryService = new FundraiserSummaryService();
        this.transactionDAO = new FundraiserTransactionDAOImpl();
        this.donorDonationSummaryService = new DonorDonationSummaryService();
    }

    public boolean makeFundraiserDonation(FundraiserTransactionDTO dto) throws Exception {
       boolean isSuccess = transactionDAO.makeFundraiserDonation(FundraiserTransactionMapper.toEntity(dto));
       if(isSuccess){
           fundraiserSummaryService.updateSummary(dto.getFcampaignId(),dto.getAmount());
           donorDonationSummaryService.updateDonorSummary(dto.getDonorId(), "FUNDRAISER" , dto.getAmount());

       }
       return isSuccess;
    }


    public List<FundraiserTransactionDTO> getTransactionsByFundraiser(int fundraiserId) throws SQLException {
        List<FundraiserTransaction> list = transactionDAO.getTransactionsByFundraiser(fundraiserId);
        List<FundraiserTransactionDTO> dtoList = new ArrayList<>();
        for (FundraiserTransaction ft : list) {
            dtoList.add(FundraiserTransactionMapper.toDTO(ft));
        }
        return dtoList;
    }

    public List<FundraiserTransactionDTO> getTransactionsByDonor(int donorId) throws SQLException {
        List<FundraiserTransaction> list = transactionDAO.getTransactionsByDonor(donorId);
        List<FundraiserTransactionDTO> dtoList = new ArrayList<>();
        for (FundraiserTransaction ft : list) {
            dtoList.add(FundraiserTransactionMapper.toDTO(ft));
        }
        return dtoList;
    }
}
