package designPattern.state;

/**
 * Created by pc on 2017/1/13.
 */
//
public class NoHas implements State {

    transient Machine machine;

    public NoHas(Machine machine){
        this.machine = machine;
    }

    @Override
    public void turnCrank() {
        System.out.println("no coin, turn crank has no effect");
    }

    @Override
    public void insert() {
        System.out.println("success insert a coin");
        machine.setState(machine.getHas());
    }

    @Override
    public void back() {
        System.out.println("no coin, can not back");
    }

    @Override
    public void give() {
        System.out.println("can not give, please insert a coin");
    }

    @Override
    public String toString() {
        return "Nohas";
    }
}
