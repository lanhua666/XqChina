package designPattern.proxy.java;

/**
 * Created by pc on 2017/1/20.
 */
public class PersonBeanImpl implements PersonBean {
    String name;
    int age;

    public PersonBeanImpl(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
