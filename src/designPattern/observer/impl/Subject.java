package designPattern.observer.impl;

/**
 * Created by pc on 2016/12/6.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
