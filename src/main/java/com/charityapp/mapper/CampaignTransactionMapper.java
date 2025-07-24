package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.CampaignTransactionDTO;
import main.java.com.charityapp.model.CampaignTransaction;

public class CampaignTransactionMapper {

    public static CampaignTransaction toEntity(CampaignTransactionDTO dto) {
        CampaignTransaction entity = new CampaignTransaction();
        entity.setTransactionId(dto.getTransactionId());
        entity.setDonorId(dto.getDonorId());
        entity.setCampaignId(dto.getCampaignId());
        entity.setAmount(dto.getAmount());
        entity.setTimestamp(dto.getTimestamp());
        entity.setReceiptStatus(dto.getReceiptStatus());
        return entity;
    }

    public static CampaignTransactionDTO toDTO(CampaignTransaction entity) {
        CampaignTransactionDTO dto = new CampaignTransactionDTO();
        dto.setTransactionId(entity.getTransactionId());
        dto.setDonorId(entity.getDonorId());
        dto.setCampaignId(entity.getCampaignId());
        dto.setAmount(entity.getAmount());
        dto.setTimestamp(entity.getTimestamp());
        dto.setReceiptStatus(entity.getReceiptStatus());
        return dto;
    }
}
