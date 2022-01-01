package Objects_Data;

public class CustomerTierStatus {
    String bid;
    String cid;
    int totalPoints;
    int balance;
    String tierStatus;

    public CustomerTierStatus(String bid, String cid) {
        this.bid = bid;
        this.cid = cid;
    }

    public CustomerTierStatus(String bid, String cid, int totalPoints, int balance) {
        this.bid = bid;
        this.cid = cid;
        this.totalPoints = totalPoints;
        this.balance = balance;
    }

    public CustomerTierStatus(String bid, String cid, int totalPoints, int balance, String tierStatus) {
        this.bid = bid;
        this.cid = cid;
        this.totalPoints = totalPoints;
        this.balance = balance;
        this.tierStatus = tierStatus;
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

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getTierStatus() {
        return tierStatus;
    }

    public void setTierStatus(String tierStatus) {
        this.tierStatus = tierStatus;
    }

    @Override
    public String toString() {
        return "CustomerTierStatus{" +
                "bid='" + bid + '\'' +
                ", cid='" + cid + '\'' +
                ", totalPoints=" + totalPoints +
                ", balance=" + balance +
                ", tierStatus='" + tierStatus + '\'' +
                '}';
    }
}
