package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.CharityDTO;
import main.java.com.charityapp.model.Charity;

import java.sql.SQLException;

public class CharityMapper {
    //dto will not have password that's why we need to parse it seperatly [ Eventually ]
    public static Charity toEntity(CharityDTO dto,String password) throws SQLException {
        return new Charity(
                dto.getCharityId(),
                dto.getName(),
                dto.getEmail(),
                dto.getCategory(),
                dto.getDescription(),
                dto.getWebsiteUrl(),
                dto.getCreatedAt(),
                dto.getAckUrl(),
                dto.getReceiptUrl(),
                dto.isIs_active(),
                password
        );
    }

    public static CharityDTO toDTO(Charity charity) {
        if (charity == null) return null;

        CharityDTO dto = new CharityDTO();
        dto.setCharityId(charity.getCharityId());
        dto.setName(charity.getName());
        dto.setEmail(charity.getEmail());
        dto.setCategory(charity.getCategory());
        dto.setDescription(charity.getDescription());
        dto.setWebsiteUrl(charity.getWebsiteUrl());
        dto.setCreatedAt(charity.getCreatedAt());
        dto.setAckUrl(charity.getAckUrl());
        dto.setReceiptUrl(charity.getReceiptUrl());
        dto.setIs_active(charity.isIs_active());
        dto.setPassword(charity.getPassword());

        return dto;
    }

}
