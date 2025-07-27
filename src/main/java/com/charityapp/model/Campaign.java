package main.java.com.charityapp.model;

import java.sql.Date;

public class Campaign {
    private int campaignId;
    private int charityId;
    private String title;
    private String category;
    private String description;
    private String recUrl;
    private String ackUrl;
    private boolean isActive;
    private Date startDate;
    private Date endDate;

    public Campaign() {}

    public Campaign(int campaignId, int charityId, String title, String category, String description, String recUrl, String ackUrl, boolean isActive, Date startDate, Date endDate) {
        this.campaignId = campaignId;
        this.charityId = charityId;
        this.title = title;
        this.category = category;
        this.description = description;
        this.recUrl = recUrl;
        this.ackUrl = ackUrl;
        this.isActive = isActive;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}
