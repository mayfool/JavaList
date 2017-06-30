package rmi;






public class think {
    public  think(){}
	
	public static void main(String[] args){
		int[]a=Decomposition(8);
		System.out.println(a[1]);
	}
	
	public static  int[] Decomposition(int a ){
		int flag=0;
		int i=2;
		for(i=2;i<a/2;i++){
			if(isPrime(i)&&isPrime(a-i)){
				flag=1;
				break;
			}
		}
		int[] m=new int[3];
		m[0]=flag;
		m[1]=i;
		m[2]=a-i;
		return m;
	}
	
	
public static boolean isPrime(int a) {  
	  
    boolean flag=true;

    if (a < 2) {// 素数不小于2  
        return true;  
    } else {  

        for (int i = 2; i <= Math.sqrt(a); i++) {  

            if (a % i == 0) {// 若能被整除，则说明不是素数，返回false  

                flag=false;  
                break;// 跳出循环  
            }  
        }  
    }  
    return flag;  
} 
}