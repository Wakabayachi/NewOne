package com.kodilla.testing.weather.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        return temperatures.getTemperatures();
    }

    public double calculateAverageTemperature() {
        Map<String, Double> temperatureMap = temperatures.getTemperatures();
        double sum = 0;
        for (double temperature : temperatureMap.values()) {
            sum += temperature;
        }
        return sum / temperatureMap.size();
    }

    public double calculateMedianTemperature() {
        List<Double> temperatureList = new ArrayList<>(temperatures.getTemperatures().values());
        temperatureList.sort(Double::compareTo);
        int size = temperatureList.size();
        if (size % 2 == 0) {
            return (temperatureList.get(size / 2 - 1) + temperatureList.get(size / 2)) / 2;
        } else {
            return temperatureList.get(size / 2);
        }
    }
}