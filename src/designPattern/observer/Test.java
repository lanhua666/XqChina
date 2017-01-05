package designPattern.observer;

/**
 * Created by pc on 2016/12/6.
 */
public class Test {
    public static void main(String[] args){
        TestSubject testSubject = new TestSubject();
        TestObserve testObserve = new TestObserve(testSubject);

        testSubject.setMeasurements("111","111","111");
    }
}
