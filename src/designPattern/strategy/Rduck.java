package designPattern.strategy;


import designPattern.strategy.behavior.FlyNoWay;
import designPattern.strategy.behavior.Squeak;

/**
 * Created by pc on 2016/12/2.
 */
//橡胶鸭
public class Rduck extends Duck{

    public Rduck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display(){
        System.out.println("我是一只橡胶鸭");
    }
}
