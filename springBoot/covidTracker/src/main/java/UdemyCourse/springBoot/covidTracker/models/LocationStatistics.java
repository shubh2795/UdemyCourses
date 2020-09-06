package UdemyCourse.springBoot.covidTracker.models;

public class LocationStatistics {
    private String country;
    private String state;
    private int totalCases;
    private int differenceFromPrevDay;


    public int getDifferenceFromPrevDay() {
        return differenceFromPrevDay;
    }

    public void setDifferenceFromPrevDay(int differenceFromPrevDay) {
        this.differenceFromPrevDay = differenceFromPrevDay;
    }


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

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    @Override
    public String toString() {
        return "LocationStatistics{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", totalCases=" + totalCases +
                ", differenceFromPrevDay=" + differenceFromPrevDay +
                '}';
    }
}
