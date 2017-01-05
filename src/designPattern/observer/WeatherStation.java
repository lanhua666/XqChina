package designPattern.observer;

/**
 * Created by pc on 2016/12/6.
 */
public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        currentDisplay.resister();

        weatherData.setMeasurements("111","111","111");
        weatherData.setMeasurements("222","222","222");
        weatherData.setMeasurements("333","333","333");
    }
}
