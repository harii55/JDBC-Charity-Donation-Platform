package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.DonorDTO;
import main.java.com.charityapp.model.Donor;

public class DonorMapper {
    public static DonorDTO toDTO(Donor d) {
        DonorDTO dto = new DonorDTO();
        dto.setDonorId(d.getDonorId());
        dto.setName(d.getName());
        dto.setEmail(d.getEmail());
        dto.setCity(d.getCity());
        dto.setPassword(d.getPassword());
        dto.setState(d.getState());
        dto.setCountry(d.getCountry());
        dto.setAge(d.getAge());
        dto.setGender(d.getGender());
        dto.setIncomeRange(d.getIncomeRange());
        dto.setCreatedAt(d.getCreatedAt());
        return dto;
    }
    public static Donor toEntity(DonorDTO dto, String password) {
        return new Donor(
                dto.getDonorId(),
                dto.getName(),
                dto.getEmail(),
                password,
                dto.getCity(),
                dto.getState(),
                dto.getCountry(),
                dto.getAge(),
                dto.getGender(),
                dto.getIncomeRange(),
                dto.getCreatedAt()
        );
    }
}
