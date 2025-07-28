package main.java.com.charityapp.mapper;

import main.java.com.charityapp.dto.PaymentMethodDTO;
import main.java.com.charityapp.model.PaymentMethod;

public class PaymentMethodMapper {
    public static PaymentMethodDTO toDTO(PaymentMethod method) {
        PaymentMethodDTO dto = new PaymentMethodDTO();
        dto.setPaymentMethodId(method.getPaymentMethodId());
        dto.setDonorId(method.getDonorId());
        dto.setMethodType(method.getMethodType());
        dto.setDetails(method.getDetails());
        dto.setActive(method.isActive());
        return dto;
    }

    public static PaymentMethod toEntity(PaymentMethodDTO dto) {
        PaymentMethod method = new PaymentMethod();
        method.setPaymentMethodId(dto.getPaymentMethodId());
        method.setDonorId(dto.getDonorId());
        method.setMethodType(dto.getMethodType());
        method.setDetails(dto.getDetails());
        method.setActive(dto.isActive());
        return method;
    }
}
