package designPattern.iterator;

/**
 * Created by pc on 2017/1/9.
 */
public class Test {
    public static void main(String[] args){

        DinnerArrayMenu dinnerArrayMenu = new DinnerArrayMenu();
        DinnerListMenu dinnerListMenu = new DinnerListMenu();

        Iterator dinnerArrayIterator = dinnerArrayMenu.createArrayIterator();
        Iterator dinnerListIterator = dinnerListMenu.createIterator();

        while(dinnerArrayIterator.hasNext()){
            System.out.println(dinnerArrayIterator.next());
        }
        System.out.println("------------");

        while(dinnerListIterator.hasNext()){
            System.out.println(dinnerListIterator.next());
        }

    }
}
