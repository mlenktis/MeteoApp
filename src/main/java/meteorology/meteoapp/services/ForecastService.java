package meteorology.meteoapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import meteorology.meteoapp.fields.Root;
import meteorology.meteoapp.models.ForecastModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

@Service
public class ForecastService {
    private static String GetMeteoForecastsJson(String city) throws IOException, MalformedURLException {
        URL url = new URL("https://api.meteo.lt/v1/places/" + city + "/forecasts/long-term");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        StringBuilder text = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            text.append(scanner.nextLine());
        }
        scanner.close();
        return text.toString();
    }
    public static ArrayList<ForecastModel> getForecasts(String city) throws IOException {
        var forecasts = new ArrayList<ForecastModel>();

        if (!Objects.equals(city, "")) {
            var meteoForecastsJson = GetMeteoForecastsJson(city);
            var meteoForecasts = GetObjectFromJson(meteoForecastsJson);

            for (var fr : meteoForecasts.forecastTimestamps) {
                var item = new ForecastModel(fr.forecastTimeUtc, fr.airTemperature);
                forecasts.add(item);
            }
        }

        return forecasts;
    }
    private static Root GetObjectFromJson(String json) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Root obj = om.readValue(json, Root.class);

        return obj;
    }

}
