package designPattern.iterator;

/**
 * Created by pc on 2017/1/5.
 */
public class DinnerArrayIterator implements Iterator{

    private Food[] foods;

    private int num = 0;

    public DinnerArrayIterator(Food[] foods){
        this.foods = foods;
    }

    @Override
    public boolean hasNext() {;
        if(num < foods.length  && foods[num] != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        return foods[num++];
    }
}
