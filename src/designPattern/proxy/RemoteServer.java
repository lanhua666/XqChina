package designPattern.proxy;

import designPattern.state.State;

import java.rmi.Remote;

/**
 * Created by pc on 2017/1/17.
 */
public interface RemoteServer extends Remote {
    public int getCount();
    public State getState();
}
