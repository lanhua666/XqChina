package designPattern.state;

import java.io.Serializable;

/**
 * Created by pc on 2017/1/12.
 */
public interface State extends Serializable{
    public void turnCrank();
    public void insert();
    public void back();
    public void give();
}
