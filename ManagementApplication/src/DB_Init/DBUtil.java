package DB_Init;

import java.sql.*;

public class DBUtil {

    static Connection conn = null;
    //static method that creates a connection to the database and return the connection object
    public static Connection getConnection()
    {
        if(conn!=null)return conn;
        try{
            final String jdbcURL  = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl01";
            conn = DriverManager.getConnection(jdbcURL, "btadiko", "abcd1234");
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "dummy", "dummy");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    //close connection
    public static void closeConnection()
    {
        try{
            DBUtil.conn.close();
            DBUtil.conn=null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}

