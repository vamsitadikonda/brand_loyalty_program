package DAO_DB;


import java.sql.*;
import java.util.*;
import DB_Init.DBUtil;

import Objects_Data.UserAccount;

public class UserManagementDAO {

    //get all products method.  used List instead of ArrayList so it's better code management
    //incase we want to change productList ArrayList to a LinkedList, we don't have to change the jdbc code that much
    public List<UserAccount> getAllUserAccount()
    {
        List<UserAccount> userList = new ArrayList<UserAccount>();
        try
        {
            //typical jdbc coding
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM User");
            while(rs.next())
            {
                UserAccount user = new UserAccount(rs.getString("username"), rs.getString("password"), rs.getInt("User_Type"), rs.getString("USERID"));
                userList.add(user);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userList;
    }

    //different query
    public UserAccount getUserAccount(String username)
    {
        UserAccount user = null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM loginUser WHERE USERNAME = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                user = new UserAccount(rs.getString("USERNAME"), rs.getString("PASSWD"), rs.getInt("UTYPEID"), rs.getString("USERID"));
            }
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return user;
    }

    public int addUserAccount(UserAccount user)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO loginUser VALUES(?,?,?,DEFAULT)");
            //set parameters of query here but using the values for the product object
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUserType());
            status = ps.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    //updates a product already in the table
    public int updateUserAccount(UserAccount user)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE loginUser SET username=?, username=? WHERE username=?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUserType());
            status = ps.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    //deltes product already in the table
    public int deleteUser(String username)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM loginUser where username = ?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, username);
            status = ps.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

}//class