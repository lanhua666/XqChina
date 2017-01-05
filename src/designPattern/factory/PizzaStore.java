package designPattern.factory;

/**
 * Created by pc on 2016/12/14.
 */
public  class PizzaStore {
    Factorynnn factorynnn;
    public PizzaStore(Factorynnn factorynnn){
        this.factorynnn = factorynnn;
    }
    public Pizza orderPizza(String pizza){
        return factorynnn.create(pizza);
    }
}
