package 素数;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.net.*;
public class chatclient extends JFrame{
   TextField txf=new TextField();
   TextArea txa=new TextArea();
   DataOutputStream dos=null;
   DataInputStream dis=null;
   Socket s=null;
   Socket nn=null;
   think t=new think();
   int theNumber;
	boolean listen=true;
	public chatclient()//只能接受一次发送接收信息 再次发送时 程序调入bug
	
	{  setLocation(300,400);
	   setSize(300,300);
	   add(txf,BorderLayout.NORTH);
	   add(txa,BorderLayout.SOUTH);
	   txf.addActionListener(new mytfListener());
	   this.addWindowListener(new WindowAdapter()
	   {

		public void windowClosing(WindowEvent e) {
			disconnect();
			System.exit(0);
			
		}}
	   
	   );
	   pack();
	   setVisible(true);
	   connect();
	   
	   
	   new Thread(new listenning()).start();
	}
	
	public void disconnect()
	{
		try {
			if(dos!=null)dos.close();
			s.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	class mytfListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			
		String str=txf.getText().trim();
		//txa.setText(str);
		txf.setText(""); 
		theNumber=Integer.parseInt(str);
		int[] res=t.Decomposition(theNumber);
		txa.setText(txa.getText()+res[1]+"\n");
		System.out.println(theNumber);
		t.Decomposition(theNumber);
		try {
		   
			dos.writeUTF(str);
			dos.flush();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		}
		
	}
	
	public void connect()
	{try {
	    s=new Socket("127.0.0.1",12347);
	    dos=new DataOutputStream(s.getOutputStream());
	    dis=new DataInputStream(s.getInputStream());
	    listen=true;
		System.out.println("connect the server");
		
	
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	
	class listenning implements Runnable{

	
		
	
		public void run(){
			String str;
			try{
			while (listen){
				
					str=dis.readUTF();
System.out.println(str);
					int inputNumber=0;
	//				inputNumber=Integer.parseInt(txf.getText());
					if(str.equals("TRUE")){
						str="输入的数是质数";
					txa.setText(txa.getText()+str+"\n");
					}
					else{
						str="输入的数不是质数";
					txa.setText(txa.getText()+str+"\n");}
				}} 
				catch(EOFException e){
					
				}
				catch (IOException e
						) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					
						try {
							if (dis!=null)dis.close();
							if (dos!=null)dos.close();
							if(s!=null)s.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
					
						}
					
				}
			}
		}
		
		
		
	
	
	public static void main(String[]args)
	{
		new chatclient();
	}
}
