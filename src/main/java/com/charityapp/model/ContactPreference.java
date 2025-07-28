package main.java.com.charityapp.model;

public class ContactPreference {
    private int id;
    private int donorId;
    private String contactVia;
    private String value;
    private int prefRank;
    private boolean isActive;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getDonorId() { return donorId; }
    public void setDonorId(int donorId) { this.donorId = donorId; }

    public String getContactVia() { return contactVia; }
    public void setContactVia(String contactVia) { this.contactVia = contactVia; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public int getPrefRank() { return prefRank; }
    public void setPrefRank(int prefRank) { this.prefRank = prefRank; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}