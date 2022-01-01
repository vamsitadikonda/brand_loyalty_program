package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.LoyaltyProgramDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.LoyaltyProgram;
import Objects_Data.UserAccount;

import java.util.Scanner;

public class _2B_Brand_Add_Loyalty_Program {
    static Scanner sc;
    static boolean status;
    public static void run() throws Exception {
        _2B_Brand_Add_Loyalty_Program.sc = new Scanner(System.in);
        while(true){
            System.out.println("######## Brand Loyalty program page ##########");
            menu();
            System.out.print("Enter the name of Loyalty Program: ");
            String lName = sc.next();
            System.out.print("Enter the name of Loyalty Program Code: ");
            String lCode = sc.next();
            BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
            UserManagementDAO userManagementDAO = new UserManagementDAO();
            UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
            Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
            if(brand==null){
                System.out.println("brand not found!");
                return;
            }
            LoyaltyProgram loyaltyProgram = new LoyaltyProgram(0,lCode, brand.getbid(), lName, 0);
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : reg(loyaltyProgram);
                    break;
                case 2 : tier(loyaltyProgram);
                    break;
                case 3: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    static void menu(){
        System.out.println("1. Create Regular Program\n" +
                "2. Create Tiered Program\n"+
                "3. Go Back");
    }
    static void reg(LoyaltyProgram loyaltyProgram) throws Exception {
        loyaltyProgram.setIsTier(0);
        LoyaltyProgramDAO loyaltyProgramDAO = new LoyaltyProgramDAO();
        int status = loyaltyProgramDAO.addLoyaltyProgram(loyaltyProgram);
        if(status==1) {
            System.out.println("Regular Loyalty Program created !");
            _3B_Brand_Regular.run();
        }
        else{
            System.out.println("Regular Loyalty Program creation failed !");
        }
    }
    static void tier(LoyaltyProgram loyaltyProgram) throws Exception {
        loyaltyProgram.setIsTier(1);
        LoyaltyProgramDAO loyaltyProgramDAO = new LoyaltyProgramDAO();
        int status = loyaltyProgramDAO.addLoyaltyProgram(loyaltyProgram);
        if(status==1) {
            System.out.println("Tier Loyalty Program created !");
            _3B_Brand_Tier log = new _3B_Brand_Tier();
            log.run();
        }
        else{
            System.out.println("Tier Loyalty Program creation failed !");
        }
    }
    static void exit() throws Exception {
        _2B_Brand_Add_Loyalty_Program.status = true;
    }
}
