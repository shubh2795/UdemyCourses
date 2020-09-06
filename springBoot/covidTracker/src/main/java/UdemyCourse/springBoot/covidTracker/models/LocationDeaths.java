package UdemyCourse.springBoot.covidTracker.models;

public class LocationDeaths {
    private int deaths;
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


    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }


}
