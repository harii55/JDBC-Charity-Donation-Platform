package main.java.com.charityapp.service;

import main.java.com.charityapp.dao.PaymentMethodDAO;
import main.java.com.charityapp.dao.PaymentMethodDAOImpl;
import main.java.com.charityapp.dto.PaymentMethodDTO;
import main.java.com.charityapp.model.PaymentMethod;
import main.java.com.charityapp.mapper.PaymentMethodMapper;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodService {
    private final PaymentMethodDAO dao;

    public PaymentMethodService() {
        this.dao = new PaymentMethodDAOImpl();
    }

    public boolean addPaymentMethod(PaymentMethodDTO dto) {
        PaymentMethod pm = PaymentMethodMapper.toEntity(dto);
        return dao.createPaymentMethod(pm);
    }

    public List<PaymentMethodDTO> getPaymentMethodsByDonorId(int donorId) throws Exception {
        List<PaymentMethod> list = dao.getPaymentMethodsByDonorId(donorId);
        List<PaymentMethodDTO> dtoList = new ArrayList<>();
        for (PaymentMethod pm : list) {
            dtoList.add(PaymentMethodMapper.toDTO(pm));
        }
        return dtoList;
    }

    public boolean deactivatePaymentMethod(int id) {
        return dao.deactivatePaymentMethod(id);
    }
}
