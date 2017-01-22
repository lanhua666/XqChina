package designPattern.proxy.java;

import java.lang.reflect.Proxy;
import java.security.acl.Owner;

/**
 * Created by pc on 2017/1/20.
 */
public class Test {
    public static void main(String[] args){
        Test test = new Test();
        PersonBean personBean = new PersonBeanImpl("lanhua666",11);
        PersonBean ownProxy = test.getOwnProxy(personBean);
        PersonBean otherProxy = test.getOtherProxy(personBean);

        System.out.println(personBean.getName()+personBean.getAge());

        System.out.println("通过代理访问");

        System.out.println(ownProxy.getName());
        ownProxy.setName("lanhua111");
        System.out.println(otherProxy.getName());
        try{
            otherProxy.setName("lanhua222");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("can not set name");
        }

    }

    public PersonBean getOwnProxy(PersonBean personBean){
        return (PersonBean)Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                                                    personBean.getClass().getInterfaces(),
                                                    new OwnProxyHandler(personBean));
    }

    public PersonBean getOtherProxy(PersonBean personBean){
        return (PersonBean)Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
                                                    personBean.getClass().getInterfaces(),
                                                    new OtherProxyHandler(personBean));
    }
}
