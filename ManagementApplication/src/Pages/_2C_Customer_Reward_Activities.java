package Pages;

import DAO_DB.ActivitiesDAO;
import DAO_DB.BrandManagementDAO;
import DAO_DB.LoyaltyProgramDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Activity;
import Objects_Data.ActivityType;
import Objects_Data.LoyaltyProgram;
import Objects_Data.UserAccount;

import java.util.List;
import java.util.Scanner;

public class _2C_Customer_Reward_Activities {
    static boolean status;
    static Scanner sc;
    static String bid;
    static int aTypeID;
    static String activityID;
    static UserAccount userAccount;
    public void run(){
        _2C_Customer_Reward_Activities.sc = new Scanner(System.in);
        while(true){
            List<ActivityType> activityTypes = menu();

            System.out.print("please select an option: ");
            int a = sc.nextInt();
            if(a>activityTypes.size()+1 || a<1){
                System.out.println("Please select options from avaliable list(1-"+activityTypes.size()+1+")");
                continue;
            }
            if(a==activityTypes.size()+1)return;
            aTypeID = activityTypes.get(a-1).getActivityCode();
            activityID = activityTypes.get(a-1).getActivityID();
            switch (aTypeID){
                case 1 : Purchase();
                    break;
                case 2 : leaveAReview();
                    break;
                case 3 : referAFriend();
                    break;
                default : System.out.println("option not implemented yet, select other option");
            }
            if(status)return;
        }
    }
    List<ActivityType> menu(){
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
        ActivitiesDAO activitiesDAO = new ActivitiesDAO();
        bid = loyaltyPrograms.get(choice-1).getBid();
        List<ActivityType> activityTypes = activitiesDAO.getAllActivityTypes(bid);
        System.out.println("List of activity types avaliable:");
        for(int i=1;i<activityTypes.size()+1;i++){
            System.out.println(i+". "+activityTypes.get(i-1).getActivityType());
        }
        System.out.println((activityTypes.size()+1)+". go back");
        return activityTypes;
    }
    void Purchase(){
        _3C_Customer_Purchase log = new _3C_Customer_Purchase();
        log.run();
        status=true;
    }
    void leaveAReview(){
        _3C_Customer_Leave_Review log = new _3C_Customer_Leave_Review();
        log.run(bid,aTypeID,activityID,userAccount.getUserID());
        status=true;
    }
    void referAFriend(){
        _3C_Customer_Refer_Friend log = new _3C_Customer_Refer_Friend();
        log.run(bid,activityID,userAccount.getUserID());
        status=true;
    }

    void goBack(){
        status=true;
    }
}
