package Objects_Data;

public class UserAccount {

    //since this class holds the same data as the db table, it should have the same fields as the table
    String username;
    String password;
    int userType;
    String userID;

    public UserAccount(String username, String password, int userType, String userID) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", userID='" + userID + '\'' +
                '}';
    }
}

