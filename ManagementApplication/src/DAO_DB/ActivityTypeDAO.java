package DAO_DB;

import DB_Init.DBUtil;
import Objects_Data.ActivityType;
import Objects_Data.Customer;
import java.sql.*;
import java.util.*;
import DB_Init.DBUtil;
import Objects_Data.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ActivityTypeDAO {
    public List<ActivityType> getAllActivityType()
    {
        List<ActivityType> ActivityList = new ArrayList<ActivityType>();
        try
        {
            //typical jdbc coding
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ACTIVITYTYPES");
            while(rs.next())
            {
                ActivityType activityType = new ActivityType( rs.getString("ATYPENAME"),rs.getInt("ATYPEID"));
                ActivityList.add(activityType);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return ActivityList;
    }

    public int addActivityType(ActivityType activityType)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO ACTIVITYTYPES VALUES(?,?)");
            //set parameters of query here but using the values for the product object
            ps.setInt(1, activityType.getActivityCode());
            ps.setString(2, activityType.getActivityType());
            status = ps.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
//            e.printStackTrace();
            System.out.println("Activity Type creation failed ! Please try again! ");
        }
        return status;
    }
}
