package Objects_Data;

public class Wallet {
    int transactionID;
    String bid;
    String cid;
    String activityID;
    String activityDate;
    String activityType;
    int activityPoints;

    public Wallet(int transactionID, String bid, String cid, String activityID, String activityDate, String activityType, int activityPoints) {
        this.transactionID = transactionID;
        this.bid = bid;
        this.cid = cid;
        this.activityID = activityID;
        this.activityDate = activityDate;
        this.activityType = activityType;
        this.activityPoints = activityPoints;
    }

    public Wallet(String bid, String cid, String activityID, String activityDate, String activityType) {
        this.bid = bid;
        this.cid = cid;
        this.activityID = activityID;
        this.activityDate = activityDate;
        this.activityType = activityType;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public int getActivityPoints() {
        return activityPoints;
    }

    public void setActivityPoints(int activityPoints) {
        this.activityPoints = activityPoints;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "transactionID=" + transactionID +
                ", bid='" + bid + '\'' +
                ", cid='" + cid + '\'' +
                ", activityID='" + activityID + '\'' +
                ", activityDate='" + activityDate + '\'' +
                ", activityType='" + activityType + '\'' +
                ", activityPoints=" + activityPoints +
                '}';
    }
}
