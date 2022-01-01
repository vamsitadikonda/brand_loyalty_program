package Pages;

import java.util.Scanner;

public class _3B_Brand_Regular {
    static Scanner sc;
    static boolean status;

    public static void run() throws Exception {
        _3B_Brand_Regular.sc = new Scanner(System.in);
        while(true){
            System.out.println("###### Brand Regular Page ######");
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : activityTypes();
                    break;
                case 2 : rewardTypes();
                    break;
                case 3: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    static void menu(){
        System.out.println("1. Activity Types\n" +
                "2. Reward Types\n" +
                "3. Go back");
    }
    static void activityTypes() throws Exception {
        _4B_Brand_Activity_Types.run();
    }
    static void rewardTypes() throws Exception {
        _4B_Brand_Reward_Types log = new _4B_Brand_Reward_Types();
        log.run();
    }

    static void exit() throws Exception {
        status=true;
    }
}
