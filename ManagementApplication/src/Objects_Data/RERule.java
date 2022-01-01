package Objects_Data;

public class RERule {
    int ruleCode;
    int versionNumber;
    String activityID;
    String bid;
    int points;

    public RERule(String activityID, String bid) {
        this.activityID = activityID;
        this.bid = bid;
    }

    public RERule(int ruleCode, int versionNumber, String activityID, String bid, int points) {
        this.ruleCode = ruleCode;
        this.versionNumber = versionNumber;
        this.activityID = activityID;
        this.bid = bid;
        this.points = points;
    }

    public int getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(int ruleCode) {
        this.ruleCode = ruleCode;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "RERule{" +
                "ruleCode=" + ruleCode +
                ", versionNumber=" + versionNumber +
                ", activityID='" + activityID + '\'' +
                ", bid='" + bid + '\'' +
                ", points=" + points +
                '}';
    }
}
