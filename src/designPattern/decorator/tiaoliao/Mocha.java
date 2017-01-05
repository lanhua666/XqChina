package designPattern.decorator.tiaoliao;

import designPattern.decorator.Beverage;
import designPattern.decorator.Condiment;

/**
 * Created by pc on 2016/12/8.
 */
public class Mocha extends Condiment {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }


    @Override
    public double cost() {
        return  beverage.cost();
    }
}
