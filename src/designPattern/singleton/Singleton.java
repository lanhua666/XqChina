package designPattern.singleton;

/**
 * Created by pc on 2016/12/19.
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized(Singleton.class){
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void getDes(){
        System.out.println("11111");
    }
}
