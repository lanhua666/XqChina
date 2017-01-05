package designPattern.adapter;

/**
 * Created by pc on 2017/1/3.
 */
public class TestDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("gaga jiao");
    }

    @Override
    public void fly() {
        System.out.println("flying");
    }
}
