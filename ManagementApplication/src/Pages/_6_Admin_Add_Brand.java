package Pages;

import Objects_Data.Brand;

import java.util.Scanner;

public class _6_Admin_Add_Brand {
    Scanner sc;
    public _6_Admin_Add_Brand(){
    System.out.println("1. addBrand\n" +
           "2. GoBack");
}
    public void run() throws Exception {
        while(true){
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : login();
                    break;
                case 2 : goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");

            }
        }
    }
    void login(){
        this.sc = new Scanner(System.in);
        System.out.print("Create Brand bid: ");
        String bid = this.sc.next();
        System.out.println("");
        System.out.print("Create Brand Name: ");
        String brandName = this.sc.next();
        System.out.println("");
        System.out.print("Brand Date ");
        String brandDate = this.sc.next();
        System.out.print("Brand Address ");
        String brandAddress = this.sc.next();
        System.out.print("Create Brand LP_Code: ");
        String brandLP_Code = this.sc.next();
        System.out.println("");
        System.out.print("Create Brand LP_Name: ");
        String brandLP_Name = this.sc.next();
        System.out.println("");
        System.out.print("Brand Tier ");
        String brandTiers = this.sc.next();
        System.out.print("Points Required ");
        String brandPointsRequired = this.sc.next();
        System.out.print("multiplier ");
        String brandmultiplier = this.sc.next();
        //Brand brand = new Brand(bid, brandName, brandDate, brandAddress, brandLP_Code, brandLP_Name, brandTiers, brandPointsRequired, brandmultiplier);
    }
    void goBack() throws Exception {
        _1A_Admin_Landing log = new _1A_Admin_Landing();
        log.run();
    }
    }

