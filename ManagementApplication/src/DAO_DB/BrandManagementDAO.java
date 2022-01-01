package DAO_DB;



import java.sql.*;
import java.util.*;
import DB_Init.DBUtil;
import Objects_Data.Brand;
import Objects_Data.UserAccount;

public class BrandManagementDAO {


    //get all Brands method.  used List instead of ArrayList so it's better code management
    //incase we want to change BrandList ArrayList to a LinkedList, we don't have to change the jdbc code that much
    public List<Brand> getAllBrand()
    {
        List<Brand> brandList = new ArrayList<Brand>();
        try
        {
            //typical jdbc coding
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM brand");
            while(rs.next())
            {
                Brand brand = new Brand(rs.getString("bid"), rs.getString("brandName"), rs.getString("brandDate"), rs.getString("brandAddress"), null, null);
                brandList.add(brand);
            }
            DBUtil.closeConnection();  //close connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return brandList;
    }

    //different query
    public Brand getBrandInfo(String bid)
    {
        Brand brand = null;
        try
        {
//            UserManagementDAO userManagementDAO = new UserManagementDAO();
//            UserAccount userAccount = userManagementDAO.getUserAccount(userName);
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM BRANDS WHERE BRANDID = ?");
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                brand = new Brand(rs.getString("BRANDID"), rs.getString("BNAME"), rs.getString("JOINDATE"), rs.getString("ADDRESS"));
            }
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return brand;
    }

    public int addBrand(Brand brand, String bid)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try
        {
            //set parameters of query here but using the values for the product object
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO brands VALUES(?,?,?,?)");

            ps1.setString(1, brand.getbrandName());
            ps1.setString(2, brand.getbrandAddress());
            ps1.setString(3,brand.getbrandDate());
            ps1.setString(4, bid);
            status = ps1.executeUpdate();  //if successful status should return 1
            DBUtil.closeConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }

    //updates a product already in the table
    public int updateBrand(Brand brand)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE brand SET brand_name=?, bid=? WHERE bid=?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, brand.getbid());
            ps.setString(2, brand.getbrandName());
            ps.setString(3,brand.getbrandDate());
//            ps.setString(4, brand.getbrandAddress());
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
    public int deleteBrand(String bid)
    {
        int status = 0;
        try
        {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM brand where bid = ?");
            //set parameters of query here but using the values for the product object
            ps.setString(1, bid);
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