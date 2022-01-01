package Objects_Data;

public class LoyaltyProgram {
    int pState;
    String lCode;
    String bid;
    String lName;
    int isTier;

    public LoyaltyProgram(int pState, String lCode, String bid, String lName, int isTier) {
        this.pState = pState;
        this.lCode = lCode;
        this.bid = bid;
        this.lName = lName;
        this.isTier = isTier;
    }

    public int getpState() {
        return pState;
    }

    public void setpState(int pState) {
        this.pState = pState;
    }

    public String getlCode() {
        return lCode;
    }

    public void setlCode(String lCode) {
        this.lCode = lCode;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getIsTier() {
        return isTier;
    }

    public void setIsTier(int isTier) {
        this.isTier = isTier;
    }

    @Override
    public String toString() {
        return "LoyaltyProgram{" +
                "pState=" + pState +
                ", lCode='" + lCode + '\'' +
                ", bid='" + bid + '\'' +
                ", lName='" + lName + '\'' +
                ", isTier=" + isTier +
                '}';
    }
}
