package designPattern.observer;

import designPattern.observer.impl.DisplayElement;

import java.util.Observable;
import java.util.Observer;
/**
 * Created by pc on 2016/12/6.
 */
public class TestObserve implements Observer,DisplayElement{

    private String temperature;
    private String humidity;

    public TestObserve(Observable o){
        o.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前温度是" + temperature + "," + "当前湿度是" + humidity);
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof TestSubject){
            this.temperature = ((TestSubject) o).getTemperature();
            this.humidity = ((TestSubject) o).getHumidity();
            display();
        }
    }
}
