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

@Service
public class CovidRecoveryDataService {
    private final String covidRecoveriesDataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";
    public String getCovidRecoveriesDataURL() {
        return covidRecoveriesDataURL;
    }

    @PostConstruct
    @Scheduled(cron = "* * 2 * * *")
    public void fetchCovidDeaths() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getCovidRecoveriesDataURL())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            LocationRecoveries statistics = new LocationRecoveries();
            int latestRecoveries = Integer.parseInt(record.get(record.size() - 1));
            statistics.setRecoveries(latestRecoveries);
        }
    }
}
