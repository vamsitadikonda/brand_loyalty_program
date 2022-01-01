package Pages;

import java.util.Scanner;

public class _4B_Brand_Loyalty_Points {
    public _4B_Brand_Loyalty_Points(){
    System.out.println("1. Enter\n" +
            "2. Go Back");
}
    public void run() throws Exception {
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
        //Take user input to signify loyalty point coint
    }

    void exit() throws Exception {
        _3B_Brand_Tier log = new _3B_Brand_Tier();
        log.run();
    }
}
