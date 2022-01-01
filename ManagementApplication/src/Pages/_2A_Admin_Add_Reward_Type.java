package Pages;

import DAO_DB.ActivityTypeDAO;
import DAO_DB.RewardTypeDAO;
import Objects_Data.ActivityType;
import Objects_Data.RewardType;

import java.util.Scanner;

public class _2A_Admin_Add_Reward_Type {
    static Scanner sc;
    static boolean status;
    public static void run() throws Exception {
        _2A_Admin_Add_Reward_Type.sc = new Scanner(System.in);
        _2A_Admin_Add_Reward_Type.status = false;
        while(true){
            System.out.println("##### Reward Types Page #####");
            System.out.print("Enter Reward name:");
            String rewardName = sc.next();
            System.out.print("Enter Reward code:");
            int rewardCode = sc.nextInt();

            menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : addRType(rewardName, rewardCode);
                    break;
                case 2 : goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status && _0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        }
    }
    static void menu(){
        System.out.println("1. Add Reward Type\n" +
                "2. Go Back");
    }
    static void addRType(String rewardName, int rewardCode){
        //Asks the admin to type the details of a reward with A.Reward_Name or B.Reward_Code
        RewardType rewardType = new RewardType(rewardName,rewardCode);
        RewardTypeDAO rewardTypeDAO = new RewardTypeDAO();
        int status = rewardTypeDAO.addRewardType(rewardType);
        if(status==1){
            System.out.println("#### Reward Type successfully created!");
        }
        else{
            System.out.println("#### Reward Type creation failed!");
        }
    }
    static void goBack() throws Exception {
        if(_0_Login.userAccount.getUserType()==1){
            _2A_Admin_Add_Reward_Type.status = true;
            return;
        }
        _1A_Admin_Landing.run();
    }

}
