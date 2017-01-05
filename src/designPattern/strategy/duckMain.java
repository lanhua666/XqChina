package designPattern.strategy;

/**
 * Created by pc on 2016/12/2.
 */
public class duckMain {
    public static void main(String[] args){
        Duck duck1 = new Bduck();
        Duck duck2 = new Rduck();

        duck1.performFly();
        duck1.performQuack();

        duck2.performFly();
        duck2.performQuack();
    }
}
