package DAO_DB;

import DB_Init.DBUtil;
import Objects_Data.LoyaltyProgram;
import Objects_Data.TierProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyProgramDAO {
    public List<LoyaltyProgram> getAllLoyaltyProgram(int pState)
    {
        List<LoyaltyProgram> loyaltyPrograms = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM LOYALTYPROGRAM WHERE PSTATE = ?");
            ps.setInt(1, pState);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LoyaltyProgram loyaltyProgram = new LoyaltyProgram(rs.getInt("PSTATE"), rs.getString("LCODE"), rs.getString("BRANDID"), rs.getString("LNAME"), rs.getInt("ISTIER"));
                loyaltyPrograms.add(loyaltyProgram);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive active loyalty programs!");
            e.printStackTrace();
        }

        return loyaltyPrograms;
    }

    public List<LoyaltyProgram> getAllLoyaltyProgramsFromCID(String cid)
    {
        List<LoyaltyProgram> loyaltyPrograms = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT l.lname, l.brandID FROM loyaltyprogram l, CustomerTierStatus CTS WHERE l.brandID=CTS.brandID and CTS.customerID = ?");
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                LoyaltyProgram loyaltyProgram = new LoyaltyProgram(0, null, rs.getString("BRANDID"), rs.getString("LNAME"), 0);
                loyaltyPrograms.add(loyaltyProgram);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive active loyalty programs!");
            e.printStackTrace();
        }

        return loyaltyPrograms;
    }


    public int addLoyaltyProgram(LoyaltyProgram loyaltyProgram)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO loyaltyprogram VALUES(?,?,?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setInt(1, loyaltyProgram.getpState());
            ps.setString(2, loyaltyProgram.getlCode());
            ps.setString(3, loyaltyProgram.getBid());
            ps.setString(4, loyaltyProgram.getlName());
            ps.setInt(5, loyaltyProgram.getIsTier());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into loyalty program falied !");
            //e.printStackTrace();
        }
        return status;
    }
    public int updateLoyaltyProgram(String bid, int pState){
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("update loyaltyprogram set pstate = ? where brandid = ?");
            //set parameters of query here but using the values for the product object
            ps.setInt(1, pState);
            ps.setString(2,bid);
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database update into loyalty program falied !");
            //e.printStackTrace();
        }
        return status;
    }

    public LoyaltyProgram getLoyaltyProgram(String bid)
    {
        LoyaltyProgram loyaltyProgram =null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM LOYALTYPROGRAM WHERE BRANDID = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                loyaltyProgram = new LoyaltyProgram(rs.getInt("PSTATE"), rs.getString("LCODE"), rs.getString("BRANDID"), rs.getString("LNAME"), rs.getInt("ISTIER"));
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive the loyalty program of this brand !");
            e.printStackTrace();
        }

        return loyaltyProgram;
    }

}
