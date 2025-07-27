package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.FundraiserCampaignDTO;
import main.java.com.charityapp.model.FundraiserCampaign;

public class FundraiserCampaignMapper {
    public static FundraiserCampaign toEntity(FundraiserCampaignDTO dto) {
        FundraiserCampaign c = new FundraiserCampaign();
        c.setFcampaignId(dto.getFcampaignId());
        c.setCharityId(dto.getCharityId());
        c.setTitle(dto.getTitle());
        c.setCategory(dto.getCategory());
        c.setGoal(dto.getGoal());
        c.setStartDate(dto.getStartDate());
        c.setEndDate(dto.getEndDate());
        c.setActive(dto.isActive());
        c.setRecUrl(dto.getRecUrl());
        c.setAckUrl(dto.getAckUrl());
        c.setDescription(dto.getDescription());
        c.setCreatedAt(dto.getCreatedAt());
        return c;
    }

    public static FundraiserCampaignDTO toDTO(FundraiserCampaign c) {
        FundraiserCampaignDTO dto = new FundraiserCampaignDTO();
        dto.setFcampaignId(c.getFcampaignId());
        dto.setCharityId(c.getCharityId());
        dto.setTitle(c.getTitle());
        dto.setCategory(c.getCategory());
        dto.setGoal(c.getGoal());
        dto.setStartDate(c.getStartDate());
        dto.setEndDate(c.getEndDate());
        dto.setActive(c.isActive());
        dto.setRecUrl(c.getRecUrl());
        dto.setAckUrl(c.getAckUrl());
        dto.setDescription(c.getDescription());
        dto.setCreatedAt(c.getCreatedAt());
        return dto;
    }
}
