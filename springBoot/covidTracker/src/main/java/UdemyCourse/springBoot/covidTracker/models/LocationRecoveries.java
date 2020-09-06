package UdemyCourse.springBoot.covidTracker.models;

public class LocationRecoveries {
    private int recoveries;
    private int DifferenceFromPrevDay;
    private String country;
    private String state;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getDifferenceFromPrevDay() {
        return DifferenceFromPrevDay;
    }

    public void setDifferenceFromPrevDay(int differenceFromPrevDay) {
        DifferenceFromPrevDay = differenceFromPrevDay;
    }


    public int getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(int recoveries) {
        this.recoveries = recoveries;
    }


}


