package UdemyCourse.springBoot.covidTracker.services;

import UdemyCourse.springBoot.covidTracker.models.LocationStatistics;
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
public class CovidDataService {

    private final String covidDataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationStatistics> statisticsList = new ArrayList<>();


    public String getCovidDataURL() {
        return covidDataURL;
    }

    @PostConstruct
    @Scheduled(cron = "* * 2 * * *")
    public void fetchCovidData() throws IOException, InterruptedException {
        List<LocationStatistics> tempStatisticsList = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getCovidDataURL())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());  // test if we're getting the expected dta from repo
        StringReader csvReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            LocationStatistics statistics = new LocationStatistics();
            statistics.setState(record.get("Province/State"));
            statistics.setCountry(record.get("Country/Region"));
            statistics.setTotalCases(Integer.parseInt(record.get(record.size()-1)));
            System.out.println(statistics);
            tempStatisticsList.add(statistics);

        }
        this.statisticsList=tempStatisticsList;
    }
}
