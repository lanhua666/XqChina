package designPattern.factory;

/**
 * Created by pc on 2016/12/14.
 */
public class PizzaTest {
    public static void main(String[] args){
        Factorynnn factorynnn = new Factorynnn();
        PizzaStore pizzaStore = new PizzaStore(factorynnn);
        Pizza pizza = pizzaStore.orderPizza("AAA");
        pizza.getString();
    }
}
