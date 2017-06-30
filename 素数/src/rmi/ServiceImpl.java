package rmi;

import java.rmi.RemoteException; 
//UnicastRemoteObject用于导出的远程对象和获得与该远程对象通信的存根。 
import java.rmi.server.UnicastRemoteObject; 

public class ServiceImpl extends UnicastRemoteObject implements IService { 

private String name; 
think t=new think();
public ServiceImpl(String name) throws RemoteException { 
  this.name = name; 
} 
@Override 
public String service(String content) { 
	int a=Integer.parseInt(content);
	t.Decomposition(a);
	return "server >> " + content; 
} 
}