package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.CustomerManagementDAO;
import DAO_DB.LoyaltyProgramDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.CustomerTierStatus;
import Objects_Data.LoyaltyProgram;
import Objects_Data.UserAccount;

import java.util.List;
import java.util.Scanner;

public class _2C_Customer_Enroll_LP {
    static Scanner sc;
    static boolean status;
    static List<LoyaltyProgram> loyaltyPrograms;
    public void run(){
        _2C_Customer_Enroll_LP.sc = new Scanner(System.in);
        while(true){
            System.out.println("######## Customer Landing Page ##########");
            LoyaltyProgramDAO loyaltyProgramDAO = new LoyaltyProgramDAO();
            loyaltyPrograms = loyaltyProgramDAO.getAllLoyaltyProgram(1);
            int choice = -1;
            if(loyaltyPrograms!=null){
                System.out.println("Available loyalty programs: ");
                for(int i=1;i<loyaltyPrograms.size()+1;i++){
                    System.out.println(i+". "+loyaltyPrograms.get(i-1).getlName());
                }
                System.out.print("please select a loyalty program: ");
                choice = sc.nextInt();
            }
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : enroll(choice);
                    break;
                case 2: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-2");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("1. Enroll In Loyalty Program\n" +
                "2. Go Back");
    }
    void enroll(int choice){
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());

        CustomerTierStatus customerTierStatus = new CustomerTierStatus(loyaltyPrograms.get(choice-1).getBid(),userAccount.getUserID());
        CustomerManagementDAO customerManagementDAO = new CustomerManagementDAO();
        int statusUpdate = customerManagementDAO.addCustomerTierStatus(customerTierStatus);
        if(statusUpdate==1){
            System.out.println("Customer added to loyalty program!");
        }else{
            System.out.println("Failed to added Customer to loyalty program!");
            return;
        }
        status=true;
    }

    void goBack(){
        status=true;
    }
}
