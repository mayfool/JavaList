package UIEncrypt;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import code.fileTest;

import java.util.*;

class paintSort extends JFrame implements ActionListener{
	JPanel cp =new JPanel();
	JPanel p1=new JPanel();
	int seconds=60;
	int lengthofInput;
	String str;
	String afterString;
	String inputString;
	int compareValue;
	JTextArea t1=new JTextArea(30,30);
	
	JTextArea t2=new JTextArea(30,30);
	
	
	JTextField t3=new JTextField(30);
	
	
	JLabel L1=new JLabel("����Ҫ��������֣����ּ��ÿո����");
	JLabel L2=new JLabel("�����Ӷ�");
	
	JButton b1=new JButton("��ʼ");
	JButton b2=new JButton("���а�");
	
	
	//Thread compare=new Thread(new Server());

			
		

		
	

	public paintSort(){
		super("���ܳ���");
		//timer.start();
		//compare.start();
		
		
		Container c=this.getContentPane();
		t2.setForeground(Color.blue);//��������
		t2.setEditable(false);
		
		
		p1.setLayout(null);
		t1.setBounds(100, 400,600,250);
		L1.setBounds(100,50,400,30);
		b1.setBounds(100,350,100,30);   //ð������
		b2.setBounds(600,350, 100, 30);//��������
		
		t2.setBounds(100,100,600,250);
		t2.setBackground(Color.white);
		t3.setBounds(300,350,100,30);
		//t3.setBackground(Color.white);
		//L2.setBounds(230,180,100,30);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		p1.add(t1);
		p1.add(L1);
		p1.add(b1);
		p1.add(t2);
		p1.add(b2);
		
		p1.add(t3);
		p1.add(L2);
		c.add(p1);
		
		
		
		
		
		this.setLocation(200, 100);
		this.setSize(1000, 800);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try{
			  str= fileTest.readFileByChars("D:/sk.txt");
			
			if(e.getSource()==b1){
				seconds=60;
				
				
				t2.setText(str);
			}
			if(e.getSource()==b2){
				
			  // s.run();
			   inputString=t1.getText();
			   lengthofInput=inputString.length();
			  
			   JOptionPane.showMessageDialog(this, "������"+inputString.length()+"����ַ���"+compareValue);
			}
			
			
		}
		catch(Exception ex){
			
		}
		
	}


	
	
}
public class paintCode {

}
