package Pages;

import java.util.Scanner;

public class _1A_Admin_Landing {
    static boolean status;
    public static void run() throws Exception {
        while(true){
            menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : addBrand();
                    break;
                case 2 : addCustomer();
                    break;
                case 3 : showBrandInfo();
                    break;
                case 4 : showCustomerInfo();
                    break;
                case 5 : AddActivityType();
                    break;
                case 6 : AddRewardType();
                    break;
                case 7: logout();
                    break;
                default : System.out.println("option not avaliable, select options from 1-7");
            }
            if(status)return;
        }
    }

    static void menu(){
        System.out.println("######## ADMIN LANDING ##########");
        System.out.println("1. Add Brand\n" +
                "2. Add Customer\n" +
                "3. Show Brand Info\n" +
                "4. Show Customer Info\n" +
                "5. Add Activity Type\n" +
                "6. Add Reward Type\n" +
                "7. Log Out");
    }
    static void addBrand() throws Exception {
        _2B_Brand_Sign_Up.run();
    }

    static void addCustomer() throws Exception {
        _2A_Customer_Sign_Up.run();
    }
    static void showBrandInfo() throws Exception {
        _2A_Admin_Show_Brands_Info.run();
        }
    static void showCustomerInfo() throws Exception {
        _2A_Admin_Show_Customer_Info.run();

    }
    static void AddActivityType() throws Exception {
        _2A_Admin_Add_Activity_Type.run();

    }
    static void AddRewardType() throws Exception {
        _2A_Admin_Add_Reward_Type.run();

    }

    static void logout(){
    status = true;
    }
}
