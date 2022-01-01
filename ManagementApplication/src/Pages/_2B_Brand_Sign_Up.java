package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.CustomerManagementDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.Customer;
import Objects_Data.UserAccount;

import java.sql.*;

import java.util.Scanner;

public class _2B_Brand_Sign_Up {

    static Scanner sc;
    public static void run() throws Exception {
        _2B_Brand_Sign_Up.sc = new Scanner(System.in);

        while(true){
            System.out.println("######## Brand Signup Page #########");
            System.out.print("Brand username: ");
            String brandUsername = _2B_Brand_Sign_Up.sc.next();
            System.out.println("");
            System.out.print("Brand password: ");
            String brandPassword = _2B_Brand_Sign_Up.sc.next();
            // remove bid
//        System.out.print("Brand bid: ");
//        String bid = _2B_Brand_Sign_Up.sc.next();
//        System.out.println("");

            System.out.print("Brand Name: ");
            String brandName = _2B_Brand_Sign_Up.sc.next();
            System.out.print("Brand Join Date(DD/MM/YYYY)");
            String brandDate = _2B_Brand_Sign_Up.sc.next();
            System.out.print("Brand Address ");
            String brandAddress = _2B_Brand_Sign_Up.sc.next();

            Brand newBrand = new Brand(null,brandName,brandDate,brandAddress,brandUsername,brandPassword);
            menu();
            System.out.print("please select an option: ");
            _2B_Brand_Sign_Up.sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : brandSignUp(newBrand);
                    break;
                case 2 : goBack();
                    break;

                default : System.out.println("option not avaliable, select options from 1-2");

            }
            if(_0_Login.userAccount.getUserType()==1)return;
        }
    }
    static void menu(){
        System.out.println("1. Brand Sign Up\n" +
                "2. GoBack");
    }
    static void brandSignUp(Brand newBrand) throws Exception {
        //Replace with code to take the user input and search for any existing brand and insert the new brand into our database
        //Asks the Brand to input  the details in the description and save/send it to our database

        UserAccount userAccount = new UserAccount(newBrand.getBrandUserName(), newBrand.getBrandPassword(), 2, null);
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        int status = userManagementDAO.addUserAccount(userAccount);
        if(status==1){
            userAccount = userManagementDAO.getUserAccount(userAccount.getUsername());
            System.out.println("#### Login User Account successfully created!");
            BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
            brandManagementDAO.addBrand(newBrand,userAccount.getUserID());
            if(status==1)System.out.println("#### Brand Account successfully created!");
        }
        else{
            System.out.println("#### Login User Account creation failed!");
        }

        // going to login page after successful signup
        if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        _0_Login.run();
    }
    static void goBack() throws Exception {
        if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        _1B_Brand_Landing.run();
    }

}
