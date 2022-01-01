package Objects_Data;

public class RRRule {
    int ruleCode;
    int versionNumber;
    String rewardID;
    String bid;
    int points;

    public RRRule(String rewardID, String bid) {
        this.rewardID = rewardID;
        this.bid = bid;
    }

    public RRRule(int ruleCode, int versionNumber, String rewardID, String bid, int points) {
        this.ruleCode = ruleCode;
        this.versionNumber = versionNumber;
        this.rewardID = rewardID;
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

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
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
        return "RRRule{" +
                "ruleCode=" + ruleCode +
                ", versionNumber=" + versionNumber +
                ", rewardID='" + rewardID + '\'' +
                ", bid='" + bid + '\'' +
                ", points=" + points +
                '}';
    }
}
