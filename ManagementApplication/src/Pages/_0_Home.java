package Pages;

import java.util.Scanner;

public class _0_Home {
    static Scanner sc;
    public static void run() throws Exception {
        while(true){
            System.out.println("###### Home Page #######");
            menu();
            System.out.print("please select an option: ");
            _0_Home.sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : login();
                    break;
                case 2 : signUp();
                    break;
                case 3 : showQueries();
                    break;
                case 4: exit();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
        }
    }
    static void menu(){
        System.out.println("1. Login\n" +
                "2. Sign Up\n" +
                "3. showQueries\n" +
                "4. Exit");
    }
    static void login() throws Exception {
        _0_Login.run();
    }
    static void signUp() throws Exception {
        _3_User_Type.run();
    }
    static void showQueries(){

        //Code to show the queries we have

        return;
    }

    static void exit(){
        System.out.println("Exiting");
        System.exit(0);
    }
}
