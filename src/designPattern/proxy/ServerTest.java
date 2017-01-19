package designPattern.proxy;

import designPattern.state.Machine;

import java.rmi.Naming;

/**
 * Created by pc on 2017/1/17.
 */
public class ServerTest  {
    public static void main(String[] args){
        try{
            RemoteServer remoteServer = new Machine(5);
            Naming.rebind("127.0.0.1",remoteServer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
