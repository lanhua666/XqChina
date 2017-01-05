package designPattern.template;

/**
 * Created by pc on 2017/1/4.
 */
public class Test {
    public static void main(String[] args){
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();
        tea.prepare();
        coffee.prepare();
    }
}
