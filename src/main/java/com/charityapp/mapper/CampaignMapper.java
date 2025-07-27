package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.CampaignDTO;
import main.java.com.charityapp.model.Campaign;

public class CampaignMapper {
    public static Campaign toEntity(CampaignDTO dto) {
        return new Campaign(
                dto.getCampaignId(),
                dto.getCharityId(),
                dto.getTitle(),
                dto.getCategory(),
                dto.getDescription(),
                dto.getRecUrl(),
                dto.getAckUrl(),
                dto.isActive(),
                dto.getStartDate(),
                dto.getEndDate()
        );
    }

    public static CampaignDTO toDTO(Campaign campaign) {
        return new CampaignDTO(
                campaign.getCampaignId(),
                campaign.getCharityId(),
                campaign.getTitle(),
                campaign.getCategory(),
                campaign.getDescription(),
                campaign.getRecUrl(),
                campaign.getAckUrl(),
                campaign.isActive(),
                campaign.getStartDate(),
                campaign.getEndDate()
        );

    }
}
