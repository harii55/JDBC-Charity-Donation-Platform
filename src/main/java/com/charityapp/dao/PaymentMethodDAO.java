package main.java.com.charityapp.dao;

import main.java.com.charityapp.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodDAO {
    boolean createPaymentMethod(PaymentMethod paymentMethod);
    List<PaymentMethod> getPaymentMethodsByDonorId(int donorId);
    boolean deactivatePaymentMethod(int id);
}
