package designPattern.decorator;

import designPattern.decorator.tiaoliao.Mocha;
import designPattern.decorator.tiaoliao.Whip;
import designPattern.decorator.yinliao.Coffee;

/**
 * Created by pc on 2016/12/8.
 */
public class CoffeeTest {
    public static void main(String[] args){
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription()+ ":" +coffee.cost());

        Beverage coffee2 = new Coffee();
        coffee2 = new Mocha(coffee2);
        coffee2 = new Mocha(coffee2);
        coffee2 = new Whip(coffee2);

//        Beverage whip = new Whip(mocha);
//        不知道为什么这样写会输出”unknow beverage,whip1.61“

        System.out.println(coffee2.getDescription() + ":" +coffee2.cost());
    }
}
