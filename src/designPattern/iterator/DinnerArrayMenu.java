package designPattern.iterator;

/**
 * Created by pc on 2017/1/5.
 */
public class DinnerArrayMenu {
    private static int maxNum = 3;
    private int num = 0;
    private Food[] foods;

    public DinnerArrayMenu(){
        foods = new Food[maxNum];
        addFood("apple", "1");
        addFood("banana", "2");
        addFood("pear", "3");
    }

    public void addFood(String name,String price){
        if(num > maxNum-1){
            System.out.println("");
        }
        foods[num] = new Food(name,price);
        num ++;
    }
}
