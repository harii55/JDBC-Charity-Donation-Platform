package main.java.com.charityapp.dto;

public class TestingQueriesDTO {

    // DTO for total donations per campaign
    public static class CampaignDonationDTO {
        private String campaignTitle;
        private double totalDonated;

        public CampaignDonationDTO() {}

        public CampaignDonationDTO(String campaignTitle, double totalDonated) {
            this.campaignTitle = campaignTitle;
            this.totalDonated = totalDonated;
        }

        public String getCampaignTitle() {
            return campaignTitle;
        }

        public void setCampaignTitle(String campaignTitle) {
            this.campaignTitle = campaignTitle;
        }

        public double getTotalDonated() {
            return totalDonated;
        }

        public void setTotalDonated(double totalDonated) {
            this.totalDonated = totalDonated;
        }
    }

    // DTO for donor segment-based averages
    public static class DonorSegmentDTO {
        private String donorSegment;
        private double averageAmount;

        public DonorSegmentDTO() {}

        public DonorSegmentDTO(String donorSegment, double averageAmount) {
            this.donorSegment = donorSegment;
            this.averageAmount = averageAmount;
        }

        public String getDonorSegment() {
            return donorSegment;
        }

        public void setDonorSegment(String donorSegment) {
            this.donorSegment = donorSegment;
        }

        public double getAverageAmount() {
            return averageAmount;
        }

        public void setAverageAmount(double averageAmount) {
            this.averageAmount = averageAmount;
        }
    }

    // DTO for tracking fundraiser progress toward goal
    public static class CampaignGoalProgressDTO {
        private String title;
        private double totalRaised;
        private double goal;

        public CampaignGoalProgressDTO() {}

        public CampaignGoalProgressDTO(String title, double totalRaised, double goal) {
            this.title = title;
            this.totalRaised = totalRaised;
            this.goal = goal;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getTotalRaised() {
            return totalRaised;
        }

        public void setTotalRaised(double totalRaised) {
            this.totalRaised = totalRaised;
        }

        public double getGoal() {
            return goal;
        }

        public void setGoal(double goal) {
            this.goal = goal;
        }
    }

    // DTO for receipt issuance status
    public static class ReceiptStatusDTO {
        private String receiptStatus;
        private int count;
        private int pendingCount;

        public ReceiptStatusDTO() {}

        public ReceiptStatusDTO(String receiptStatus, int count, int pendingCount) {
            this.receiptStatus = receiptStatus;
            this.count = count;
            this.pendingCount = pendingCount;
        }

        public String getReceiptStatus() {
            return receiptStatus;
        }

        public void setReceiptStatus(String receiptStatus) {
            this.receiptStatus = receiptStatus;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPendingCount() {
            return pendingCount;
        }

        public void setPendingCount(int pendingCount) {
            this.pendingCount = pendingCount;
        }
    }

    // DTO for donor acquisition trends
    public static class DonorAcquisitionDTO {
        private String dateJoined;
        private int count;

        public DonorAcquisitionDTO() {}

        public DonorAcquisitionDTO(String dateJoined, int count) {
            this.dateJoined = dateJoined;
            this.count = count;
        }

        public String getDateJoined() {
            return dateJoined;
        }

        public void setDateJoined(String dateJoined) {
            this.dateJoined = dateJoined;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
