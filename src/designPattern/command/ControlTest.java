package designPattern.command;

/**
 * Created by pc on 2016/12/30.
 */
public class ControlTest {
    public static void main(String[] args){
            //初始化一个invoker
            Controller controller = new Controller();
            //初始化receiver
            Light light = new Light();
            //初始化一个执行命令的对象
            Command lightoncommand = new LightOnCommand(light);

            //将执行命令的对象交给invoker
            controller.setCommand(lightoncommand);
            //执行invoker让receiver执行命令
            controller.invoker();
    }
}
