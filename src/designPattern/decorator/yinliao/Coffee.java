package designPattern.decorator.yinliao;

import designPattern.decorator.Beverage;

/**
 * Created by pc on 2016/12/8.
 */
public class Coffee extends Beverage {

    public Coffee(){
        this.description = "I'm coffee";
    }

    @Override
    public double cost() {
        return 1.11;
    }
}
