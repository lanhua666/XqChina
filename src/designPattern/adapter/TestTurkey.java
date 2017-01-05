package designPattern.adapter;

/**
 * Created by pc on 2017/1/3.
 */
public class TestTurkey implements Turkey {
    @Override
    public void guagua() {
        System.out.println("guagua jiao");
    }

    @Override
    public void fly() {
        System.out.println("flying");
    }
}
