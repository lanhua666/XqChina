package designPattern.strategy;

import designPattern.strategy.behavior.impl.FlyBehavior;
import designPattern.strategy.behavior.impl.QuackBehavior;

/**
 * Created by pc on 2016/12/2.
 */
//超类
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){

    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    public void swim(){
        System.out.println("游泳中");
    }
}
