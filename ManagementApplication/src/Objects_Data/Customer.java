package Objects_Data;
/*POJO - plain old java object - classes which are supposed to hold data */
public class Customer {

    //since this class holds the same data as the db table, it should have the same fields as the table
    String cid;
    String customerName;
    String Address;
    String walletID;
    String userName;
    String phoneNumber;

    public Customer(String cid, String customerName, String address, String walletID, String userName, String phoneNumber) {
        this.cid = cid;
        this.customerName = customerName;
        Address = address;
        this.walletID = walletID;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String cid, String customerName, String address, String walletID, String phoneNumber) {
        this.cid = cid;
        this.customerName = customerName;
        Address = address;
        this.walletID = walletID;
        this.phoneNumber = phoneNumber;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid='" + cid + '\'' +
                ", customerName='" + customerName + '\'' +
                ", Address='" + Address + '\'' +
                ", walletID='" + walletID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}