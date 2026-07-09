package com.example.weatherapp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    // TODO: Apni email wali OpenWeatherMap ki API key yahan daaliye
    private final String API_KEY = "9b17d8ab802550955ce83789d504f12f"; 
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";

    public List<WeatherResponse.ForecastData> get5DayForecast(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
        
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
        List<WeatherResponse.ForecastData> filteredForecast = new ArrayList<>();
        
        if (response != null && response.getList() != null) {
            for (WeatherResponse.ForecastData data : response.getList()) {
                // Har din ke dopahar 12 baje ka data filter karne ke liye
                if (data.getDt_txt().contains("12:00:00")) {
                    filteredForecast.add(data);
                }
            }
        }
        return filteredForecast;
    }
}