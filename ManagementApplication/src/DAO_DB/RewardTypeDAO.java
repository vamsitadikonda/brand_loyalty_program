package DAO_DB;

import DB_Init.DBUtil;
import Objects_Data.RewardType;
import Objects_Data.Customer;
import java.sql.*;
import java.util.*;
import DB_Init.DBUtil;
import Objects_Data.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RewardTypeDAO {
    public List<RewardType> getAllRewardType()
    {
        List<RewardType> RewardList = new ArrayList<RewardType>();
        try
        {
            //typical jdbc coding
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM RewardTypes");
            while(rs.next())
            {
                RewardType rewardType = new RewardType( rs.getString("RTYPENAME"), rs.getInt("RTYPEID"));
                RewardList.add(rewardType);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return RewardList;
    }

    public int addRewardType(RewardType rewardType)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO REWARDTYPES VALUES(?,?)");
            //set parameters of query here but using the values for the product object
            ps.setInt(1, rewardType.getRewardCode());
            ps.setString(2, rewardType.getRewardName());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion falied !");
        }
        return status;
    }
}
