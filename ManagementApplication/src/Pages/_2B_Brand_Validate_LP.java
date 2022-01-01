package Pages;

import DAO_DB.*;
import Objects_Data.*;

import java.util.List;
import java.util.Scanner;

public class _2B_Brand_Validate_LP {
    static boolean status;
    public void run() throws Exception {
        while(true){
            System.out.println("######## Brand Validate Loyalty Program Page ##########");
            menu();
            System.out.print("please select an option: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            switch (a){
                case 1 : valid();
                    break;
                case 2: goBack();
                    break;
                default : System.out.println("option not avaliable, select options from 1-4");
            }
            if(status)return;
        }
    }
    void menu(){
        System.out.println("1. Validate Loyalty Program\n" +
                "2. Go Back");
    }
    void valid(){
        BrandManagementDAO brandManagementDAO = new BrandManagementDAO();
        UserManagementDAO userManagementDAO = new UserManagementDAO();
        UserAccount userAccount = userManagementDAO.getUserAccount(_0_Login.userAccount.getUsername());
        Brand brand = brandManagementDAO.getBrandInfo(userAccount.getUserID());
        ActivitiesDAO activitiesDAO = new ActivitiesDAO();
        List<Activity> activities = activitiesDAO.getAllActivities(brand.getbid());
        if(activities!=null && activities.size()>=1){
            System.out.println("This Brand has "+activities.size()+" activities");
        }else{
            System.out.println("This Brand failed activities check with "+activities.size()+" activities");
            return;
        }
        RewardsDAO rewardsDAO = new RewardsDAO();
        List<Reward> rewards = rewardsDAO.getAllRewards(brand.getbid());
        if(rewards!=null && rewards.size()>=1){
            System.out.println("This Brand has "+rewards.size()+" rewards");
        }else{
            System.out.println("This Brand failed rewards check with "+rewards.size()+" rewards");
            return;
        }
        for(Activity a:activities){
            RERule reRule = rewardsDAO.getRERule(new RERule(a.getActivityID(),a.getBid()));
            if(reRule==null){
                System.out.println("ActivityID: "+a.getActivityID() + " has no RE Rule");
                System.out.println("RE Rules check Failed!");
                return;
            }
        }
        System.out.println("RE Rules check Passed, ALl the activities have corresponding RE rule!");
        for(Reward r: rewards){
            RRRule rrRule = rewardsDAO.getRRRule(new RRRule(r.getRewardID(),r.getBid()));
            if(rrRule==null){
                System.out.println("RewardID: "+r.getRewardID() + " has no RR Rule");
                System.out.println("RR Rules check Failed!");
                return;
            }
        }
        System.out.println("RR Rules check Passed, ALl the rewards have corresponding RR rule!");
        LoyaltyProgramDAO loyaltyProgramDAO = new LoyaltyProgramDAO();
        LoyaltyProgram loyaltyProgram = loyaltyProgramDAO.getLoyaltyProgram(brand.getbid());
        if(loyaltyProgram!=null && loyaltyProgram.getIsTier()==1) {
            TierProgramDAO tierProgramDAO = new TierProgramDAO();
            List<TierProgram> tierPrograms = tierProgramDAO.getAllTierPrograms(brand.getbid());
            if (tierPrograms != null) {
                if (tierPrograms.size() > 3) {
                    System.out.println("This Brand has more than 3 tiers! Validation Failed!");
                    return;
                }
                else{
                    System.out.println("This Brand has "+tierPrograms.size()+ " tiers!");
                }
            }
        }
        else if(loyaltyProgram==null){
            System.out.println("No Loyalty Program found! Validation Failed!");
        }
        int updateStatus = loyaltyProgramDAO.updateLoyaltyProgram(brand.getbid(),1);
        if(updateStatus==1){
            System.out.println("Loyalty program state is set to active");
        }else{
            System.out.println("Loyalty program state update failed! Try again!");
        }
        status=true;
    }

    void goBack() throws Exception {
        status=true;
    }
}
