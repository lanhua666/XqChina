package designPattern.state;

/**
 * Created by pc on 2017/1/13.
 */
public class Has implements State {

    transient Machine machine;

    public Has(Machine machine){
        this.machine = machine;
    }

    @Override
    public void turnCrank() {
        System.out.println("successful, will give");
        machine.setState(machine.getGive());
    }

    @Override
    public void insert() {
        System.out.println("has coin, can not insert");
    }

    @Override
    public void back() {
        System.out.println("ok, coin back");
        machine.setState(machine.getNoHas());
    }

    @Override
    public void give() {
        System.out.println("please turn crank");
    }

    @Override
    public String toString() {
        return "Has";
    }
}
