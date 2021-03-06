package designPattern.state;

import designPattern.proxy.RemoteServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pc on 2017/1/12.
 */
public class Machine extends UnicastRemoteObject implements RemoteServer{

    private int count;
    private State state;

    private NoHas noHas;
    private Has has;
    private Give give;
    private Saleout noSweet;

    public Machine(int count) throws RemoteException{
        this.noHas = new NoHas(this);
        this.has = new Has(this);
        this.give = new Give(this);
        this.noSweet = new Saleout(this);
        this.state = noHas;
        this.count = count;
    }

    //
    public void turnCrank(){
        state.turnCrank();
    }
    //
    public void insert(){
        state.insert();
    }
    //
    public void back(){
        state.back();
    }
    //
    public void give(){
        state.give();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Has getHas() {
        return has;
    }

    public void setHas(Has has) {
        this.has = has;
    }

    public NoHas getNoHas() {
        return noHas;
    }

    public void setNoHas(NoHas noHas) {
        this.noHas = noHas;
    }

    public Give getGive() {
        return give;
    }

    public void setGive(Give give) {
        this.give = give;
    }

    public Saleout getNoSweet() {
        return noSweet;
    }

    public void setNoSweet(Saleout noSweet) {
        this.noSweet = noSweet;
    }

    public void countJian(){
        count = count -1;
    }

    public void display(){
        System.out.println("coin  count is " + this.getCount() + ", the state is " + this.getState().toString());
    }
}
