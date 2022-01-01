package Pages;

import DAO_DB.WalletDAO;
import Objects_Data.Wallet;

import java.util.Scanner;

public class _3C_Customer_Refer_Friend {
    static boolean status;
    static Scanner sc;
    public void run(String bid, String activityID, String cid){
        sc = new Scanner(System.in);
        while(true){
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : Refer(bid, activityID, cid);
                    break;
                case 4: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
        }
    }
    void menu(){
        System.out.println("###### Customer Refer a friend Page #######");
        System.out.println("1. Refer\n" +
                "2. Go Back\n");
    }
    void Refer(String bid, String activityID, String cid){

        Wallet wallet = new Wallet(bid, cid, activityID, null, "RE");
        WalletDAO walletDAO = new WalletDAO();
        int updateStatus = walletDAO.addWalletEntry(wallet);
        if(updateStatus==1){
            System.out.println("Refer a friend successfully updated!");
        }else{
            System.out.println("refer a friend update failed!");
        }
        status=true;
    }

    void goBack(){
        status=true;
    }
}
