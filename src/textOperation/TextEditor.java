package textOperation;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;


/**
 * Created by pc on 2016/11/10.
 */
//文本编辑器——记事本类型的应用，可以打开、编辑、保存文本文档
//有bug。。。
public class TextEditor {
    public static void main(String[] args){
        Init init = new Init();
    }
}

class Init{
    public JFrame frame;
    public JPanel panel;
    public JTextArea textArea;
    public JMenu menu1;
    public JMenu menu2;
    public JMenu menu3;
    String fileName = "";
    public  Init(){
        frame = new JFrame("记事本");
        panel = new JPanel();
        JMenuBar menuBar =new JMenuBar();

        menu1 = new JMenu("打开");
        menu2 = new JMenu("新建");
        menu3 = new JMenu("保存");

        menu1.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                if (e.getSource() == menu1) {
                        openFile();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        menu3.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                savefile();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        textArea = new JTextArea();

        panel.setLayout(new GridLayout());
        textArea.setText("文本编辑器");
        ////当TextArea里的内容过长时生成滚动条
        panel.add(new JScrollPane(textArea));
        frame.add(panel);
        frame.add(menuBar,BorderLayout.NORTH);


        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public void openFile(){
        String fileName = null;
        FileDialog df = new FileDialog(frame,"打开文件",FileDialog.LOAD);
        df.setVisible(true);
        //建立新文件
        File f = new File( df.getDirectory()+df.getFile() );
        //得到文件名
        fileName = df.getDirectory()+df.getFile();
        //用此文件的长度建立一个字符数组  （特别标注）
        char ch[] = new char [(int)f.length()];
        //异常处理
        try
        {
            //读出数据，并存入字符数组ch中
            BufferedReader bw = new BufferedReader( new FileReader(f) );
            bw.read(ch);
            bw.close();
        }
        catch( FileNotFoundException fe ){
            System.out.println("file not found");
            System.exit(0);
        }
        catch( IOException ie){
            System.out.println("IO error");
            System.exit(0);
        }
        String s =new String (ch);
        textArea.setText(s);
    }

    //保存
    public void savefile(){
        if( fileName.equals("") ){
            FileDialog df = new FileDialog(frame,"保存文件",FileDialog.SAVE);
            df.addWindowListener( new WindowAdapter(){
                public void windowClosing(WindowEvent ee){
                    System.exit(0);
                }
            });
            df.setVisible(true);
            String s = textArea.getText();
            try
            {
                File f = new File( df.getDirectory()+df.getFile());
                fileName = df.getDirectory()+df.getFile();
                BufferedWriter bw = new BufferedWriter( new FileWriter (f));
                bw.write(s , 0 , s.length());
                bw.close();
            }
            catch(FileNotFoundException fe_){
                System.out.println("file not found");
                System.exit(0);
            }
            catch( IOException ie_)
            {
                System.out.println(" IO error");
                System.exit(0);
            }
        }
    }


}


