package UdemyCourse.springBoot.covidTracker.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CovidDataService {

    private final String covidDataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public String getCovidDataURL() {
        return covidDataURL;
    }

    @PostConstruct
    public void fetchCovidData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(getCovidDataURL())).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());  // test if we're getting the expected dta from repo
        StringReader csvReader = new StringReader((String) response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        for (CSVRecord record : records) {
            String state = record.get("Province/State");
            String customerNo = record.get("CustomerNo");
            String name = record.get("Name");
        }

    }
}
