package designPattern.iterator;

/**
 * Created by pc on 2017/1/5.
 */
public class Food {

    private String name;
    private String price;

    public Food(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
