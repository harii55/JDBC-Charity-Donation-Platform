package main.java.com.charityapp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CampaignTransaction {
    private int transactionId;
    private int donorId;
    private int campaignId;
    private BigDecimal amount;
    private Timestamp timestamp;
    private String receiptStatus;

    public CampaignTransaction() {}

    public CampaignTransaction(int transactionId, int donorId, int campaignId, BigDecimal amount, Timestamp timestamp, String receiptStatus) {
        this.transactionId = transactionId;
        this.donorId = donorId;
        this.campaignId = campaignId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.receiptStatus = receiptStatus;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(String receiptStatus) {
        this.receiptStatus = receiptStatus;
    }
}
