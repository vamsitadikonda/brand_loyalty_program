package Pages;

import DAO_DB.ActivityTypeDAO;
import DAO_DB.CustomerManagementDAO;
import Objects_Data.ActivityType;

import java.util.Scanner;

public class _2A_Admin_Add_Activity_Type {
    static Scanner sc;
    static boolean status;
    public static void run() throws Exception {
        _2A_Admin_Add_Activity_Type.sc = new Scanner(System.in);
        _2A_Admin_Add_Activity_Type.status = false;
        while(true){
            System.out.println("##### Activity Types Page #####");
            System.out.print("Enter Activity name:");
            String activityName = sc.next();
            System.out.print("Enter Activity code:");
            int activityCode = sc.nextInt();
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : addAType(activityName, activityCode);
                    break;
                case 2 : goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status && _0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        }
    }
    static void menu(){
        System.out.println("1. Add Activity Type\n" +
                "2. Go Back");
    }
    static void addAType(String activityName, int activityCode){
        //Asks the admin to type the details of an activity with A.Activity_Name or B.Activity_Code
        ActivityType activityType = new ActivityType(activityName,activityCode);
        ActivityTypeDAO activityTypeDAO = new ActivityTypeDAO();
        int status = activityTypeDAO.addActivityType(activityType);
        if(status==1){
            System.out.println("#### Activity Type successfully created!");
        }
        else{
            System.out.println("#### Activity Type creation failed!");
        }
    }
    static void goBack() throws Exception {
        if(_0_Login.userAccount.getUserType()==1){
            _2A_Admin_Add_Activity_Type.status = true;
            return;
        }
        _1A_Admin_Landing.run();

}}
