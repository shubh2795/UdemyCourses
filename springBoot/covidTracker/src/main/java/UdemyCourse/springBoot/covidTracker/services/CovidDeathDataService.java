package UdemyCourse.springBoot.covidTracker.services;

import UdemyCourse.springBoot.covidTracker.models.LocationDeaths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDeathDataService {
    private final String covidDeathsDataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
    private List<LocationDeaths> statisticsList = new ArrayList<>();

    public List<LocationDeaths> getStatisticsList() {
        return statisticsList;
    }



    public String getCovidDeathsDataURL() {
        return covidDeathsDataURL;
    }

    @PostConstruct
    @Scheduled(cron = "* * 2 * * *")
    public void fetchCovidDeaths() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getCovidDeathsDataURL())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<LocationDeaths> tempStatisticsList = new ArrayList<>();
        StringReader csvReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            LocationDeaths statistics = new LocationDeaths();
            statistics.setState(record.get("Province/State"));
            statistics.setCountry(record.get("Country/Region"));
            int latestDeaths = Integer.parseInt(record.get(record.size() - 1));
            int prevDayDeaths = Integer.parseInt(record.get(record.size() - 2));
            statistics.setDeaths(latestDeaths);
            statistics.setDifferenceFromPrevDay(latestDeaths-prevDayDeaths);
            tempStatisticsList.add(statistics);

        }
        this.statisticsList = tempStatisticsList;
    }
}