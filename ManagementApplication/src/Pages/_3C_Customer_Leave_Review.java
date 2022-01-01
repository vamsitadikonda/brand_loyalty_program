package Pages;

import DAO_DB.WalletDAO;
import Objects_Data.Wallet;

import java.util.Scanner;

public class _3C_Customer_Leave_Review {
    static boolean status;
    static Scanner sc;
    public void run(String bid, int aTypeID, String activityID, String cid){
        sc = new Scanner(System.in);
        while(true){
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : leaveAReview(bid, aTypeID, activityID, cid);
                    break;
                case 2: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("###### Customer Leave review Page #######");
        System.out.println("1. Leave A Review\n" +
                "2. Go Back");
    }
    void leaveAReview(String bid, int aTypeID, String activityID, String cid){
        //if 1 is selected than allow user to type a review message and then once completed submit review to database
        System.out.println("please enter a review: ");
        String review = sc.next();
        Wallet wallet = new Wallet(bid, cid, activityID, null, "RE");
        WalletDAO walletDAO = new WalletDAO();
        int updateStatus = walletDAO.addWalletEntry(wallet);
        if(updateStatus==1){
            System.out.println("Review successfully updated!");
        }else{
            System.out.println("review update failed!");
        }
        status=true;
    }

    void goBack(){
        status=true;
    }
}
