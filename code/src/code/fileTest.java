package code;

import java.io.*;
import java.io.File;
import java.io.Reader;
import java.util.Arrays;

public class fileTest {
	public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        String str="";
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\n') {
                   // System.out.print((char) tempchar);
                    str+=(char)tempchar;
                }
            }
            
            //System.out.println("str"+str);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;    
	}

public static void main(String[] args){
  String str= fileTest.readFileByChars("D:/sk.txt");
  System.out.println(str);
}}