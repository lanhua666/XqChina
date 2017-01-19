package designPattern.state;

/**
 * Created by pc on 2017/1/13.
 */
public class Give implements State {

    transient Machine machine;

    public Give(Machine machine){
         this.machine = machine;
    }

    @Override
    public void turnCrank() {
        System.out.println("have no effect, is giving");
    }

    @Override
    public void insert() {
        System.out.println("please wait, is giving");
    }

    @Override
    public void back() {
        System.out.println("can not back, is giving");
    }

    @Override
    public void give() {
        machine.countJian();
        System.out.println("give a sweet");
        if((machine.getCount()) < 1) {
            machine.setState(machine.getNoSweet());
        }else{
            machine.setState(machine.getNoHas());
        }
    }

    @Override
    public String toString() {
        return "Give";
    }
}
