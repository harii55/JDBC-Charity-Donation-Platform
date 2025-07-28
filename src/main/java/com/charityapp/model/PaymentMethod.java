package main.java.com.charityapp.model;
import main.java.com.charityapp.enums.PaymentMethodType;

import java.sql.Timestamp;

public class PaymentMethod {
    private int paymentMethodId;
    private int donorId;
    private PaymentMethodType methodType;
    private String details;
    private boolean isActive;
    private Timestamp createdAt;

    public PaymentMethod() {}

    public PaymentMethod(int paymentMethodId, int donorId, PaymentMethodType methodType, String details, boolean isActive,Timestamp createdAt) {
        this.paymentMethodId = paymentMethodId;
        this.donorId = donorId;
        this.methodType = methodType;
        this.details = details;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public PaymentMethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(PaymentMethodType methodType) {
        this.methodType = methodType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
