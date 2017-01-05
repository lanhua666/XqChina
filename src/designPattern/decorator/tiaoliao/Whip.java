package designPattern.decorator.tiaoliao;

import designPattern.decorator.Beverage;
import designPattern.decorator.Condiment;

/**
 * Created by pc on 2016/12/8.
 */
public class Whip extends Condiment {
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
            return beverage.getDescription() + ",whip";
    }

    @Override
    public double cost() {
        return 0.3 + beverage.cost();
    }
}
