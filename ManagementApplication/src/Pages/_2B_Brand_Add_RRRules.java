package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.RewardsDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.RRRule;
import Objects_Data.UserAccount;

import java.util.Scanner;

public class _2B_Brand_Add_RRRules {
    static Scanner sc;
    static boolean status;
    public void run() throws Exception {
        _2B_Brand_Add_RRRules.sc = new Scanner(System.in);
        while(true){
            System.out.println("######## Brand RR rules page ##########");
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
                case 1 : rrr(REcode,rewardID,numberOfPoints);
                    break;
                case 2: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("1. Add RRRule\n" +
                "2. Go Back");
    }
    void rrr(int REcode, String rewardID, int numberOfPoints){
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        RRRule rrRule = new RRRule(REcode,1, rewardID, brand.getbid(), numberOfPoints);
        RewardsDAO rewardsDAO = new RewardsDAO();
        int status = rewardsDAO.addRRRule(rrRule);
        if(status==1){
            System.out.println("RR Rule successfully added!");
        }
        else {
            System.out.println("Failed to add RR Rule!");
        }
    }

    void exit() throws Exception {
        status=true;
    }
}
