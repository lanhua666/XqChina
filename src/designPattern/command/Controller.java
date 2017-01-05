package designPattern.command;

/**
 * Created by pc on 2016/12/30.
 */
//女招待→invoker.即调用者
public class Controller {
    Command command;

    public Controller(){
    }

    //交给receiver
    public void invoker(){
        command.execute();
    }

    //设置具体执行哪个命令
    public void setCommand(Command command){
        this.command = command;
    }
}
