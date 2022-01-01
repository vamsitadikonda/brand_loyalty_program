package Objects_Data;

public class Activity {
    String bid;
    String activityID;
    int activityTypeID;

    public Activity(String bid, String activityID, int activityTypeID) {
        this.bid = bid;
        this.activityID = activityID;
        this.activityTypeID = activityTypeID;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public int getActivityTypeID() {
        return activityTypeID;
    }

    public void setActivityTypeID(int activityTypeID) {
        this.activityTypeID = activityTypeID;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "bid='" + bid + '\'' +
                ", activityID='" + activityID + '\'' +
                ", activityTypeID=" + activityTypeID +
                '}';
    }
}
