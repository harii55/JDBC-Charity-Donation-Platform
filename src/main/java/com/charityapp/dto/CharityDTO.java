package main.java.com.charityapp.dto;

import java.sql.Timestamp;

public class CharityDTO {
    private int charityId;
    private String name;
    private String email;
    private String category;
    private String description;
    private String websiteUrl;
    private Timestamp createdAt;
    private String ackUrl;
    private String receiptUrl;
    private boolean is_active;
    private String password;

    public CharityDTO() {}

    public CharityDTO(int charityId, String name, String email, String category, String description, String websiteUrl, Timestamp createdAt, String ackUrl, String receiptUrl, boolean is_active, String password) {
        this.charityId = charityId;
        this.name = name;
        this.email = email;
        this.category = category;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.createdAt = createdAt;
        this.ackUrl = ackUrl;
        this.receiptUrl = receiptUrl;
        this.is_active = is_active;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getCharityId() {
        return charityId;
    }

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getAckUrl() {
        return ackUrl;
    }

    public void setAckUrl(String ackUrl) {
        this.ackUrl = ackUrl;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
