package designPattern.strategy.behavior;

import designPattern.strategy.behavior.impl.QuackBehavior;

/**
 * Created by pc on 2016/12/2.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我不会叫");
    }
}
