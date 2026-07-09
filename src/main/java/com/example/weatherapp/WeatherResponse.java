package com.example.weatherapp;

import java.util.List;

public class WeatherResponse {
    private List<ForecastData> list;

    public List<ForecastData> getList() { return list; }
    public void setList(List<ForecastData> list) { this.list = list; }

    public static class ForecastData {
        private MainData main;
        private String dt_txt;

        public MainData getMain() { return main; }
        public void setMain(MainData main) { this.main = main; }

        public String getDt_txt() { return dt_txt; }
        public void setDt_txt(String dt_txt) { this.dt_txt = dt_txt; }
    }

    public static class MainData {
        private double temp;
        private int humidity;

        public double getTemp() { return temp; }
        public void setTemp(double temp) { this.temp = temp; }

        public int getHumidity() { return humidity; }
        public void setHumidity(int humidity) { this.humidity = humidity; }
    }
}