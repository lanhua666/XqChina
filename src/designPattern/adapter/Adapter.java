package designPattern.adapter;

/**
 * Created by pc on 2017/1/3.
 */
public class Adapter implements Duck{
    Turkey turkey;

    public Adapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.guagua();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
