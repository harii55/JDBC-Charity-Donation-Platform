package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.RecurringDonationDTO;
import main.java.com.charityapp.model.RecurringDonation;

public class RecurringDonationMapper {

    public static RecurringDonationDTO toDTO(RecurringDonation r) {
        RecurringDonationDTO dto = new RecurringDonationDTO();
        dto.setRecurringDonationId(r.getRecurringDonationId());
        dto.setDonorId(r.getDonorId());
        dto.setEntityType(r.getEntityType());
        dto.setEntityId(r.getEntityId());
        dto.setCharityId(r.getCharityId());
        dto.setRecurringRate(r.getRecurringRate());
        dto.setAmount(r.getAmount());
        dto.setLastInstallment(r.getLastInstallment());
        dto.setNextInstallment(r.getNextInstallment());
        dto.setStartDate(r.getStartDate());
        dto.setEndDate(r.getEndDate());
        dto.setActive(r.isActive());
        dto.setPrimaryPaymentMethodId(r.getPrimaryPaymentMethodId());
        return dto;
    }

    public static RecurringDonation toEntity(RecurringDonationDTO dto) {
        RecurringDonation r = new RecurringDonation();
        r.setRecurringDonationId(dto.getRecurringDonationId());
        r.setDonorId(dto.getDonorId());
        r.setEntityType(dto.getEntityType());
        r.setEntityId(dto.getEntityId());
        r.setCharityId(dto.getCharityId());
        r.setRecurringRate(dto.getRecurringRate());
        r.setAmount(dto.getAmount());
        r.setLastInstallment(dto.getLastInstallment());
        r.setNextInstallment(dto.getNextInstallment());
        r.setStartDate(dto.getStartDate());
        r.setEndDate(dto.getEndDate());
        r.setActive(dto.isActive());
        r.setPrimaryPaymentMethodId(dto.getPrimaryPaymentMethodId());
        return r;
    }
}
