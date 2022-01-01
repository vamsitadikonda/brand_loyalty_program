package Objects_Data;
/*POJO - plain old java object - classes which are supposed to hold data */
public class ActivityType {

    //since this class holds the same data as the db table, it should have the same fields as the table
    String activityType;
    int activityCode;
    String activityID;

    public ActivityType(String activityType, int activityCode) {
        this.activityType = activityType;
        this.activityCode = activityCode;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public int getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(int activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "activityType='" + activityType + '\'' +
                ", activityCode=" + activityCode +
                '}';
    }
}