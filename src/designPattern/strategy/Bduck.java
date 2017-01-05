package designPattern.strategy;

import designPattern.strategy.behavior.FlyWithWings;
import designPattern.strategy.behavior.Quack;

/**
 * Created by pc on 2016/12/2.
 */
//黑鸭
public class Bduck extends Duck{
    
    public Bduck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("我是一只黑鸭子");
    }

}
