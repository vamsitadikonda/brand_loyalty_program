package DAO_DB;
import DB_Init.DBUtil;
import Objects_Data.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RewardsDAO {

    public List<RewardType> getAllRewardTypes(String bid)
    {

        List<RewardType> rewardTypes = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("select p.rtypename, a.rewardID, a.RtypeID from rewards a, rewardTypes p where p.rtypeID = a.rtypeID and brandId = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                RewardType rewardType = new RewardType(rs.getString("RTYPENAME"), rs.getInt("RYPEID"));
                rewardType.setRewardID(rs.getString("RewardID"));
                rewardTypes.add(rewardType);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive all the activities of this brand !");
            e.printStackTrace();
        }

        return rewardTypes;
    }


    public List<Reward> getAllRewards(String bid)
    {
        List<Reward> rewards = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM REWARDS WHERE BRANDID = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Reward reward = new Reward(rs.getString("BRANDID"), rs.getString("REWARDID"), rs.getInt("RTYPEID"), rs.getInt("QUANTITY"), rs.getInt("AMOUNT"));
                rewards.add(reward);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive all the rewards of this brand !");
            e.printStackTrace();
        }

        return rewards;
    }

    public int addReward(Reward reward)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO REWARDS VALUES(?,?,?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setString(1, reward.getBid());
            ps.setString(2, reward.getRewardID());
            ps.setInt(3, reward.getRewardTypeID());
            ps.setInt(4, reward.getQuantity());
            ps.setInt(5, reward.getAmount());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into Rewards falied !");
        }
        return status;
    }

    public int addRERule(RERule reRule)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO RERULES VALUES(?,?,?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setInt(1, reRule.getRuleCode());
            ps.setInt(2, reRule.getVersionNumber());
            ps.setString(3, reRule.getActivityID());
            ps.setString(4, reRule.getBid());
            ps.setInt(5, reRule.getPoints());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into RE Rules falied !");
        }
        return status;
    }

    public RERule getRERule(RERule reRule)
    {
        RERule newRERule = null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RERULES WHERE BRANDID = ? and ACTIVITYID = ?");
            ps.setString(1, reRule.getBid());
            ps.setString(2, reRule.getActivityID());
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                newRERule = new RERule(rs.getInt("RULE_CODE"), rs.getInt("VERSIONNO"), rs.getString("ACTIVITYID"), rs.getString("BRANDID"), rs.getInt("POINTS"));
            }
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return newRERule;
    }
    public int addRRRule(RRRule rrRule)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO RRRULES VALUES(?,?,?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setInt(1, rrRule.getRuleCode());
            ps.setInt(2, rrRule.getVersionNumber());
            ps.setString(3, rrRule.getRewardID());
            ps.setString(4, rrRule.getBid());
            ps.setInt(5, rrRule.getPoints());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into RR Rules falied !");
            e.printStackTrace();
        }
        return status;
    }

    public RRRule getRRRule(RRRule rrRule)
    {
        RRRule newRRRule = null;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RRRULES WHERE BRANDID = ? and REWARDID = ?");
            ps.setString(1, rrRule.getBid());
            ps.setString(2, rrRule.getRewardID());
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                newRRRule = new RRRule(rs.getInt("RULE_CODE"), rs.getInt("VERSIONNO"), rs.getString("REWARDID"), rs.getString("BRANDID"), rs.getInt("POINTS"));
            }
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return newRRRule;
    }
}
