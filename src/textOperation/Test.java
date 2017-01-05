package textOperation;
class MyThread implements Runnable{
    private int ticket = 99;
    public void run(){
        for (int i=0;i<100;i++)
        {
            if(ticket > 0){
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}

public class Test {
    public static void main(String[] args){
        MyThread my = new MyThread();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}