package Objects_Data;
/*POJO - plain old java object - classes which are supposed to hold data */
public class RewardType {

    //since this class holds the same data as the db table, it should have the same fields as the table
    String rewardName;
    int rewardCode;
    String rewardID;

    public RewardType(String rewardName, int rewardCode) {
        this.rewardName = rewardName;
        this.rewardCode = rewardCode;
    }

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public int getRewardCode() {
        return rewardCode;
    }

    public void setRewardCode(int rewardCode) {
        this.rewardCode = rewardCode;
    }

    @Override
    public String toString() {
        return "RewardType{" +
                "rewardName='" + rewardName + '\'' +
                ", rewardCode=" + rewardCode +
                '}';
    }
}