package 素数;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class chatserver {

	/**
	 * @param args
	 */
	boolean connectedout = false;
	ServerSocket ss = null;
    List<Client> clients=new ArrayList<Client>();
    think t=new think();
	public static void main(String[] args) {
		new chatserver().start();

	}

	public void start() {
	
		try {
			ss = new ServerSocket(12347);// 建立 服务器端

			connectedout = true;
		}

		catch (BindException e) {
			System.out.println("端口使用中");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {

			while (connectedout) {
				Socket s = ss.accept();
				System.out.println("已经连接");
				Client c = new Client(s);
				new Thread(c).start();
				clients.add(c);

			}

		} catch (IOException e) {

			// e.printStackTrace();
		} finally {
			try {

				ss.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

	}

	class Client implements Runnable {
		Socket s = null;
		DataInputStream dis = null;
		DataOutputStream dos =null;
		boolean connectedin = false;

		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				connectedin = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		public void send(String str){
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void run() {
	
			try {

				while (connectedin) {
					String str;

					str = dis.readUTF();
					String msg;
					int theNumber=Integer.parseInt(str);
System.out.println(str);
                    boolean value=t.isPrime(theNumber);
                    if(value){
                    	msg="TRUE";
                    }
                    else{
                    	msg="False";
                    }
                   for(int i=0;i<clients.size();i++)                   
                    {Client c=clients.get(i);
                     c.send(msg);
                    } 
					while (str.equals("byebye"))
						connectedin = false;

				}
				dis.close();
				s.close();
			}
			catch (EOFException e) {
				   System.out.println("a client closed");
							}
			catch (IOException e) {

			}

		 finally {

				try {
				if(dos!=null)	dos.close();
				if(dis!=null)	dis.close();
				if(s!=null)	s.close();
					System.out.println("输出流关闭");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
