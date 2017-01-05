package designPattern.template;

/**
 * Created by pc on 2017/1/4.
 */
public abstract class Beverage {

    final void prepare(){
        method1();
        method2();
        method3();
        method4();
    }

    public abstract void method1();
    public abstract void method2();

    public void method3(){
           System.out.println("3333");
    }

    public void method4(){
        System.out.println("4444");
    }


}
