package Pages;

import DAO_DB.LoyaltyProgramDAO;
import DAO_DB.RewardsDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.*;

import java.util.List;
import java.util.Scanner;

public class _2C_Customer_Redeem_Points {
    static boolean status;
    static Scanner sc;
    static String bid;
    static int rTypeID;
    static String rewardID;
    static UserAccount userAccount;
    public void run(){
        while(true){
            List<RewardType> rewardTypes = menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();

            if(a>rewardTypes.size()+1 || a<1){
                System.out.println("Please select options from avaliable list(1-"+rewardTypes.size()+1+")");
                continue;
            }
            if(a==rewardTypes.size()+1)return;
            rTypeID = rewardTypes.get(a-1).getRewardCode();
            rewardID = rewardTypes.get(a-1).getRewardID();

            switch (a){
                case 1 : rewardSelection();
                    break;
                case 2: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    List<RewardType> menu(){
        System.out.println("####### Customer Reward Activities Page ########");
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        LoyaltyProgramDAO loyaltyProgramDAO = new LoyaltyProgramDAO();
        List<LoyaltyProgram> loyaltyPrograms = loyaltyProgramDAO.getAllLoyaltyProgramsFromCID(userAccount.getUserID());
        System.out.println("Available loyalty programs:");
        for(int i=1;i<loyaltyPrograms.size()+1;i++){
            System.out.println(i+". "+loyaltyPrograms.get(i-1).getlName());
        }
        System.out.print("Please select a loyalty program:");
        int choice = sc.nextInt();
        while(choice>loyaltyPrograms.size()+1 || choice<1){
            System.out.println("Please select options from the list!");
            choice = sc.nextInt();
        }

        RewardsDAO rewardsDAO = new RewardsDAO();
        bid = loyaltyPrograms.get(choice-1).getBid();
        List<RewardType> rewardTypes = rewardsDAO.getAllRewardTypes(bid);
        System.out.println("List of reward types avaliable:");
        for(int i=1;i<rewardTypes.size()+1;i++){
            System.out.println(i+". "+rewardTypes.get(i-1).getRewardName());
        }
        System.out.println((rewardTypes.size()+1)+". go back");
        return rewardTypes;
    }
    void rewardSelection(){

    }

    void goBack(){
        status = true;
    }
}
