package textOperation;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by pc on 2016/11/14.
 */
public class WenJianCaoZuo {
    public static void main(String[] args){
        FileOperate fileOperate = new FileOperate();
//        fileOperate.createPath("wenjiancaozuo");
//        fileOperate.create("aaa","wenjiancaozuo");
//        fileOperate.delete("aaa");
//        fileOperate.readFile1("test.txt");
//        fileOperate.readFile2("test.txt");
//        fileOperate.writeFile("aaa.txt","2222222222222");
        fileOperate.shuxing("aaa.txt");
    }
}

class FileOperate{

    // 1.创建文件夹
    public void createPath(String fileName){
        File myFolderPath = new File(fileName);
        try{
            if(!myFolderPath.exists()){
                myFolderPath.mkdir();
            }
        }catch (Exception e){
            System.out.println("新建目录操作出错");
            e.printStackTrace();
        }
    }

    // 2.创建文件
    public void create(String fileName, String fileString){
        File myFilePath = new File(fileName);
        try {
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(fileString);
            resultFile.close();
        }
        catch (Exception e) {
            System.out.println("新建文件操作出错");
            e.printStackTrace();
        }
    }

    // 3.删除文件
    public void delete(String fileName){
        File myDelFile = new File(fileName);
        try{
            myDelFile.delete();
        }catch(Exception e){
            System.out.println("删除文件操作失败");
        }
    }

    // 4.删除文件夹下的所有文件
    public void deleteFileAll(String fileName){
        File delFile = new File(fileName);
        File[] files = delFile.listFiles();
        for (int i=0;i<files.length;i++){
            files[i].delete();
        }
    }

    //用流读取文件
    public void readFile1(String fileName) {
        File file = new File(fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String fileString = null;
            while((fileString =bufferedReader.readLine()) != null){
                System.out.println(fileString);
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("fileinputstream failed");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用filereader读取文件
    public void readFile2(String fileName){
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileString = null;
            while((fileString =bufferedReader.readLine()) != null){
                System.out.println(fileString);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //写入文件
    //不追加，如果没有文件就创建文件
    public void writeFile(String fileName, String writeString){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(writeString);
            fileWriter.append("123");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //读取文件属性
    public void shuxing(String fileName){
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println(f.getName() + "的属性如下： 文件长度为：" + f.length());
            System.out.println(f.isFile() ? "是文件" : "不是文件");
            System.out.println(f.isDirectory() ? "是目录" : "不是目录");
            System.out.println(f.canRead() ? "可读取" : "不");
            System.out.println(f.isHidden() ? "是隐藏文件" : "不是隐藏文件");
            System.out.println("文件夹的最后修改日期为：" + new Date(f.lastModified()));
        }else{
            System.out.println("文件不存在");
        }
    }


}

//
////11.写入属性
////import java.io.*;
//        File filereadonly=new File(str1);
//        try {
//        boolean b=filereadonly.setReadOnly();
//        }
//        catch (Exception e) {
//        System.out.println("拒绝写访问："+e.printStackTrace());
//        }
//



////12.枚举一个文件夹中的所有文件
////import java.io.*;
////import java.util.*;
//        LinkedList<String> folderList = new LinkedList<String>();
//        folderList.add(str1);
//        while (folderList.size() > 0) {
//        File file = new File(folderList.peek());
//        folderList.removeLast();
//        File[] files = file.listFiles();
//        ArrayList<File> fileList = new ArrayList<File>();
//        for (int i = 0; i < files.length; i++) {
//        if (files[i].isDirectory()) {
//        folderList.add(files[i].getPath());
//        } else {
//        fileList.add(files[i]);
//        }
//        }
//        for (File f : fileList) {
//        str2=f.getAbsoluteFile();
//        str3
//        }
//        }
//
////13.复制文件夹
////import java.io.*;
////import java.util.*;
//        LinkedList<String> folderList = new LinkedList<String>();
//        folderList.add(str1);
//        LinkedList<String> folderList2 = new LinkedList<String>();
//        folderList2.add(str2+ str1.substring(str1.lastIndexOf("\\")));
//        while (folderList.size() > 0) {
//        (new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
//        File folders = new File(folderList.peek());
//        String[] file = folders.list();
//        File temp = null;
//        try {
//        for (int i = 0; i < file.length; i++) {
//        if (folderList.peek().endsWith(File.separator)) {
//        temp = new File(folderList.peek() + File.separator
//        + file[i]);
//        } else {
//        temp = new File(folderList.peek() + File.separator + file[i]);
//        }
//        if (temp.isFile()) {
//        FileInputStream input = new FileInputStream(temp);
//        FileOutputStream output = new FileOutputStream(
//        folderList2.peek() + File.separator + (temp.getName()).toString());
//        byte[] b = new byte[5120];
//        int len;
//        while ((len = input.read(b)) != -1) {
//        output.write(b, 0, len);
//        }
//        output.flush();
//        output.close();
//        input.close();
//        }
//        if (temp.isDirectory()) {// 如果是子文件夹
//        for (File f : temp.listFiles()) {
//        if (f.isDirectory()) {
//        folderList.add(f.getPath());
//        folderList2.add(folderList2.peek()
//        + File.separator + f.getName());
//        }
//        }
//        }
//        }
//        } catch (Exception e) {
//        //System.out.println("复制整个文件夹内容操作出错");
//        e.printStackTrace();
//        }
//        folderList.removeFirst();
//        folderList2.removeFirst();
//        }
//
////14.复制一个文件夹下所有的文件夹到另一个文件夹下
////import java.io.*;
////import java.util.*;
//        File copyfolders=new File(str1);
//        File[] copyfoldersList=copyfolders.listFiles();
//        for(int k=0;k<copyfoldersList.length;k++){
//        if(copyfoldersList[k].isDirectory()){
//        ArrayList<String>folderList=new ArrayList<String>();
//        folderList.add(copyfoldersList[k].getPath());
//        ArrayList<String>folderList2=new ArrayList<String>();
//        folderList2.add(str2+"/"+copyfoldersList[k].getName());
//        for(int j=0;j<folderList.length;j++){
//        (new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹
//        File folders=new File(folderList.get(j));
//        String[] file=folders.list();
//        File temp=null;
//        try {
//        for (int i = 0; i < file.length; i++) {
//        if(folderList.get(j).endsWith(File.separator)){
//        temp=new File(folderList.get(j)+"/"+file[i]);
//        } else {
//        temp=new File(folderList.get(j)+"/"+File.separator+file[i]);
//        }
//        FileInputStream input = new FileInputStream(temp);
//        if(temp.isFile()){
//        FileInputStream input = new FileInputStream(temp);
//        FileOutputStream output = new FileOutputStream(folderList2.get(j) + "/" + (temp.getName()).toString());
//        byte[] b = new byte[5120];
//        int len;
//        while ( (len = input.read(b)) != -1) {
//        output.write(b, 0, len);
//        }
//        output.flush();
//        output.close();
//        input.close();
//        }
//        if(temp.isDirectory()){//如果是子文件夹
//        folderList.add(folderList.get(j)+"/"+file[i]);
//        folderList2.add(folderList2.get(j)+"/"+file[i]);
//        }
//        }
//        }
//        catch (Exception e) {
//        System.out.println("复制整个文件夹内容操作出错");
//        e.printStackTrace();
//        }
//        }
//        }
//        }
//
////15.移动文件夹
////import java.io.*;
////import java.util.*;
//        LinkedList<String> folderList = new LinkedList<String>();
//        folderList.add(str1);
//        LinkedList<String> folderList2 = new LinkedList<String>();
//        folderList2.add(str2 + str1.substring(str1.lastIndexOf("\\")));
//        while (folderList.size() > 0) {
//        (new File(folderList2.peek())).mkdirs(); // 如果文件夹不存在 则建立新文件夹
//        File folders = new File(folderList.peek());
//        String[] file = folders.list();
//        File temp = null;
//        try {
//        for (int i = 0; i < file.length; i++) {
//        if (folderList.peek().endsWith(File.separator)) {
//        temp = new File(folderList.peek() + File.separator + file[i]);
//        } else {
//        temp = new File(folderList.peek() + File.separator + file[i]);
//        }
//        if (temp.isFile()) {
//        FileInputStream input = new FileInputStream(temp);
//        FileOutputStream output = new FileOutputStream(
//        folderList2.peek() + File.separator + (temp.getName()).toString());
//        byte[] b = new byte[5120];
//        int len;
//        while ((len = input.read(b)) != -1) {
//        output.write(b, 0, len);
//        }
//        output.flush();
//        output.close();
//        input.close();
//        if (!temp.delete())
//        System.out.println("删除单个文件操作出错!");
//        }
//        if (temp.isDirectory()) {// 如果是子文件夹
//        for (File f : temp.listFiles()) {
//        if (f.isDirectory()) {
//        folderList.add(f.getPath());
//        folderList2.add(folderList2.peek() + File.separator + f.getName());
//        }
//        }
//        }
//        }
//        } catch (Exception e) {
//        // System.out.println("复制整个文件夹内容操作出错");
//        e.printStackTrace();
//        }
//        folderList.removeFirst();
//        folderList2.removeFirst();
//        }
//        File f = new File(str1);
//        if (!f.delete()) {
//        for (File file : f.listFiles()) {
//        if (file.list().length == 0) {
//        System.out.println(file.getPath());
//        file.delete();
//        }
//        }
//        }
////16.移动一个文件夹下所有的文件夹到另一个目录下
////import java.io.*;
////import java.util.*;
//        File movefolders=new File(str1);
//        File[] movefoldersList=movefolders.listFiles();
//        for(int k=0;k<movefoldersList.length;k++){
//        if(movefoldersList[k].isDirectory()){
//        ArrayList<String>folderList=new ArrayList<String>();
//        folderList.add(movefoldersList[k].getPath());
//        ArrayList<String>folderList2=new ArrayList<String>();
//        folderList2.add(str2+"/"+movefoldersList[k].getName());
//        for(int j=0;j<folderList.length;j++){
//        (new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹
//        File folders=new File(folderList.get(j));
//        String[] file=folders.list();
//        File temp=null;
//        try {
//        for (int i = 0; i < file.length; i++) {
//        if(folderList.get(j).endsWith(File.separator)){
//        temp=new File(folderList.get(j)+"/"+file[i]);
//        }
//        else{
//        temp=new File(folderList.get(j)+"/"+File.separator+file[i]);
//        }
//        FileInputStream input = new FileInputStream(temp);
//        if(temp.isFile()){
//        FileInputStream input = new FileInputStream(temp);
//        FileOutputStream output = new FileOutputStream(folderList2.get(j) + "/" + (temp.getName()).toString());
//        byte[] b = new byte[5120];
//        int len;
//        while ( (len = input.read(b)) != -1) {
//        output.write(b, 0, len);
//        }
//        output.flush();
//        output.close();
//        input.close();
//        temp.delete();
//        }
//        if(temp.isDirectory()){//如果是子文件夹
//        folderList.add(folderList.get(j)+"/"+file[i]);
//        folderList2.add(folderList2.get(j)+"/"+file[i]);
//        }
//        }
//        }
//        catch (Exception e) {
//        System.out.println("复制整个文件夹内容操作出错");
//        e.printStackTrace();
//        }
//        }
//        movefoldersList[k].delete();
//        }
//        }
//
////17.以一个文件夹的框架在另一个目录创建文件夹和空文件
////import java.io.*;
////import java.util.*;
//        boolean b=false;//不创建空文件
//        ArrayList<String>folderList=new ArrayList<String>();
//        folderList.add(str1);
//        ArrayList<String>folderList2=new ArrayList<String>();
//        folderList2.add(str2);
//        for(int j=0;j<folderList.length;j++){
//        (new File(folderList2.get(j))).mkdirs(); //如果文件夹不存在 则建立新文件夹
//        File folders=new File(folderList.get(j));
//        String[] file=folders.list();
//        File temp=null;
//        try {
//        for (int i = 0; i < file.length; i++) {
//        if(folderList.get(j).endsWith(File.separator)){
//        temp=new File(folderList.get(j)+"/"+file[i]);
//        }
//        else{
//        temp=new File(folderList.get(j)+"/"+File.separator+file[i]);
//        }
//        FileInputStream input = new FileInputStream(temp);
//        if(temp.isFile()){
//        if (b) temp.createNewFile();
//        }
//        if(temp.isDirectory()){//如果是子文件夹
//        folderList.add(folderList.get(j)+"/"+file[i]);
//        folderList2.add(folderList2.get(j)+"/"+file[i]);
//        }
//        }
//        }
//        catch (Exception e) {
//        System.out.println("复制整个文件夹内容操作出错");
//        e.printStackTrace();
//        }
//        }
//
////18.复制文件
////import java.io.*;
//        int bytesum = 0;
//        int byteread = 0;
//        File oldfile = new File(str1);
//        try {
//        if (oldfile.exists()) { //文件存在时
//        FileInputStream inStream = new FileInputStream(oldfile); //读入原文件
//        FileOutputStream fs = new FileOutputStream(new File(str2,oldfile.getName()));
//        byte[] buffer = new byte[5120];
//        int length;
//        while ( (byteread = inStream.read(buffer)) != -1) {
//        bytesum += byteread; //字节数 文件大小
//        System.out.println(bytesum);
//        fs.write(buffer, 0, byteread);
//        }
//        inStream.close();
//        }
//        }
//        catch (Exception e) {
//        System.out.println("复制单个文件操作出错");
//        e.printStackTrace();
//        }
//
////19.复制一个文件夹下所有的文件到另一个目录
////import java.io.*;
//        File copyfiles=new File(str1);
//        File[] files=copyfiles.listFiles();
//        for(int i=0;i<files.length;i++){
//        if(!files[i].isDirectory()){
//        int bytesum = 0;
//        int byteread = 0;
//        try {
//        InputStream inStream = new FileInputStream(files[i]); //读入原文件
//        FileOutputStream fs = new FileOutputStream(new File(str2,files[i].getName());
//        byte[] buffer = new byte[5120];
//        int length;
//        while ( (byteread = inStream.read(buffer)) != -1) {
//        bytesum += byteread; //字节数 文件大小
//        System.out.println(bytesum);
//        fs.write(buffer, 0, byteread);
//        }
//        inStream.close();
//        } catch (Exception e) {
//        System.out.println("复制单个文件操作出错");
//        e.printStackTrace();
//        }
//        }
//        }
//
////20.提取扩展名
//        String str2=str1.substring(str1.lastIndexOf(".")+1);