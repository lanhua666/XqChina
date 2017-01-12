package designPattern.iterator;

import java.util.ArrayList;

/**
 * Created by pc on 2017/1/5.
 */
public class DinnerListIterator implements Iterator{
    private ArrayList foodlist;
    int length = 0;

    public DinnerListIterator(ArrayList foodlist){
        this.foodlist = foodlist;
    }

    @Override
    public boolean hasNext() {
        if(length < foodlist.size()  && foodlist.get(length) != null ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object next() {
        return foodlist.get(length++);
    }
}
