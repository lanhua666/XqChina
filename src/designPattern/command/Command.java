package designPattern.command;

/**
 * Created by pc on 2016/12/30.
 */
//订单→Command,需要（顾客→client）去（定制）实现
public interface Command {
    public void execute();
}
