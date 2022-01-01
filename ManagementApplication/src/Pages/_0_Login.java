package Pages;

import DAO_DB.UserManagementDAO;
import Objects_Data.UserAccount;

import java.util.Scanner;

public class _0_Login {
    static UserAccount userAccount;
    static Scanner sc;
    static boolean status;
    public static void run() throws Exception {
        while(true){
            System.out.println("###### Login Page #######");
            _0_Login.sc = new Scanner(System.in);
            System.out.print("username: ");
            String userName = _0_Login.sc.next();
            System.out.print("password: ");
            String password = _0_Login.sc.next();
            menu();
            System.out.print("please select an option: ");

            int a = _0_Login.sc.nextInt();
            switch (a){
                case 1 : signin(userName,password);
                    break;
                case 2 : goback();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    static void menu(){
        System.out.println("1. Sign_In\n" +
                "2. Go Back");
    }
    static void signin(String userName, String password) throws Exception {
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        _0_Login.userAccount = userManagementDAO.getUserAccount(userName);
        if(_0_Login.userAccount==null){
            System.out.println("Please enter valid username");
            return;
        }
        else if(!_0_Login.userAccount.getPassword().equals(password)){
            System.out.println("Please enter valid credentials !");
            return;
        }
        int userType = _0_Login.userAccount.getUserType();
        if(userType==1)_1A_Admin_Landing.run();
        else if(userType==2)_1B_Brand_Landing.run();
        else if(userType==3)_1C_Customer_Landing.run();
    }
    static void goback() throws Exception {
        status=true;
    }
}

