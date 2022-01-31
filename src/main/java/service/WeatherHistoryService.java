package service;

import dto.WeatherDTO;
import entity.WeatherHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.WeatherHistoryRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

@Service
public class WeatherHistoryService {

    @Autowired
    WeatherHistoryRepository weatherHistoryRepository;

    public WeatherDTO getTodaysWeather() throws IOException, InterruptedException {
        WeatherDTO weatherDTO = new WeatherDTO();
        if (weatherHistoryRepository.existsById(new Date())) {
            weatherDTO.setTemparature(weatherHistoryRepository.getById(new Date()).getWeatherValue());
        } else {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://yandex.ru/"))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String result = response.body();
            int startIndex = result.indexOf("weather__temp");
            int endIndex = result.indexOf("<", startIndex);
            weatherDTO.setTemparature(result.substring(startIndex + 15, endIndex));
            WeatherHistory weather = new WeatherHistory(new Date(), weatherDTO.getTemparature());
            weatherHistoryRepository.save(weather);
        }
        return weatherDTO;
    }
}
