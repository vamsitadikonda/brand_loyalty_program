package Objects_Data;

public class Reward {
    String bid;
    String rewardID;
    int rewardTypeID;
    int quantity;
    int amount=0;

    public Reward(String bid, String rewardID, int rewardTypeID, int quantity) {
        this.bid = bid;
        this.rewardID = rewardID;
        this.rewardTypeID = rewardTypeID;
        this.quantity = quantity;
    }

    public Reward(String bid, String rewardID, int rewardTypeID, int quantity, int amount) {
        this.bid = bid;
        this.rewardID = rewardID;
        this.rewardTypeID = rewardTypeID;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
    }

    public int getRewardTypeID() {
        return rewardTypeID;
    }

    public void setRewardTypeID(int rewardTypeID) {
        this.rewardTypeID = rewardTypeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "bid='" + bid + '\'' +
                ", rewardID='" + rewardID + '\'' +
                ", rewardTypeID=" + rewardTypeID +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}

