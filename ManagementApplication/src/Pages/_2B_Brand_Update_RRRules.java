package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.RewardsDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.RERule;
import Objects_Data.RRRule;
import Objects_Data.UserAccount;

import java.util.Scanner;

public class _2B_Brand_Update_RRRules {
    static Scanner sc;
    static boolean status;
    public void run() throws Exception {
        _2B_Brand_Update_RRRules.sc = new Scanner(System.in);
        while(true){
            System.out.println("######## Brand RR rules Update page ##########");
            menu();
            System.out.print("Enter the Reward Rule Code: ");
            int REcode = sc.nextInt();
            System.out.print("Enter the Reward ID: ");
            String rewardID = sc.next();
            System.out.print("Enter the number of points: ");
            int numberOfPoints = sc.nextInt();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : rrrUpdate(REcode,rewardID,numberOfPoints);
                    break;
                case 2: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-2");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("1. Update RERule\n" +
                "2. Go Back");
    }
    void rrrUpdate(int REcode, String rewardID, int numberOfPoints){
        //Ask the brand to input the details of a new RE rule
        // A. Brand_Reward_Rule_Code    B. Activity_Category    C. Number_Of_Points
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        RRRule rrRule = new RRRule(REcode,1, rewardID, brand.getbid(), numberOfPoints);
        RewardsDAO rewardsDAO = new RewardsDAO();
        RRRule oldRRRule = rewardsDAO.getRRRule(rrRule);
        if(oldRRRule!=null){
            rrRule.setVersionNumber(oldRRRule.getVersionNumber()+1);
        }
        else{
            System.out.println("RE Rule not present!");
            return;
        }
        int status = rewardsDAO.addRRRule(rrRule);
        if(status==1){
            System.out.println("RR Rule successfully Updated!");
        }
        else {
            System.out.println("Failed to update RR Rule!");
        }
    }

    void exit() throws Exception {
        status=true;
    }
}
