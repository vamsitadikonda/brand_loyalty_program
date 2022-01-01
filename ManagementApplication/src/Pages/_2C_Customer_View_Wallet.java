package Pages;

import DAO_DB.UserManagementDAO;
import DAO_DB.WalletDAO;
import Objects_Data.UserAccount;
import Objects_Data.Wallet;

import java.util.List;
import java.util.Scanner;

public class _2C_Customer_View_Wallet {

    public void run(){
        while(true){
            view();
            System.out.println("####### Customer View Wallet Page #######");
            System.out.println("1. Go Back\n");
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            if(a==1)return;
        }
    }
    void view(){
        //display the contents of a customer wallet
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        WalletDAO walletDAO = new WalletDAO();
        List<Wallet> walletEntries= walletDAO.getAllWalletEntries(userAccount.getUserID());
        for(Wallet w:walletEntries){
            System.out.println(w);
        }
    }
}
