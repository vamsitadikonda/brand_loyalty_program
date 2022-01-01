package Pages;

import DAO_DB.ActivitiesDAO;
import DAO_DB.ActivityTypeDAO;
import DAO_DB.BrandManagementDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Activity;
import Objects_Data.ActivityType;
import Objects_Data.Brand;
import Objects_Data.UserAccount;

import java.util.List;
import java.util.Scanner;

public class _4B_Brand_Activity_Types {
    static Scanner sc;
    static boolean status;
    static ActivityTypeDAO activityTypeDAO;
    static List<ActivityType> activityTypes;
    public static void run() throws Exception {
        _4B_Brand_Activity_Types.sc = new Scanner(System.in);
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        while(true){
            System.out.println("###### Brand Activity Types Page ######");
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            if(a==activityTypes.size()+1)return;
            if(a>activityTypes.size()+1){
                System.out.print("options range is from 1 to "+(activityTypes.size()+1));
                continue;
            }
            System.out.print("Enter activity id: ");
            String activityID = sc.next();
            addActivity(a, activityID, brand.getbid());
        }
    }
    static void menu(){
        activityTypeDAO = new ActivityTypeDAO();
        if(activityTypes==null)activityTypes = activityTypeDAO.getAllActivityType();
        for(int i=0;i<activityTypes.size();i++){
            System.out.println((i+1)+". "+activityTypes.get(i).getActivityType());
        }
        System.out.println((activityTypes.size()+1)+". Go Back");
    }
    static void addActivity(int choice, String activityID, String bid){
        Activity activity = new Activity(bid,activityID,activityTypes.get(choice-1).getActivityCode());
        ActivitiesDAO activitiesDAO = new ActivitiesDAO();
        int status  = activitiesDAO.addActivity(activity);
        if(status==1){
            System.out.println("Activity successfully added!");
        }
        else{
            System.out.println("Failed to add Activity!");
        }
    }
    void exit() throws Exception {
        status=true;
    }
}
