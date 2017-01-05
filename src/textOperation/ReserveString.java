package textOperation;

import java.util.Scanner;

/**
 * Created by pc on 2016/11/10.
 */
//逆转字符串——输入一个字符串，将其逆转并输出
public class ReserveString {

    public static void main(String[] args) {
        System.out.println("please input string (0 exit):");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String aaa = scanner.next();
            if(aaa.equals("0")){
                break;
            }
            System.out.println("before reserve the string is:" + aaa);
            aaa = reserve(aaa);
            System.out.println("after  reserve the string is:" + aaa);
        }
    }

    public static String reserve(String theString){
        String sumString = "";
        for(int i=theString.length(); i>0; i--) {
            char str = theString.charAt(i-1);
            sumString = sumString + str;
        }
        return sumString;
    }
}
