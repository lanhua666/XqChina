package designPattern.proxy;

import designPattern.state.State;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by pc on 2017/1/18.
 */
public class ClientTest {
    public static void main(String[] args){
        try {
            RemoteServer remoteServer = (RemoteServer) Naming.lookup("127.0.0.1");
            Client client = new Client(remoteServer);
            client.report();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
