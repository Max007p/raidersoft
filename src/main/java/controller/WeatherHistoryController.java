package controller;

import dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.WeatherHistoryService;

import java.io.IOException;

@RestController
@RequestMapping("")
public class WeatherHistoryController {

    @Autowired
    private WeatherHistoryService weatherHistoryService;

    @GetMapping("/weather")
    public WeatherDTO getWeatherForToday() throws IOException, InterruptedException {
        return weatherHistoryService.getTodaysWeather();
    }
}
