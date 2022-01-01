package Objects_Data;

public class TierProgram {
    String bid;
    int levelNumber;
    int multiplier;
    int pointsRequired;
    String lName;

    public TierProgram(String bid, int levelNumber, int multiplier, int pointsRequired, String lName) {
        this.bid = bid;
        this.levelNumber = levelNumber;
        this.multiplier = multiplier;
        this.pointsRequired = pointsRequired;
        this.lName = lName;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getPointsRequired() {
        return pointsRequired;
    }

    public void setPointsRequired(int pointsRequired) {
        this.pointsRequired = pointsRequired;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "TierProgram{" +
                "bid='" + bid + '\'' +
                ", levelNumber=" + levelNumber +
                ", multiplier=" + multiplier +
                ", pointsRequired=" + pointsRequired +
                ", lName='" + lName + '\'' +
                '}';
    }
}
