package Pages;

import java.util.Scanner;

public class _1C_Customer_Landing {
    static boolean status;
    public static void run(){
        while(true){
            System.out.println("######## Customer Landing Page ##########");
            menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : enroll();
                    break;
                case 2 : reward();
                    break;
                case 3 : viewW();
                    break;
                case 4 : redeem();
                    break;
                case 5: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-5");
            }
            if(status)return;
        }
    }
    static void menu(){
        System.out.println("1. Enroll In Loyalty Program\n" +
                "2. Reward Activities\n" +
                "3. View Wallet\n" +
                "4. Redeem Points\n"+
                "5. Log Out");
    }
    static void enroll(){
        _2C_Customer_Enroll_LP log = new _2C_Customer_Enroll_LP();
        log.run();
    }
    static void reward(){
        _2C_Customer_Reward_Activities log = new _2C_Customer_Reward_Activities();
        log.run();
    }
    static void viewW(){
        _2C_Customer_View_Wallet log = new _2C_Customer_View_Wallet();
        log.run();
    }
    static void redeem(){
        _2C_Customer_Redeem_Points log = new _2C_Customer_Redeem_Points();
        log.run();
    }

    static void exit(){
        status = true;
    }
}
