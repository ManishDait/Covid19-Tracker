package com.example.dockercovwebsite.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.dockercovwebsite.model.CoronaVirusStatsLocation;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CoronaVirusData {
    private String VirusDataUrl = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<CoronaVirusStatsLocation> allstats = new ArrayList();
    

    public List<CoronaVirusStatsLocation> getAllstats() {
        return allstats;
    }


    public void setAllstats(List<CoronaVirusStatsLocation> allstats) {
        this.allstats = allstats;
    }


    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchData() throws IOException, InterruptedException{
        List<CoronaVirusStatsLocation> newstats = new ArrayList();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VirusDataUrl)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvStringReader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvStringReader);
        for (CSVRecord record : records) {
            CoronaVirusStatsLocation coronaVirusStatsLocation = new CoronaVirusStatsLocation();
            coronaVirusStatsLocation.setCountry(record.get("Country/Region"));
            coronaVirusStatsLocation.setState(record.get("Province/State"));
            if(record.get("Province/State").isEmpty()){
                coronaVirusStatsLocation.setState("Entier Country");
            }
            coronaVirusStatsLocation.setCases(Integer.parseInt(record.get(record.size()-1)) - Integer.parseInt(record.get(record.size()-2)));
            coronaVirusStatsLocation.setTotalCases(Integer.parseInt(record.get(record.size()-1)));
            coronaVirusStatsLocation.setDifference((Integer.parseInt(record.get(record.size()-1)) - Integer.parseInt(record.get(record.size()-2))) - (Integer.parseInt(record.get(record.size()-2)) - Integer.parseInt(record.get(record.size()-3))));

            if(Integer.parseInt(record.get(record.size()-1)) - Integer.parseInt(record.get(record.size()-2))>(Integer.parseInt(record.get(record.size()-2)) - Integer.parseInt(record.get(record.size()-3)))){
                coronaVirusStatsLocation.setRising("true");
            }
            else{
                coronaVirusStatsLocation.setRising("false");
            }
            //System.out.println(coronaVirusStatsLocation);

            newstats.add(coronaVirusStatsLocation);
        }
        this.allstats = newstats;
    }
}
