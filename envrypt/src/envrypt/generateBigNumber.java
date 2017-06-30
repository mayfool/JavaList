package envrypt;

import java.util.Random;
import java.math.*;
public class generateBigNumber {
  public static void main(String[] args){
	  StringBuffer sb=new StringBuffer();
	  String word="3";
	  BigInteger raw_a=new BigInteger("2");
	  BigInteger b=new BigInteger(word);
	  Random r=new Random();
	  
	  for(int i=0;i<20;i++){
	  sb.append(r.nextInt(10));}
	  System.out.println("a".getBytes());
	  
	  
	  BigInteger a=new BigInteger(sb.toString().getBytes());
	  BigInteger p=new BigInteger("test");
	 
	  BigInteger xa=raw_a.pow(a.intValue());
	  BigInteger key=raw_a.modPow(b, p);
	  
	  
	  System.out.println(a);
	  System.out.println(a.bitLength());
	  
  }
}
