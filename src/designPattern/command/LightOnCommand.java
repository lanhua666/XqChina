package designPattern.command;

/**
 * Created by pc on 2016/12/30.
 */
//继承Command，确定要执行的命令
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        //receiver.action（）
        light.on();
    }
}
