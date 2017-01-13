package designPattern.state;

/**
 * Created by pc on 2017/1/13.
 */
public class Saleout implements State {
    Machine machine;

    public Saleout(Machine machine){
        this.machine = machine;
    }

    @Override
    public void turnCrank() {
        System.out.println("sweet has been saled out");
    }

    @Override
    public void insert() {
        System.out.println("sweet has been saled out");
    }

    @Override
    public void back() {
        System.out.println("sweet has been saled out");
    }

    @Override
    public void give() {
        System.out.println("sweet has been saled out");
    }

    @Override
    public String toString() {
        return "NoSweet";
    }
}