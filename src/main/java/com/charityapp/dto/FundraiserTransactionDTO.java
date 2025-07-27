package main.java.com.charityapp.dto;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class FundraiserTransactionDTO {
    private int transactionId;
    private int donorId;
    private int fcampaignId;
    private BigDecimal amount;
    private Timestamp timestamp;
    private String receiptStatus;

    public FundraiserTransactionDTO() {}

    public FundraiserTransactionDTO(int transactionId, int donorId, int fcampaignId, BigDecimal amount, Timestamp timestamp, String receiptStatus) {
        this.transactionId = transactionId;
        this.donorId = donorId;
        this.fcampaignId = fcampaignId;
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

    public int getFcampaignId() {
        return fcampaignId;
    }

    public void setFcampaignId(int fcampaignId) {
        this.fcampaignId = fcampaignId;
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
