package Pages;

import java.util.Scanner;

public class _1B_Brand_Landing {
    static boolean status;
    static public void run() throws Exception {
        while(true){
            System.out.println("######## Brand Landing Page ##########");
            menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : addLP();
                    break;
                case 2 : addRER();
                    break;
                case 3 : updateRER();
                    break;
                case 4 : addRRR();
                    break;
                case 5 : updateRRR();
                    break;
                case 6 : validLP();
                    break;
                case 7: logout();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
            if(status)return;
        }
    }
    static void menu(){

        System.out.println("1. Add Loyalty Program\n" +
                "2. Add RERules\n" +
                "3. Update RERules\n" +
                "4. Add RRRules\n" +
                "5. Update RRRules\n" +
                "6. Validate Loyalty Program\n" +
                "7. Log Out");
    }

    static void addLP() throws Exception {
        _2B_Brand_Add_Loyalty_Program.run();
    }

    static void addRER() throws Exception {
        _2B_Brand_Add_RERules obj = new _2B_Brand_Add_RERules();
        obj.run();
    }
    static void updateRER() throws Exception {
        _2B_Brand_Update_RERules obj = new _2B_Brand_Update_RERules();
        obj.run();
    }
    static  void addRRR() throws Exception {
        _2B_Brand_Add_RRRules obj = new _2B_Brand_Add_RRRules();
        obj.run();
    }
    static void updateRRR() throws Exception {
        _2B_Brand_Update_RRRules obj = new _2B_Brand_Update_RRRules();
        obj.run();
    }
    static void validLP() throws Exception {
        _2B_Brand_Validate_LP obj = new _2B_Brand_Validate_LP();
        obj.run();
    }
    static void logout(){
        status=true;
    }
}
