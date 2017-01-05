package designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pc on 2016/12/6.
 */
public class TestSubject extends Observable{
    private String temperature;
    private String humidity;
    private String pressure;

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(String tem, String hum, String pre){
        this.temperature = tem;
        this.humidity = hum;
        measurementsChanged();
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }
}
