import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.*;
import java.util.*;

class paintSort extends JFrame implements ActionListener{
	JPanel cp =new JPanel();
	JPanel p1=new JPanel();
	int seconds=10;
	int lengthofInput;
	int count;
	String str;
	String id;
	String afterString;
	String inputString;
	String rankMessage;
	int compareValue;
	int i=0;
	
	JTextArea t1=new JTextArea(30,30);
	
	
	JTextArea t2=new JTextArea(30,30);
	
	
	JTextField t3=new JTextField(30);
	
	
	JLabel L1=new JLabel("��һ�������˺ܶ���");
	JLabel L2=new JLabel("�����ʼ��������������а���������ı����֣���ʱһ����");
	
	JButton b1=new JButton("��ʼ");
	JButton b2=new JButton("���а�");
	Server s=new Server();
	Thread timer = new Thread(new Timer());
	//Thread compare=new Thread(new Server());
	private class Timer implements Runnable{
		public void run(){
			String input;
			int again;
			seconds=10;
			int time;
			while(true){
			while(seconds > 0){
				
				try {
					seconds--;
					t3.setText("00 : "+seconds);
					time=10-seconds;
					System.out.println(time);
					lengthofInput=t1.getText().length();
					int speed=60*lengthofInput/time;
					L1.setText("һ��������"+lengthofInput+"��"+"�����ٶ�Ϊ"+speed+"�ɼ�δ�����");
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			id = JOptionPane.showInputDialog(null, "������������֣�������10���ַ�");
			
			seconds=10;
			b1.setEnabled(true);

			b2.setEnabled(true);
			timer.suspend();}
		}
	}
	private class Server {
		public void run(){
	    String newinputString=inputString;
	    
		afterString=StringUtils.repalceBlank(str);
		newinputString=StringUtils.repalceBlank(inputString);
		System.out.println(afterString);
		System.out.println(inputString);
		compareValue=CompareTest.compareWords(afterString, newinputString);
		//compareValue=2;
		}
	}
	public paintSort(){
		super("���ֳ���");
		//timer.start();
		//compare.start();
		
		
		Container c=this.getContentPane();
		t2.setForeground(Color.blue);//��������
		t2.setEditable(false);
		
		t1.setEditable(false);
		p1.setLayout(null);
		t1.setBounds(20, 350,600,200);
		L1.setBounds(20,650,300,30);
		L2.setBounds(150, 270,400 , 30);
		b1.setBounds(20,300,100,30);   //ð������
		b2.setBounds(500,300, 100, 30);//��������
		
		t2.setBounds(20,20,600,250);
		t2.setBackground(Color.white);
		t3.setBounds(250,300,100,30);
		//t3.setBackground(Color.white);
		//L2.setBounds(230,180,100,30);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		p1.add(t1);
		p1.add(L1);
		p1.add(b1);
		p1.add(t2);
		p1.add(b2);
		p1.add(L2);
		
		p1.add(t3);
		p1.add(L2);
		c.add(p1);
		
		
		
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e){
				int i;
				i=JOptionPane.showConfirmDialog(null, "are you sure");
				if(i==JOptionPane.YES_OPTION){
					System.exit(0);//���߻�����д��

				}
			}
		});
		
		this.setLocation(200, 10);
		this.setSize(700, 600);
		setVisible(true);
		JOptionPane.showMessageDialog( this,"�뽫���ַ��ķ���d�̸�Ŀ¼����������ʹ�� \r\nͨ��һ�༾��ΰ�ѧ�ţ�20141334029");
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try{  
			String[] file={"D:/�ټ���1.txt","D:/�ټ���2.txt","D:/ǧ����1.txt","D:/ǧ����2.txt","D:/ǧ����3.txt"};
			
			
			if(e.getSource()==b1){
				timer.resume();
				count++;
				b1.setEnabled(false);
				b2.setEnabled(false);
				seconds=10;			
				i++;int x=(int)(Math.random()*5);
				System.out.println(x);
				
				
				str= fileTest.readFileByChars(file[x]);
				t1.setEditable(true);
				System.out.println(str);
				t2.setText(str);
				
				timer.start();
				
			}
			if(e.getSource()==b2){//���а�
				
			  // s.run();
				//Thread timer = new Thread(new Timer());
				//timer.start();
				timer.suspend();
			   inputString=t1.getText();
			   lengthofInput=inputString.length();
			   s.run();
			   AppendFile.method1("d:/rank.txt","0"+count+"     "+id+"            "+compareValue+"            "+lengthofInput+"\r\n");
			   rankMessage=fileTest.readFileByLines("d:/rank.txt");
			   JOptionPane.showMessageDialog(this,rankMessage);}
			
			
		}
		catch(Exception ex){
			
		}
		
	}


	
	
}
public class client {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//	    Scanner sc = new Scanner(System.in);
/*
		System.out.println("Enter the length of the array");
		int arrayLength = sc.nextInt();
		int[] array = new int[arrayLength];
		System.out.println("Enter the array one by one");
		for (int i = 0; i < arrayLength; i++) {
           array[i]=sc.nextInt();
		}

		for(int i=0;i<arrayLength;i++){
			System.out.println(array[i]);
			
		}
		
		System.out.println("1 for BubbleSort,2 for InsertSort");
		int SortNumber=sc.nextInt();*/
		    File fout = new File("d:/rank.txt");
	        FileOutputStream fos = new FileOutputStream(fout);
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	        bw.write("����  "+"����  "+"��ȷ�ַ���  "+"����ַ���\r\n");
	        bw.close();
		paintSort ps=new paintSort();
	
		
		
	
		
		
		
		
		
		
		
	
	}

}