package Pages;

import java.util.Scanner;

public class _3C_Customer_Purchase {
    public _3C_Customer_Purchase(){
    System.out.println("1. Purchase\n" +
            "2. Go Back");
}
    public void run(){
        while(true){
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : login();
                    break;
                case 2: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
        }
    }
    void login(){
       //if the user picks1 then record all purchase info

        //search customer account to see if they have gift card available and if so give user option to use it
    }

    void exit(){
        _2C_Customer_Reward_Activities log = new _2C_Customer_Reward_Activities();
        log.run();
    }
}
