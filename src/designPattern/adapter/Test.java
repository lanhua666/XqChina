package designPattern.adapter;

/**
 * Created by pc on 2017/1/3.
 */
public class Test {
    public static void main(String[] args){
        Turkey turkey = new TestTurkey();
        Duck adapter = new Adapter(turkey);
        adapter.quack();
        adapter.fly();
    }
}
