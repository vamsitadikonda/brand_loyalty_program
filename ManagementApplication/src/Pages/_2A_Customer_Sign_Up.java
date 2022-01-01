package Pages;

import DAO_DB.CustomerManagementDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Customer;
import Objects_Data.UserAccount;

import java.util.Scanner;

public class _2A_Customer_Sign_Up {
    static Scanner sc;
    static boolean status;
    public _2A_Customer_Sign_Up(){
        System.out.println("1. Customer Sign Up\n" +
                "2. GoBack");
    }
    public static void run() throws Exception {
        while(true){
            menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : customerSignUp();
                    break;
                case 2: GoBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
            if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1 && a==1)return;
        }
    }
    static void menu(){
        System.out.println("######### Customer Signup Page ############");
        System.out.println("1. Customer Sign Up\n" +
                "2. GoBack");
    }
    static void customerSignUp() throws Exception {
        //code to see if customer exists and insert into database as new customer
        //Asks the customer to input  the details in the description and save/send it to our database

        _2A_Customer_Sign_Up.sc = new Scanner(System.in);
//        System.out.print("Create Customer cid: ");
//        String cid = _2A_Customer_Sign_Up.sc.next();
        System.out.print("Create Customer Name: ");
        String customerName = _2A_Customer_Sign_Up.sc.next();
        System.out.println("");
        System.out.print("Customer Address ");
        String Address = _2A_Customer_Sign_Up.sc.next();
//        System.out.print("Customer walletID: ");
//        String walletID = _2A_Customer_Sign_Up.sc.next();
        System.out.print("Phone number:");
        String phoneNumber = _2A_Customer_Sign_Up.sc.next();
        System.out.print("username:");
        String userName = _2A_Customer_Sign_Up.sc.next();
        System.out.print("password:");
        String password = _2A_Customer_Sign_Up.sc.next();
        Customer customer = new Customer(null, customerName, Address, null, userName, phoneNumber);
        UserAccount userAccount = new UserAccount(userName, password, 3, null);
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        int status = userManagementDAO.addUserAccount(userAccount);
        if(status==1){
            userAccount = userManagementDAO.getUserAccount(userAccount.getUsername());
            System.out.println("#### Login User Account successfully created!");
            CustomerManagementDAO customerManagementDAO = new CustomerManagementDAO();
            status = customerManagementDAO.addCustomer(customer,userAccount.getUserID());
            if(status==1)System.out.println("#### Customer Account successfully created!");
        }
        else{
            System.out.println("#### Login User Account creation failed!");
        }
        if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        _0_Login.run();
    }
    static void GoBack() throws Exception {
        if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        _2A_Customer_Sign_Up.status = true;
    }

    }

