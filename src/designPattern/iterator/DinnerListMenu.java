package designPattern.iterator;

import java.util.ArrayList;

/**
 * Created by pc on 2017/1/5.
 */
public class DinnerListMenu {
    private ArrayList foodList;

    public DinnerListMenu(){
        foodList = new ArrayList();
        addFood("aaa","111");
        addFood("bbb","222");
        addFood("ccc","333");
    }

    public void addFood(String name,String price){
        foodList.add(new Food(name,price));
    }


    public DinnerListIterator createIterator(){
        return new DinnerListIterator(foodList);
    }
}
