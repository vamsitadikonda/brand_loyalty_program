package Pages;

import java.util.Scanner;

public class _3_User_Type {

    public static void run() throws Exception {
        menu();
        while(true){
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : brandSignup();
                    break;
                case 2 : customerSignup();
                    break;
                case 3 : goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
        }
    }
    static void menu(){
        System.out.println("1. Brand Sign Up\n" +
                "2. Customer Sign Up\n" +
                "3. Go Back\n");
    }
    static void brandSignup() throws Exception {
        _2B_Brand_Sign_Up.run();
    }
    static void customerSignup() throws Exception {
        _2A_Customer_Sign_Up.run();
    }
    static void goBack(){
        return;
    }


}
