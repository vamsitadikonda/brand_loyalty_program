package DAO_DB;
import DB_Init.DBUtil;
import Objects_Data.Activity;
import Objects_Data.ActivityType;
import Objects_Data.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivitiesDAO {
    public List<Activity> getAllActivities(String bid)
    {
        List<Activity> activities = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACTIVITIES WHERE BRANDID = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Activity activity = new Activity(rs.getString("BRANDID"), rs.getString("ACTIVITYID"), rs.getInt("ATYPEID"));
                activities.add(activity);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive all the activities of this brand !");
            e.printStackTrace();
        }

        return activities;
    }

    public List<ActivityType> getAllActivityTypes(String bid)
    {

        List<ActivityType> activityTypes = new ArrayList<>();
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("select p.atypename, a.activityID, a.AtypeID from activities a, activityTypes p where p.atypeID = a.atypeID and brandId = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                ActivityType activityType = new ActivityType(rs.getString("ATYPENAME"), rs.getInt("ATYPEID"));
                activityType.setActivityID(rs.getString("ACTIVITYID"));
                activityTypes.add(activityType);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            System.out.println("Unable to retrive all the activities of this brand !");
            e.printStackTrace();
        }

        return activityTypes;
    }

    public int addActivity(Activity activity)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ACTIVITIES VALUES(?,?,?)");
            //set parameters of query here but using the values for the product object
            ps.setString(1, activity.getBid());
            ps.setString(2, activity.getActivityID());
            ps.setInt(3, activity.getActivityTypeID());
            status = ps.executeUpdate();  //if successful status should return 1

            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            System.out.println("#### database insertion into Activities falied !");
        }
        return status;
    }
}
