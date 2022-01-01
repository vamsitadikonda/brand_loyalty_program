package DAO_DB;

import DB_Init.DBUtil;
import Objects_Data.Activity;
import Objects_Data.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
    public List<Wallet> getAllWalletEntries(String cid){
        List<Wallet> walletEntries = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Wallets WHERE CUSTOMERID = ?");
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Wallet wallet = new Wallet(rs.getInt("TRANSID"), rs.getString("BRANDID"),rs.getString("CUSTOMERID"),
                            rs.getString("ACTIVITYCODE"),rs.getString("ACTIVITYDATE"),rs.getString("ACTIVITYTYPE"),rs.getInt("ATYPEID"));
                walletEntries.add(wallet);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive all the activities of this brand !");
            e.printStackTrace();
        }

        return walletEntries;
    }
    public int addWalletEntry(Wallet wallet)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO WALLETS VALUES(DEFAULT ,?,?,?,DEFAULT ,?,DEFAULT )");
            //set parameters of query here but using the values for the product object
            ps.setString(1, wallet.getBid());
            ps.setString(2, wallet.getCid());
            ps.setString(3, wallet.getActivityID());
            ps.setString(4, wallet.getActivityType());

            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into Wallet falied !");
            e.printStackTrace();
        }
        return status;
    }
}
