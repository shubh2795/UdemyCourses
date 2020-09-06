package UdemyCourse.springBoot.covidTracker.services;

import UdemyCourse.springBoot.covidTracker.models.LocationRecoveries;
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
public class CovidRecoveryDataService {
    private final String covidRecoveriesDataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
    private List<LocationRecoveries> statisticsList = new ArrayList<>();

    public List<LocationRecoveries> getStatisticsList() {
        return statisticsList;
    }

    public String getCovidRecoveriesDataURL() {
        return covidRecoveriesDataURL;
    }

    @PostConstruct
    @Scheduled(cron = "* * 2 * * *")
    public void fetchCovidDeaths() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getCovidRecoveriesDataURL())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<LocationRecoveries> tempStatisticsList = new ArrayList<>();
        StringReader csvReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            LocationRecoveries statistics = new LocationRecoveries();
            statistics.setState(record.get("Province/State"));
            statistics.setCountry(record.get("Country/Region"));
            int latestRecoveries = Integer.parseInt(record.get(record.size() - 1));
            int prevDayRecoveries = Integer.parseInt(record.get(record.size() - 2));
            statistics.setDifferenceFromPrevDay(latestRecoveries-prevDayRecoveries);
            statistics.setRecoveries(latestRecoveries);
            tempStatisticsList.add(statistics);
        }
        this.statisticsList = tempStatisticsList;

    }
}
