package Pages;

import DAO_DB.CustomerManagementDAO;
import Objects_Data.Customer;

import java.util.Scanner;

public class _2A_Admin_Show_Customer_Info {
    static Scanner sc;
    static boolean status;
    public static void run() throws Exception {
        _2A_Admin_Show_Customer_Info.sc = new Scanner(System.in);
        _2A_Admin_Show_Customer_Info.status = false;
        while(true){
            System.out.println("Enter Customer ID:");
            System.out.println("------------------------------------------------");
            String cid = sc.next();
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : customerInfo(cid);
                    break;
                case 2: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-2");
            }
            if(status && _0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        }
    }
    static void menu(){
        System.out.println("1. Look Up Customer Info\n" +
                "2. GoBack");
    }
    static void customerInfo(String cid){
        //Asks admin to type a Customer_User_ID and then search our database for it
        //Add code to use cid to search database and select a customer
        CustomerManagementDAO customerManagementDAO = new CustomerManagementDAO();
        Customer customer = customerManagementDAO.getCustomerDetails(cid);
        if(customer !=null){
            System.out.println(customer.toString());
            _2A_Admin_Show_Customer_Info.status=true;
        }
        else{
            System.out.println("Please enter a valid customer user id !");
        }
    }

    static void goBack() throws Exception {
        if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1){
            status=true;
            return;
        }
        _1A_Admin_Landing.run();
    }
}
