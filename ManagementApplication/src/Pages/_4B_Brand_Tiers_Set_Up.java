package Pages;

import DAO_DB.BrandManagementDAO;
import DAO_DB.TierProgramDAO;
import DAO_DB.UserManagementDAO;
import Objects_Data.Brand;
import Objects_Data.TierProgram;
import Objects_Data.UserAccount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.TooManyListenersException;

public class _4B_Brand_Tiers_Set_Up {
    static Scanner sc;
    static BufferedReader br;
    static boolean status;

    public void run() throws Exception {
        _4B_Brand_Tiers_Set_Up.sc = new Scanner(System.in);
        _4B_Brand_Tiers_Set_Up.br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("###### Brand Tier Setup Page ######");
            System.out.print("Number of tiers: ");
            int numberOfTiers = sc.nextInt();
            System.out.print("Names of tiers separated by spaces in increasing order: ");
            String tiersString = br.readLine();
            String[] tiers = tiersString.split(" ");
            System.out.print("Points Required for each tier separated by spaces in increasing order: ");
            String pointsString = br.readLine();
            String[] numOfPoints= pointsString.split(" ");
            System.out.print("Multipliers for each tier separated by spaces in increasing order: ");
            String multipliersString = br.readLine();
            String[] multipliers= pointsString.split(" ");
            menu();
            System.out.print("please select an option: ");
            int a = sc.nextInt();
            switch (a){
                case 1 : setup(numberOfTiers,tiers,numOfPoints,multipliers);
                    break;
                case 2: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }

    void menu(){
        System.out.println("1. Set Up\n" +
                "2. Go Back");
    }

    void setup(int numberOfTiers, String[] tiers, String[] numOfPoints, String[] multipliers){
        if(Integer.parseInt(numOfPoints[0])!=0){
            System.out.println("tier1 should have to start with 0 points but recieved: "+numOfPoints[0]);
            return;
        }
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        for(int i=1;i<numberOfTiers+1;i++){
            TierProgram tierProgram = new TierProgram(brand.getbid(), i, Integer.parseInt(multipliers[i-1])
                                                        ,Integer.parseInt(numOfPoints[i-1]),tiers[i-1]);
            TierProgramDAO tierProgramDAO = new TierProgramDAO();
            int status = tierProgramDAO.addTierProgram(tierProgram);
            if(status==1){
                System.out.println("Tier Program: "+tierProgram.getlName()+" Successfully added!" );
            }
            else{
                System.out.println(" Failed to add "+"Tier Program: "+tierProgram.getlName() );
            }
        }
        status=true;
    }

    void goBack() throws Exception {
        status=true;
    }
}
