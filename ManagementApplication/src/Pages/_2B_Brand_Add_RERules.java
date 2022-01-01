package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.RewardsDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.RERule;
import Objects_Data.UserAccount;

import java.util.Scanner;

public class _2B_Brand_Add_RERules {
    static Scanner sc;
    static boolean status;
    public void run() throws Exception {
        _2B_Brand_Add_RERules.sc = new Scanner(System.in);
        while(true){
            System.out.println("######## Brand RE rules page ##########");
            menu();
            System.out.print("Enter the Reward Rule Code: ");
            int REcode = sc.nextInt();
            System.out.print("Enter the Activity Category ID: ");
            String activityID = sc.next();
            System.out.print("Enter the number of points: ");
            int numberOfPoints = sc.nextInt();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : rer(REcode,activityID,numberOfPoints);
                    break;
                case 2: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("1. Add RERule\n" +
                "2. Go Back");
    }
    void rer(int REcode, String activityID, int numberOfPoints){
        //Ask the brand to input the details of a new RE rule
        // A. Brand_Reward_Rule_Code    B. Activity_Category    C. Number_Of_Points
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        RERule reRule = new RERule(REcode,1, activityID, brand.getbid(), numberOfPoints);
        RewardsDAO rewardsDAO = new RewardsDAO();
        int status = rewardsDAO.addRERule(reRule);
        if(status==1){
            System.out.println("RE Rule successfully added!");
        }
        else {
            System.out.println("Failed to add RE Rule!");
        }
    }

    void exit() throws Exception {
        status=true;
    }
}
