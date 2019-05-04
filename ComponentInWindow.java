package 学生管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentInWindow extends JFrame{
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	JPanel jp4=new JPanel();
	JButton button;
	JTextField name,age,StudentNumber,sex,score,text,text1,text2,text3,text4,textinsert,textshuchu;
	JTextArea area;
	JTextArea textShow,textShowxinming;

	Student s = new Student();
	String string;
	String m;
	int searchData;
	int index;
	
	
	 public ComponentInWindow() {
			init();
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	 
	 void  init() {
	  jp1.setBackground(Color.lightGray);
	  jp2.setBackground(Color.lightGray);
	  jp3.setBackground(Color.lightGray);
	  jp4.setBackground(Color.lightGray);
	  
		
	  
	  
	    jp1.add(new JLabel(" "));
		jp1.add(new JLabel(" "));
		textshuchu = new JTextField(10);
		textshuchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textshuchu.getText(); 
		    }
			
		});
		jp1.add(textshuchu);
	  
	    jp1.add(new JLabel("将结果输入"+"\r"));
	    button = new JButton("将结果输入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(textshuchu.getText());
				try {
					FileWriter outOne = new FileWriter(file);
					BufferedWriter outTwo = new BufferedWriter(outOne);
					for(int i=0;i<Begin.a.ar.size();i++) {
						String s = Begin.a.ar.get(i).name+"  "+
					              String.valueOf(Begin.a.ar.get(i).studentnumber)+"  "+
					              String.valueOf(Begin.a.ar.get(i).age)+"  "+
					              Begin.a.ar.get(i).sex+"  "+
					              String.valueOf(Begin.a.ar.get(i).score)+"  ";
						outTwo.write(s);
						outTwo.newLine();
					}
					outTwo.close();
					outOne.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    }
		});
		jp1.add(button);
	    
	    
		jp2.add(new JLabel("姓名："+"\r"));
		name = new JTextField(10);
		name.setMargin(new Insets(4,4,4,4));
		name.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				s.name= name.getText();
			}
		});
		jp2.add(name);
		
		System.out.println();
		jp2.add(new JLabel("\r"+"年龄："));
		age = new JTextField(10);
		age.setMargin(new Insets(4,5,4,4));
		
		age.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.age = Integer.parseInt(age.getText());
		    }
		});
		jp2.add(age);
		
		jp2.add(new JLabel("学号："));
		StudentNumber = new JTextField(10);
		StudentNumber.setMargin(new Insets(4,6,4,4));
		StudentNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    s.studentnumber = Integer.parseInt(StudentNumber.getText());
		    }
		});
		jp2.add(StudentNumber);
		
		jp2.add(new JLabel("性别："));
		sex = new JTextField(10);
		sex.setMargin(new Insets(4,7,4,4));
		sex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.sex = sex.getText();
		    }
		});
		jp2.add(sex);
		
		jp2.add(new JLabel("分数："));
		score = new JTextField(10);
		score.setMargin(new Insets(4,8,4,4));
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.score = Integer.parseInt(score.getText());
		    }
		});
		jp2.add(score);
		
		jp2.add(new JLabel(" "));
		add(new JLabel(" "));
		textinsert = new JTextField(10);
		jp2.add(textinsert);
		
		button = new JButton("插入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.name= name.getText();
				s.age = Integer.parseInt(age.getText());
				s.studentnumber = Integer.parseInt(StudentNumber.getText());
				s.sex = sex.getText();
				s.score = Integer.parseInt(score.getText());
				
				int ac = Integer.parseInt(textinsert.getText());
				if(ac > Begin.a.ar.size()) {
					System.out.println("超出界限");
				}else {
					Begin.a.ar.add(ac, s);
				}
		    }
		});
		jp2.add(button);
		
		//按学号查找
		jp3.add(new JLabel(" "));
		add(new JLabel(" "));
		text1 = new JTextField(10);
		textShowxinming = new JTextArea(9,30);
		jp3.add(textShowxinming);
		
		text1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchData = Integer.parseInt(text1.getText());
				JTextArea ae;
				ae = textShowxinming;
				String result = Begin.a.Binserch(searchData, 0, Begin.a.ar.size());
				ae.append(result);
			}
		});
		jp3.add(text1);
		
		button = new JButton("按学号查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchData = Integer.parseInt(text1.getText());
				JTextArea ae;
				ae = textShowxinming;
				String result = Begin.a.Binserch(searchData, 0, Begin.a.ar.size());
				ae.append(result);
		    }
		});
		jp3.add(button);
		//按姓名查找
		jp3.add(new JLabel(" "));
		add(new JLabel(" "));
		text2 = new JTextField(10);
		text2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea ae;
				ae = textShowxinming;
				string = text2.getText();
				String result = Begin.a.searchname(string,0,Begin.a.ar.size());
				ae.append(result);
		    }
		});
		jp3.add(text2);
		
		button = new JButton("按姓名查找");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea ae;
				ae = textShowxinming;
				string = text2.getText();
				String result = Begin.a.searchname(string,0,Begin.a.ar.size());
				ae.append(result);
		    }
		});
		jp3.add(button);
		
		jp3.add(new JLabel(" "));
		jp3.add(new JLabel(" "));
		text3 = new JTextField(10);
		jp3.add(text3);
		
		button = new JButton("排序");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentArray c = new StudentArray();
				c.Quicksort(0, Begin.a.ar.size());
		    }
		});
		jp3.add(button);
		
		jp3.add(new JLabel(" "));
		jp3.add(new JLabel(" "));
		text4 = new JTextField(10);
		text4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField textInput = text; 
				index = Integer.parseInt(textInput.getText());
				if(index>=360&&index<Begin.a.ar.size()) {
					Begin.a.ar.remove(index);
				}else
				{
					System.out.println("参数越界");
					System.out.println(index);
				}
		    }
			
		});
		button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField textInput = text4; 
				index = Integer.parseInt(textInput.getText());
				if(index>=0&&index<Begin.a.ar.size()) {
					Begin.a.ar.remove(index);
				}else
				{
					System.out.println("参数越界");
					System.out.println(index);
				}
		    }
		});
		
		jp3.add(text4);
		jp3.add(button);
		
		//这个TEXT是干嘛用的？
		jp3.add(new JLabel(" "));
		jp3.add(new JLabel(" "));
		text = new JTextField(10);
		textShow = new JTextArea(9,30);
		jp3.add(textShow);
		jp3.add(text);
		
		button = new JButton("打印");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					JTextArea ae;
					ae = textShow;
					
					/*File file = new File("E:\\Student.txt");
					FileReader inOne = new FileReader(file);
					BufferedReader inTwo = new BufferedReader(inOne);
					*/
					
					for(int i=0;i<Begin.a.ar.size();i++) {
						ae.append(Begin.a.ar.get(i).name+"  "+
					              Begin.a.ar.get(i).studentnumber+"  "+
					              Begin.a.ar.get(i).age+"  "+
					              Begin.a.ar.get(i).sex+"  "+
					              Begin.a.ar.get(i).score+"  "+
					              Begin.a.ar.size()+
								  "\n");
						/*System.out.print(Begin.a.ar.get(i).name+"  ");
						System.out.print(Begin.a.ar.get(i).studentnumber+"  ");
						System.out.print(Begin.a.ar.get(i).age+"  ");
						System.out.print(Begin.a.ar.get(i).sex+"  ");
						System.out.println(Begin.a.ar.get(i).score);*/
					}
					/*while((s=inTwo.readLine()) !=null) {
						ae.append(s+"\n");
					}
					inOne.close();
					inTwo.close();*/
					}
					catch(Exception ee) {
						System.out.println(ee.toString());
					}
				}
		});
		jp3.add(button);
		
		jp4.add(new JLabel("注意事项:"
				+ "请务必在提供文件的时候，文件中的数据排序是以姓名，学号，年龄，性别，成绩排序"
				+ "****************************"));
		jp4.add(new JLabel(" "));
		jp4.add(new JLabel(" "));
		text = new JTextField(10);
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File(text.getText());
					FileReader inOne = new FileReader(file);
					BufferedReader inTwo = new BufferedReader(inOne);
					String s = null;
					Student c = new Student();
					String [] arr = new String[100];
					while((s=inTwo.readLine())!=null) {
							arr = s.split("\\s");	
							c.name = arr[0];
							c.age = Integer.parseInt(arr[1]);
							c.studentnumber = Integer.parseInt(arr[2]);
							c.sex = arr[3];
							c.score = Integer.parseInt(arr[4]);
							Begin.a.ar.add(c);
					}
			    }
				catch(Exception exp) {
					System.out.println(exp);
			    }
			}
		});
		jp4.add(text);
		
		button = new JButton("导入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File(text.getText());
					FileReader inOne = new FileReader(file);
					BufferedReader inTwo = new BufferedReader(inOne);
					String s = null;
					while((s=inTwo.readLine())!=null) {
							String [] arr = s.split("\\p{Blank}");
							Student c = new Student();
							c.name = arr[0];
							c.age = Integer.parseInt(arr[1]);
							c.studentnumber = Integer.parseInt(arr[2]);
							c.sex = arr[3];
							c.score = Integer.parseInt(arr[4]);
							Begin.a.ar.add(c);
					}
					inOne.close();
					inTwo.close();
					//System.out.println(Begin.a.ar.get(0).name);
				}
				catch(Exception exp) {
						System.out.println(exp);
				}
			}
		});
		jp4.add(button);
		
		jp1.setBounds(0,0,715,500);
		jp2.setBounds(715, 0, 715, 500);
		jp3.setBounds(0, 500, 715, 500);
		jp4.setBounds(715, 500, 715, 500);

	  
	  Container container = getContentPane();
	  JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jp1, jp2);
	  JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jp3, jp4);
	  JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, splitPane2);
	     container.add(splitPane,BorderLayout.CENTER);
	     
	     pack();
	     setSize(800,800);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);
	     
	     
	     splitPane1.setDividerLocation(0.3);
	     splitPane2.setDividerLocation(0.5);
	     splitPane.setDividerLocation(0.5);
	 }

}
