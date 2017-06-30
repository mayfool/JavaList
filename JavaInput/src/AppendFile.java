import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author malik
 * @version 2011-3-10 ����10:49:41
 */
public class AppendFile {
	
	public static void method1(String file, String conent) {   
        BufferedWriter out = null;   
        try {   
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));   
            out.write(conent);   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            try {   
            	if(out != null){
            		out.close();   
                }
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        }   
    }   
  
    /**  
     * ׷���ļ���ʹ��FileWriter  
     *   
     * @param fileName  
     * @param content  
     */  
    public static void method2(String fileName, String content) { 
    	FileWriter writer = null;
        try {   
            // ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�   
            writer = new FileWriter(fileName, true);   
            writer.write(content);     
        } catch (IOException e) {   
            e.printStackTrace();   
        } finally {   
            try {   
            	if(writer != null){
            		writer.close();   
            	}
            } catch (IOException e) {   
                e.printStackTrace();   
            }   
        } 
    }   
  
    /**  
     * ׷���ļ���ʹ��RandomAccessFile  
     *   
     * @param fileName �ļ���  
     * @param content ׷�ӵ�����  
     */  
    public static void method3(String fileName, String content) { 
    	RandomAccessFile randomFile = null;
        try {   
            // ��һ����������ļ���������д��ʽ   
            randomFile = new RandomAccessFile(fileName, "rw");   
            // �ļ����ȣ��ֽ���   
            long fileLength = randomFile.length();   
            // ��д�ļ�ָ���Ƶ��ļ�β��   
            randomFile.seek(fileLength);   
            randomFile.writeBytes(content);    
        } catch (IOException e) {   
            e.printStackTrace();   
        } finally{
        	if(randomFile != null){
        		try {
					randomFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
    }  

	public static void main(String[] args) {
		try{
			File file = new File("d://text.txt");
			if(file.createNewFile()){
				System.out.println("Create file successed");
			}
			method1("d://out.txt", "123");
			method2("d://text.txt", "123");
			method3("d://text.txt", "123");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
