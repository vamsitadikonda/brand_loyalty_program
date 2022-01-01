package Pages;

import DAO_DB.*;
import Objects_Data.*;

import java.util.List;
import java.util.Scanner;

public class _4B_Brand_Reward_Types {
    static Scanner sc;
    static boolean status;
    static RewardTypeDAO rewardTypeDAO;
    static List<RewardType> rewardTypes;

    public void run(){
        _4B_Brand_Reward_Types.sc = new Scanner(System.in);
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        while(true){
            System.out.println("###### Brand Reward Types Page ######");
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            if(a==rewardTypes.size()+1)return;
            System.out.print("please enter the quantity of reward: ");
            int quantity = sc.nextInt();
            System.out.print("please enter the amount of reward(enter 0 if not applicable): ");
            int amount = sc.nextInt();
            if(a>rewardTypes.size()+1){
                System.out.print("options range is from 1 to "+(rewardTypes.size()+1));
                continue;
            }
            System.out.print("Enter Reward id: ");
            String activityID = sc.next();
            addReward(a, activityID, brand.getbid(), quantity, amount);
        }
    }

    void menu(){
        rewardTypeDAO = new RewardTypeDAO();
        rewardTypes = rewardTypeDAO.getAllRewardType();
        for(int i=0;i<rewardTypes.size();i++){
            System.out.println((i+1)+". "+rewardTypes.get(i).getRewardName());
        }
        System.out.println((rewardTypes.size()+1)+". Go Back");
    }
    void addReward(int choice, String rewardID, String bid, int quantity, int amount){
        Reward reward = new Reward(bid,rewardID,rewardTypes.get(choice-1).getRewardCode(),quantity, amount);
        RewardsDAO rewardsDAO = new RewardsDAO();
        int status  = rewardsDAO.addReward(reward);
        if(status==1){
            System.out.println("Reward successfully added!");
        }
        else{
            System.out.println("Failed to add Reward!");
        }
    }

}
