package calculator;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Mycalcultor extends JFrame{
	JTextField text;   //创建一个文本组件，文本框
	JButton but[]=new JButton[16];  //创建一个JButton数组
//构造函数，建立窗口，建立面板，建立按钮
	public Mycalcultor(){
		this.setBounds(300,200,400,300);  //窗体大小
		this.setTitle("计算器");   //窗体名称 
		this.setLocation(300,200);   //设置窗体显示位置
		this.setLayout(new BorderLayout());   //设置窗体中的布局管理器为BorderLayout
		text=new JTextField(15);   //创建一个15列的文本框
		JPanel panel=new JPanel();    //定义一个JPanel面板
		panel.setLayout(new GridLayout(4,4));   //设置面板panel的布局管理器为BorderLayout，并设置成行数和列数都为4行
		String[] num={"7","8","9","÷","4","5","6","×","1","2","3","+",".","0","=","-"};   //创建一个数组，记录按钮的名称
		for(int i=0;i<16;i++){      
			but[i]=new JButton(num[i]);    //创建新的按钮
			panel.add(but[i]);       //设置按钮的所在区域为panel面板，将按钮放在面板上
		}
		this.add(text,BorderLayout.NORTH);    //将文本框放入窗体，并将区域放在北边
		this.add(panel);    //将面板放在窗体的其他位置
		CounterEvent();     //调用CounterEvent（）函数
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置点击关闭按钮时的默认操作
		this.setVisible(true);   //窗口可视化
	}
	public void CounterEvent(){
		for(int i=0;i<16 && i!=14;i++){   
			Text(but[i]);
		}
	    //给“=”按钮设置动作事件监听器
	    but[14].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.setText(text.getText()+but[14].getText());   //将字符加上=，给文本框
				if(text.getText().contains("+")){              //判断是否做加法运算
					StringTokenizer st1=new StringTokenizer(text.getText(),"+");    //text.getText()为需分析的字符串，+为定界符
				    double d1,d2=0;
				    d1=Double.parseDouble(st1.nextToken());     //st1.nextToken()为截取的字符
				    while(st1.hasMoreTokens()){      //判断是否还有下一个token
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");   //st1.getText()为需分析的字符串，=为定界符
						d2=Double.parseDouble(st2.nextToken());      //截取加号之后的字符
				    }
					text.setText(text.getText()+" "+(d1+d2));   //输入到文本框
			    }else if(text.getText().contains("-")){    //一下功能与+运算功能类似不重复定义
					StringTokenizer st1=new StringTokenizer(text.getText(),"-");
					double d1,d2=0;
					d1=Double.parseDouble(st1.nextToken());
					while(st1.hasMoreTokens()){
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
						d2=Double.parseDouble(st2.nextToken());
					}
				    text.setText(text.getText()+" "+(d1-d2));
			    }else if(text.getText().contains("×")){
					StringTokenizer st1=new StringTokenizer(text.getText(),"×");
				    double d1,d2=0;
				    d1=Double.parseDouble(st1.nextToken());
				    while(st1.hasMoreTokens()){
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
					    d2=Double.parseDouble(st2.nextToken());
					}
				    text.setText(text.getText()+" "+(d1*d2));
				}else if(text.getText().contains("÷")){
					StringTokenizer st1=new StringTokenizer(text.getText(),"÷");
					double d1,d2=0;
					d1=Double.parseDouble(st1.nextToken());
					while(st1.hasMoreTokens()){
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
						d2=Double.parseDouble(st2.nextToken());
				    }
				    text.setText(text.getText()+" "+(d1/d2));
				}
			}
		});
	}

	//为按钮添加动作事件监听器
   public void Text(JButton button){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str=button.getText();   //获取按钮的字符
				text.setText(text.getText()+str);   //将文本框和获取的字符给文本框
			}
		});
	}


	public static void main(String[] args){
		new Mycalcultor();
	}
}

