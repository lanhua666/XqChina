package designPattern.strategy.behavior;

import designPattern.strategy.behavior.impl.QuackBehavior;

/**
 * Created by pc on 2016/12/2.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
