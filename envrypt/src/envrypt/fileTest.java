package envrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
//import org.apache.commons.lang3.*;
public class fileTest {
	public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        String str="";
        try {
           // System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            // һ�ζ�һ���ַ�
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
                // ������������ַ��ֿ���ʾʱ���ỻ�����С�?
                // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�?
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
 // String str= fileTest.readFileByChars("D:/sk.txt");
 // System.out.println(str);
  String str="abcaqwaer";
  int i=str.lastIndexOf("aer");
 // String result=StringUtils.substringBeforeLast(str, "a");
  System.out.println(i);
}}