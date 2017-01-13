package designPattern.state;

/**
 * Created by pc on 2017/1/13.
 */
public class Test {
    public static void main(String[] args){
        Machine machine = new Machine(10);
        machine.display();
        System.out.println("+++++++++++++++++++++++++++++");
        machine.insert();
        machine.display();
        System.out.println("+++++++++++++++++++++++++++++");
        machine.turnCrank();
        machine.display();
        System.out.println("+++++++++++++++++++++++++++++");
        machine.give();
        machine.display();
    }
}
