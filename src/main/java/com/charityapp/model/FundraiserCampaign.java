package main.java.com.charityapp.model;

import java.sql.Date;
import java.sql.Timestamp;

public class FundraiserCampaign {
    private int fcampaignId;
    private int charityId;
    private String title;
    private String category;
    private double goal;
    private Date startDate;
    private Date endDate;
    private boolean isActive;
    private String recUrl;
    private String ackUrl;
    private String description;
    private Timestamp createdAt;

    public FundraiserCampaign() {}

    public FundraiserCampaign(int fcampaignId, int charityId, String title, String category, double goal, Date startDate, Date endDate, boolean isActive, String recUrl, String ackUrl, String description, Timestamp createdAt) {
        this.fcampaignId = fcampaignId;
        this.charityId = charityId;
        this.title = title;
        this.category = category;
        this.goal = goal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.recUrl = recUrl;
        this.ackUrl = ackUrl;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getFcampaignId() {
        return fcampaignId;
    }

    public void setFcampaignId(int fcampaignId) {
        this.fcampaignId = fcampaignId;
    }

    public int getCharityId() {
        return charityId;
    }

    public void setCharityId(int charityId) {
        this.charityId = charityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
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

    public String getRecUrl() {
        return recUrl;
    }

    public void setRecUrl(String recUrl) {
        this.recUrl = recUrl;
    }

    public String getAckUrl() {
        return ackUrl;
    }

    public void setAckUrl(String ackUrl) {
        this.ackUrl = ackUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
