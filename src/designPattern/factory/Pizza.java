package designPattern.factory;

/**
 * Created by pc on 2016/12/14.
 */
public abstract class Pizza {
    String name;
    String price;
    public void getString(){
        System.out.println(name + ":" +price);
    }
}
