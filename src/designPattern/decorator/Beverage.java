package designPattern.decorator;

/**
 * Created by pc on 2016/12/8.
 */

public abstract class Beverage {
    public String description = "unknow beverage";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();

}
