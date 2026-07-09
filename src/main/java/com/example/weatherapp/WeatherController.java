package com.example.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Test URL: http://localhost:8080/weather?city=Delhi
    @GetMapping("/weather")
    public List<WeatherResponse.ForecastData> getWeather(@RequestParam String city) {
        return weatherService.get5DayForecast(city);
    }
}