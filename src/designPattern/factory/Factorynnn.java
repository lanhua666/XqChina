package designPattern.factory;

/**
 * Created by pc on 2016/12/14.
 */
public class Factorynnn {
    public Pizza create(String type){
        if(type.equals("AAA")){
            return new AAAPizza();
        }else if(type.equals("BBB")){
            return new BBBPizza();
        }else if(type.equals("CCC")){
            return new CCCPizza();
        }else{
            return null;
        }
    }
}
