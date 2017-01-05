package designPattern.observer;

import designPattern.observer.impl.DisplayElement;
import designPattern.observer.impl.Observer;
import designPattern.observer.impl.Subject;

/**
 * Created by pc on 2016/12/6.
 */
public class CurrentDisplay implements Observer, DisplayElement {
    private String temperature;
    private String humidity;
    private String pressure;
    private Subject subject;

    public CurrentDisplay(Subject sub){
        this.subject = sub;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void resister(){
        subject.registerObserver(this);
    }

    public void remove(){
        subject.removeObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前温度是" + temperature + "," + "当前湿度是" + humidity);
    }

    @Override
    public void update(String tem, String hum, String pre) {
        this.temperature = tem;
        this.humidity = hum;
        this.pressure = pre;
        display();
    }
}
