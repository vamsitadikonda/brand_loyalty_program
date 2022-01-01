package DAO_DB;


import java.sql.*;
import java.util.*;
import DB_Init.DBUtil;
import Objects_Data.Customer;
import Objects_Data.CustomerTierStatus;
import Objects_Data.UserAccount;

public class CustomerManagementDAO {

    //get all products method.  used List instead of ArrayList so it's better code management
    //incase we want to change productList ArrayList to a LinkedList, we don't have to change the jdbc code that much
//    public List<Customer> getAllCustomer()
//    {
//        List<Customer> customerList = new ArrayList<Customer>();
//        try
//        {
//            //typical jdbc coding
//            Connection conn = DBUtil.getConnection();
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM customer");
//            while(rs.next())
//            {
//                Customer customer = new Customer(rs.getString("cid"), rs.getString("customerName"), rs.getString("Address"), rs.getString("Wallet_ID"));
//                customerList.add(customer);
//            }
//            DBUtil.closeConnection();  //close connection
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return customerList;
//    }

    //different query
    public Customer getCustomerDetails(String cid)
    {
        Customer customer = null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CUSTOMERS WHERE CUSTOMERID = ?");
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                customer = new Customer(rs.getString("CUSTOMERID"), rs.getString("CNAME"), rs.getString("ADDRESS"), rs.getString("WALLETID"), rs.getString("PHONENO"));
            }
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return customer;
    }

    public int addCustomer(Customer customer, String userID)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CUSTOMERS VALUES(?,?,?,DEFAULT,?)");
            //set parameters of query here but using the values for the product object
            ps.setString(1, customer.getAddress());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getPhoneNumber());
            ps.setString(4, userID);
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
    public int updateCustomer(Customer customer)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE customer SET customer_name=?, cid=? WHERE cid=?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, customer.getCid());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getAddress());
            //ps.setString(4, customer.getWalletID());
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
    public int deleteCustomer(String cid)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM customer where cid = ?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, cid);
            status = ps.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    public int addCustomerTierStatus(CustomerTierStatus customerTierStatus){
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            System.out.println(customerTierStatus.getBid());
            System.out.println(customerTierStatus.getCid());
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CUSTOMERTIERSTATUS VALUES(?,?,DEFAULT ,DEFAULT,DEFAULT )");
            //set parameters of query here but using the values for the product object

            ps.setString(1, customerTierStatus.getBid());
            ps.setString(2, customerTierStatus.getCid());
            status = ps.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("Unable to insert into customerTierStatus table!");
            e.printStackTrace();
        }
        return status;

    }
}//class