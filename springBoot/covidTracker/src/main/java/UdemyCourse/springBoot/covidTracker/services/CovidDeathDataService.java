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

@Service
public class CovidDeathDataService {
    private final String covidDeathsDataURL = "https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";


    public String getCovidDeathsDataURL() {
        return covidDeathsDataURL;
    }

    @PostConstruct
    @Scheduled(cron = "* * 2 * * *")
    public void fetchCovidDeaths() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getCovidDeathsDataURL())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            LocationDeaths statistics = new LocationDeaths();
            int latestDeaths = Integer.parseInt(record.get(record.size() - 1));
            statistics.setDeaths(latestDeaths);

        }

    }
}