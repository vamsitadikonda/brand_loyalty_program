package Objects_Data;
/*POJO - plain old java object - classes which are supposed to hold data */
public class Brand {

    //since this class holds the same data as the db table, it should have the same fields as the table
    String bid;
    String brandName;
    String brandDate;
    String brandAddress;
    String brandUserName;
    String brandPassword;
//    String brandLP_Code;
//    String brandLP_Name;
//    String brandTiers;
//    String brandPointsRequired;
//    String brandmultiplier;

    //default constructor
    public Brand(){

    }

    public Brand(String bid, String brandName, String brandDate, String brandAddress) {
        this.bid = bid;
        this.brandName = brandName;
        this.brandDate = brandDate;
        this.brandAddress = brandAddress;
    }

    public Brand(String bid, String brandName, String brandDate, String brandAddress, String brandUserName, String brandPassword) {
        this.bid = bid;
        this.brandName = brandName;
        this.brandDate = brandDate;
        this.brandAddress = brandAddress;
        this.brandUserName = brandUserName;
        this.brandPassword = brandPassword;
//        this.brandLP_Code = brandLP_Code;
//        this.brandLP_Name = brandLP_Name;
//        this.brandTiers = brandTiers;
//        this.brandPointsRequired = brandPointsRequired;
//        this.brandmultiplier = brandmultiplier;
    }

    //getter and setters

    public String getbid() {
        return bid;
    }
    public String getbrandName(){return brandName; }
    public String getbrandDate(){return brandDate;}
    public String getbrandAddress() {
        return brandAddress;
    }
    public String getBrandUserName() {
        return brandUserName;
    }

    public String getBrandPassword() {
        return brandPassword;
    }
    //    public String getbrandLP_Code(){return brandLP_Code; }
//    public String getbrandLP_Name() {
//        return brandLP_Name;
//    }
//    public String getbrandTiers(){return brandTiers; }
//    public String getbrandPointsRequired() {
//        return brandPointsRequired;
//    }
//    public String getbrandmultiplier(){return brandmultiplier; }




    public void setbid(String bid) {this.bid = bid;}
    public void setbrandName(String brandName){this.brandName = brandName; }
    public void setbrandDate(String branDate){this.brandName = brandDate; }
    public void setbrandAddress(String Address) {this.brandAddress = brandAddress;}
    public void setBrandUserName(String brandUserName) {
        this.brandUserName = brandUserName;
    }

    public void setBrandPassword(String brandPassword) {
        this.brandPassword = brandPassword;
    }
    //    public void setbrandLC_Code(String LP_Code){this.brandLP_Code = brandLP_Code; }
//    public void setbrandLC_Name(String LP_Name) {this.brandLP_Name = brandLP_Name;}
//    public void setbrandTiers(String getTiers){this.brandTiers = brandTiers; }
//    public void setbrandPointsRequired(String getPointsRequired) {this.brandPointsRequired = brandPointsRequired;}
//    public void setbrandmultiplier(String getmultiplier){this.brandmultiplier = brandmultiplier; }




    @Override
    public String toString(){
        return "Brand [bid=" + this.getbid() + ", brandName=" + this.getbrandName() + ", Address=" + this.getbrandAddress() +
                ", join date=" + this.getbrandDate() + ", userName="+ this.getBrandUserName() +"]";
    }

    public void run() {
    }
}
