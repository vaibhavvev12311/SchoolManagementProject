package com.school;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Marks extends JFrame {
	
	JTextArea t1;
	JPanel p1;
	
	Marks() {}
	Marks(String str){
		setSize(500, 600);
		setLayout(new BorderLayout());
		
		 p1 = new JPanel();

	     t1 = new JTextArea(50,15);
	     JScrollPane jsp = new JScrollPane(t1);
	     t1.setFont(new Font("Senserif",Font.ITALIC,18));
	       
	     add(p1,"North");
	       
	     add(jsp,"Center");
	       
	     setLocation(450,200);
	     mark(str);
	}

	 public void mark(String s){
		    try{
		           conn c = new conn();
		           
		           t1.setText("\tResult of Examination\n\nSubject\n");
		           
		           ResultSet rs1 = c.s.executeQuery("select * from subject where rollno="+s);
		           
		           if(rs1.next()){
		               t1.append("\n\t"+rs1.getString("subject1"));
		               t1.append("\n\t"+rs1.getString("subject2"));
		               t1.append("\n\t"+rs1.getString("subject3"));
		               t1.append("\n\t"+rs1.getString("subject4"));
		               t1.append("\n\t"+rs1.getString("subject5"));
		               t1.append("\n-----------------------------------------");
		               t1.append("\n");
		           }
		           
		           ResultSet rs2 = c.s.executeQuery("select * from marks where rollno="+s);
		           
		           if(rs2.next()){
		        	   int marks1 = Integer.parseInt(rs2.getString("marks1"));
		        	   int marks2 = Integer.parseInt(rs2.getString("marks2"));
		        	   int marks3 = Integer.parseInt(rs2.getString("marks3"));
		        	   int marks4 = Integer.parseInt(rs2.getString("marks4"));
		        	   int marks5 = Integer.parseInt(rs2.getString("marks4"));
		        	   int total = marks1+marks2+marks3+marks4+marks5;
		        	   
		               t1.append("\nMarks\n\n\t"+rs2.getString("marks1"));
		               t1.append("\n\t"+rs2.getString("marks2"));
		               t1.append("\n\t"+rs2.getString("marks3"));
		               t1.append("\n\t"+rs2.getString("marks4"));
		               t1.append("\n\t"+rs2.getString("marks5"));
		               t1.append("\n-----------------------------------------");
		               t1.append("\n");
		               t1.append("\nTotal Marks:         ");
		               t1.append(total+"/500");
		           }
		         
		       }catch(Exception e){
		           e.printStackTrace();
		       }
		   }
		   
		   public static void main(String[] args){
		       new Marks().setVisible(true);
		   }
}
