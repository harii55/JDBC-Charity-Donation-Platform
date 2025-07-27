package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.FundraiserTransactionDTO;
import main.java.com.charityapp.model.FundraiserTransaction;

public class FundraiserTransactionMapper {

    public static FundraiserTransaction toEntity(FundraiserTransactionDTO dto) {
        FundraiserTransaction entity = new FundraiserTransaction();
        entity.setTransactionId(dto.getTransactionId());
        entity.setDonorId(dto.getDonorId());
        entity.setFcampaignId(dto.getFcampaignId());
        entity.setAmount(dto.getAmount());
        entity.setTimestamp(dto.getTimestamp());
        entity.setReceiptStatus(dto.getReceiptStatus());
        return entity;
    }

    public static FundraiserTransactionDTO toDTO(FundraiserTransaction entity) {
        FundraiserTransactionDTO dto = new FundraiserTransactionDTO();
        dto.setTransactionId(entity.getTransactionId());
        dto.setDonorId(entity.getDonorId());
        dto.setFcampaignId(entity.getFcampaignId());
        dto.setAmount(entity.getAmount());
        dto.setTimestamp(entity.getTimestamp());
        dto.setReceiptStatus(entity.getReceiptStatus());
        return dto;
    }
}
