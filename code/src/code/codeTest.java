package code;

import java.util.Arrays;

import org.bouncycastle.util.encoders.Hex;



public class codeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		       String a=  fileTest.readFileByChars("D:/sk.txt");
               System.out.println("��ȡ���ı�����"+a);
               AESUtils aes=AESUtils.getInstance();
               byte[] temp=a.getBytes();
               String b=aes.encrypt(temp);
               
               
               System.out.println("string afer encrypt:"+b);
       //       System.out.println("������ԭ"+Arrays.toString(temp));
               byte[] sb=Hex.decode(b);
       //       System.out.println(Arrays.toString(sb)+"sb");
               String c=aes.decrypt(sb);
               System.out.println("��ԭ�������"+c);
	}

}
