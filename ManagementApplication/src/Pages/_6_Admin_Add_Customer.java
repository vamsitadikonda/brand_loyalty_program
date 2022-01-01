package Pages;

import DAO_DB.CustomerManagementDAO;
import Objects_Data.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _6_Admin_Add_Customer {public _6_Admin_Add_Customer(){
    System.out.println("1. addCustomer\n" +
          "4. Go Back");
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
    void login() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CustomerManagementDAO dao = new CustomerManagementDAO();

        System.out.println("------------------------------------------------");
        System.out.println("Enter Customer ID:");
        System.out.println("------------------------------------------------");
        String cid = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Enter Customer Name:");
        System.out.println("------------------------------------------------");
        String customerName = br.readLine();
        System.out.println("Enter Customer Address:");
        System.out.println("------------------------------------------------");
        String Address = br.readLine();
        System.out.println("------------------------------------------------");
        System.out.println("Wallet_ID");
        System.out.println("------------------------------------------------");
        String Wallet_ID = br.readLine();
        //after user enters values, store them in a Product variable
        Customer customer = new Customer(cid, customerName, Address, Wallet_ID,null);
        int status = dao.addCustomer(customer, null);
        if(status ==1 )
        {
            System.out.println("Customer added successfully");
        }
        else
        {
            System.out.println("ERROR while adding customer");
        }
        System.out.println("\n");

    }
    void goBack() throws Exception {
        _1A_Admin_Landing log = new _1A_Admin_Landing();
        log.run();
    }

}
