package Pages;

import DAO_DB.BrandManagementDAO;
import Objects_Data.Brand;

import java.util.Scanner;

public class _2A_Admin_Show_Brands_Info {
    static Scanner sc;
    static boolean status;
    public static void run() throws Exception {
        while(true){
            _2A_Admin_Show_Brands_Info.sc = new Scanner(System.in);
            _2A_Admin_Show_Brands_Info.status = false;
            System.out.println("Enter Brand User ID:");
            System.out.println("------------------------------------------------");
            String bid = _2A_Admin_Show_Brands_Info.sc.next();
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : showBrandInfo(bid);
                    break;
                case 2 : goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
            if(status && _0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1)return;
        }
    }
    static void menu(){
        System.out.println("1. Look Up Brand Info\n" +
                "2. Go Back");
    }
    static void showBrandInfo(String bid) {
        //Asks admin to type a Brand_User_ID and then search our database for it

        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        Brand brand = brandManagementDAO.getBrandInfo(bid);
        if(brand!=null){
            System.out.println(brand.toString());
            status=true;
        }
        else{
            System.out.println("Please enter a valid brand user id !");
        }
    }
    static void goBack() throws Exception {
        if(_0_Login.userAccount!=null && _0_Login.userAccount.getUserType()==1){
            status=true;
            return;
        }
        _1A_Admin_Landing.run();
    }
}
