package designPattern.proxy;

/**
 * Created by pc on 2017/1/17.
 */
public class Client {
    RemoteServer remoteServer;
    public Client(RemoteServer remoteServer){
        this.remoteServer = remoteServer;
    }
    public void report(){
        System.out.println(remoteServer.getCount());
        System.out.println(remoteServer.getState().toString());
    }
}
