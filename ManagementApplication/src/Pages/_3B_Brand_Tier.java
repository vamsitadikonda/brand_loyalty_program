package Pages;

import java.util.Scanner;

public class _3B_Brand_Tier {
    static Scanner sc;
    static boolean status;

    public void run() throws Exception {
        _3B_Brand_Tier.sc = new Scanner(System.in);
        while(true){
            System.out.println("###### Brand Tier Page ######");
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : tierSetup();
                    break;
                case 2 : activityTypes();
                    break;
                case 3 : rewardTypes();
                    break;
                case 4: goBack();
                break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("1. Tiers Setup\n" +
                "2. Activity Types\n"+
                "3. Reward Types\n" +
                "4. Go Back");
    }
    void tierSetup() throws Exception {
        _4B_Brand_Tiers_Set_Up log = new _4B_Brand_Tiers_Set_Up();
        log.run();
    }

    static void activityTypes() throws Exception {
        _4B_Brand_Activity_Types.run();
    }
    static void rewardTypes() throws Exception {
        _4B_Brand_Reward_Types log = new _4B_Brand_Reward_Types();
        log.run();
    }

    void goBack() throws Exception {
        status=true;
    }
}
