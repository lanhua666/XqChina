package designPattern.decorator.yinliao;

import designPattern.decorator.Beverage;

/**
 * Created by pc on 2016/12/8.
 */
public class Tea extends Beverage {

    public Tea(){
        this.description = "I'm tea";
    }

    @Override
    public double cost() {
        return 2.22;
    }
}
