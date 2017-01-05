package designPattern.command;

/**
 * Created by pc on 2016/12/30.
 */
//快餐厨师→Receiver，真正执行命令的
public class Light {

    public void on() {
        System.out.println("The light is on");
    }

    public void off(){
        System.out.println("The light is off");
    }
}
