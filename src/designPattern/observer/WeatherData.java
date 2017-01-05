package designPattern.observer;

import designPattern.observer.impl.Observer;
import designPattern.observer.impl.Subject;

import java.util.ArrayList;

/**
 * Created by pc on 2016/12/6.
 */
public class WeatherData implements Subject{
    private String temperature;
    private String humidity;
    private String pressure;
    private ArrayList<Observer> arrayList;

    public WeatherData(){
        arrayList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o){
        arrayList.add(o);
    }

    @Override
    public void removeObserver(Observer o){
        int i = arrayList.indexOf(o);
        arrayList.remove(i);
    }

    @Override
    public void notifyObservers(){
        for(int i = 0; i < arrayList.size(); i++){
             arrayList.get(i).update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(String temperature, String humidity, String pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
