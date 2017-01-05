package designPattern.strategy.behavior;

import designPattern.strategy.behavior.impl.FlyBehavior;

/**
 * Created by pc on 2016/12/2.
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("用翅膀飞");
    }
}
