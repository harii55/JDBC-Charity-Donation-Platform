package main.java.com.charityapp.model;

import java.math.BigDecimal;
import java.sql.Date;

public class RecurringDonation {
    private int recurringDonationId;
    private int donorId;
    private String entityType;
    private int entityId;
    private int charityId;
    private String recurringRate;
    private BigDecimal amount;
    private Date lastInstallment;
    private Date nextInstallment;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    private int primaryPaymentMethodId;

    public RecurringDonation() {}
    public RecurringDonation(int recurringDonationId, int donorId, String entityType, int entityId, int charityId, String recurringRate, BigDecimal amount, Date lastInstallment, Date nextInstallment, Date startDate, Date endDate, boolean isActive, int primaryPaymentMethodId) {
        this.recurringDonationId = recurringDonationId;
        this.donorId = donorId;
        this.entityType = entityType;
        this.entityId = entityId;
        this.charityId = charityId;
        this.recurringRate = recurringRate;
        this.amount = amount;
        this.lastInstallment = lastInstallment;
        this.nextInstallment = nextInstallment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.primaryPaymentMethodId = primaryPaymentMethodId;
    }

    public int getRecurringDonationId() {
        return recurringDonationId;
    }

    public void setRecurringDonationId(int recurringDonationId) {
        this.recurringDonationId = recurringDonationId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getCharityId() {
        return charityId;
    }

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }

    public String getRecurringRate() {
        return recurringRate;
    }

    public void setRecurringRate(String recurringRate) {
        this.recurringRate = recurringRate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getLastInstallment() {
        return lastInstallment;
    }

    public void setLastInstallment(Date lastInstallment) {
        this.lastInstallment = lastInstallment;
    }

    public Date getNextInstallment() {
        return nextInstallment;
    }

    public void setNextInstallment(Date nextInstallment) {
        this.nextInstallment = nextInstallment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getPrimaryPaymentMethodId() {
        return primaryPaymentMethodId;
    }

    public void setPrimaryPaymentMethodId(int primaryPaymentMethodId) {
        this.primaryPaymentMethodId = primaryPaymentMethodId;
    }
}
