package textOperation;

import java.util.Scanner;

/**
 * Created by pc on 2016/11/10.
 */
//拉丁猪文字游戏——这是一个英语语言游戏。
// 基本规则是将一个英语单词的第一个辅音音素
// 的字母移动到词尾并且加上后缀-ay（譬如“banana”会变成“anana-bay”）
public class Ladingzhu {
    public static void main(String[] args){
        System.out.println("please input an english (0 exit):");
        Scanner scanner = new Scanner(System.in);
        ConvertEnglish convertEnglish = new ConvertEnglish();
        while (true) {
            String aaa = scanner.next();
            if(aaa.equals("0")){
                break;
            }
            System.out.println("before convert the string is:" + aaa);
            aaa = convertEnglish.convert(aaa);
            System.out.println("after  convert the string is:" + aaa);
        }
    }
}

class ConvertEnglish{
    public String convert(String str){
        String pre = "";
        String suf = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            boolean isYuanyin = checkYuanyin(ch);
            if (!isYuanyin){
                pre = str.substring(0,i);
                suf = str.substring(i+1,str.length());
                str = pre + suf + "-" + ch + "ay";
                break;
            }
        }
        return str;
    }

    public boolean checkYuanyin(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}