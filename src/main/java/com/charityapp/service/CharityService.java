package main.java.com.charityapp.service;
import main.java.com.charityapp.dao.CharityDAO;
import main.java.com.charityapp.dao.CharityDAOImpl;
import main.java.com.charityapp.dto.CharityDTO;
import main.java.com.charityapp.mapper.CharityMapper;
import main.java.com.charityapp.model.Charity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharityService {
    private CharityDAO charityDAO;

    public CharityService() {
        charityDAO = new CharityDAOImpl();
    }

    public boolean addCharity(CharityDTO dto) throws SQLException {
        return charityDAO.addCharity(CharityMapper.toEntity(dto,dto.getPassword()));
    }

    public boolean updateCharity(CharityDTO dto) throws SQLException {
        try {
            Charity existing = charityDAO.getCharityById(dto.getCharityId());
            if (existing == null) return false;

            // Keep createdAt from the original record
            dto.setCreatedAt(existing.getCreatedAt());

            Charity updated = CharityMapper.toEntity(dto,existing.getPassword());
            return charityDAO.updateCharity(updated);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public CharityDTO getCharityById(int id) throws SQLException {
        Charity c = charityDAO.getCharityById(id);
        if(c != null) {
            return CharityMapper.toDTO(c);
        }
        return null;

    }

    public List<CharityDTO> getAllCharities() throws SQLException {
        List<Charity> charities = charityDAO.getAllCharities();
        List<CharityDTO> dtos = new ArrayList<>();
        for (Charity c : charities) {
            dtos.add(CharityMapper.toDTO(c));
        }
        return dtos;
    }


}
