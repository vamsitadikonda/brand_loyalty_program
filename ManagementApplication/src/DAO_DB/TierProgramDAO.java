package DAO_DB;

import DB_Init.DBUtil;
import Objects_Data.LoyaltyProgram;
import Objects_Data.Reward;
import Objects_Data.TierProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TierProgramDAO {
    public List<TierProgram> getAllTierPrograms(String bid)
    {
        List<TierProgram> tierPrograms = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TIERPROGRAM WHERE BRANDID = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                TierProgram tierProgram = new TierProgram(rs.getString("BRANDID"), rs.getInt("LEVELNO"), rs.getInt("MULTIPLIER"), rs.getInt("POINTSREQ"), rs.getString("LNAME"));
                tierPrograms.add(tierProgram);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive all the tierprograms of this brand !");
            e.printStackTrace();
        }

        return tierPrograms;
    }

    public int addTierProgram(TierProgram tierProgram)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO TIERPROGRAM VALUES(?,?,?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setString(1, tierProgram.getBid());
            ps.setInt(2, tierProgram.getLevelNumber());
            ps.setInt(3, tierProgram.getMultiplier());
            ps.setInt(4, tierProgram.getPointsRequired());
            ps.setString(5, tierProgram.getlName());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into tier program falied !");
        }
        return status;
    }

}
