package code;

import java.security.*;

public class Check {

public static void main(String[] args) {

System.out.println("-------�г����ܷ����ṩ��-----");

Provider[] pro=Security.getProviders();

for(Provider p:pro){

System.out.println("Provider:"+p.getName()+" - version:"+p.getVersion());

System.out.println(p.getInfo());

}

System.out.println("");

System.out.println("-------�г�ϵͳ֧�ֵ���ϢժҪ�㷨��");

for(String s:Security.getAlgorithms("MessageDigest")){

System.out.println(s);

}

System.out.println("-------�г�ϵͳ֧�ֵ����ɹ�Կ��˽Կ�Ե��㷨��");

for(String s:Security.getAlgorithms("KeyPairGenerator")){

System.out.println(s);

}

}

}