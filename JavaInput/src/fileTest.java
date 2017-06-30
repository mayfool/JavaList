

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
public class fileTest {
	  public static String readFileByLines(String fileName) {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        String str="";
	        try {
	            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	            while ((tempString = reader.readLine()) != null) {
	                // ��ʾ�к�
	                System.out.println("line " + line + ": " + tempString);
	                str+=tempString+"\r\n";
	                line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        return str;
	    }

	public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        String str="";
        try {
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            // һ�ζ�һ���ַ�
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            int i=0;
            while ((tempchar = reader.read()) != -1) {
                // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
                // ������������ַ��ֿ���ʾʱ���ỻ�����С�
                // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�
            	i++;
                if (((char) tempchar) != '\n') {
                   // System.out.print((char) tempchar);
                	if(i==100){
                		i=0;
                		str+="\r\n";
                	}
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

public static void main(String[] args) throws IOException{
 /* String str= fileTest.readFileByLines("D:/sk.txt");
  System.out.println(str);
  fileOut.writeFile2();
  AppendFile.method1("d:/out.txt", "\r\n123");
  File f=new File("d:/rank.txt");*/
	String str="liveiv";
	int a=str.lastIndexOf("iv");
	//StringUtils.substring(str, str.lastIndexOf("iv"));
	System.out.println(a);
}}