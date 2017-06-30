
public class CompareTest {

	public static int compareWords(String a,String b) {
		int t=0;
		int trueCount=0;
		int aL=a.length();
		int bL=b.length();
		int min;
		if(aL>bL)
			min=bL;
		else
			min=aL;
		min--;
		while(min>=0){
			//System.out.println(a.charAt(min));
			//System.out.println(b.charAt(min));
			if(a.charAt(min)==b.charAt(min))
				trueCount++;
			min--;
		}
		//t=a.compareTo(b);
		return trueCount;
		// TODO Auto-generated method stub
      
	}
	public static void main(String[] args){
		  int m=compareWords("ass","adasds");
		  System.out.println(m);
		}
}
