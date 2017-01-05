package designPattern.strategy.behavior;

import designPattern.strategy.behavior.impl.QuackBehavior;

/**
 * Created by pc on 2016/12/2.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
