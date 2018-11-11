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
	JTextField text;   //����һ���ı�������ı���
	JButton but[]=new JButton[16];  //����һ��JButton����
//���캯�����������ڣ�������壬������ť
	public Mycalcultor(){
		this.setBounds(300,200,400,300);  //�����С
		this.setTitle("������");   //�������� 
		this.setLocation(300,200);   //���ô�����ʾλ��
		this.setLayout(new BorderLayout());   //���ô����еĲ��ֹ�����ΪBorderLayout
		text=new JTextField(15);   //����һ��15�е��ı���
		JPanel panel=new JPanel();    //����һ��JPanel���
		panel.setLayout(new GridLayout(4,4));   //�������panel�Ĳ��ֹ�����ΪBorderLayout�������ó�������������Ϊ4��
		String[] num={"7","8","9","��","4","5","6","��","1","2","3","+",".","0","=","-"};   //����һ�����飬��¼��ť������
		for(int i=0;i<16;i++){      
			but[i]=new JButton(num[i]);    //�����µİ�ť
			panel.add(but[i]);       //���ð�ť����������Ϊpanel��壬����ť���������
		}
		this.add(text,BorderLayout.NORTH);    //���ı�����봰�壬����������ڱ���
		this.add(panel);    //�������ڴ��������λ��
		CounterEvent();     //����CounterEvent��������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //���õ���رհ�ťʱ��Ĭ�ϲ���
		this.setVisible(true);   //���ڿ��ӻ�
	}
	public void CounterEvent(){
		for(int i=0;i<16 && i!=14;i++){   
			Text(but[i]);
		}
	    //����=����ť���ö����¼�������
	    but[14].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.setText(text.getText()+but[14].getText());   //���ַ�����=�����ı���
				if(text.getText().contains("+")){              //�ж��Ƿ����ӷ�����
					StringTokenizer st1=new StringTokenizer(text.getText(),"+");    //text.getText()Ϊ��������ַ�����+Ϊ�����
				    double d1,d2=0;
				    d1=Double.parseDouble(st1.nextToken());     //st1.nextToken()Ϊ��ȡ���ַ�
				    while(st1.hasMoreTokens()){      //�ж��Ƿ�����һ��token
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");   //st1.getText()Ϊ��������ַ�����=Ϊ�����
						d2=Double.parseDouble(st2.nextToken());      //��ȡ�Ӻ�֮����ַ�
				    }
					text.setText(text.getText()+" "+(d1+d2));   //���뵽�ı���
			    }else if(text.getText().contains("-")){    //һ�¹�����+���㹦�����Ʋ��ظ�����
					StringTokenizer st1=new StringTokenizer(text.getText(),"-");
					double d1,d2=0;
					d1=Double.parseDouble(st1.nextToken());
					while(st1.hasMoreTokens()){
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
						d2=Double.parseDouble(st2.nextToken());
					}
				    text.setText(text.getText()+" "+(d1-d2));
			    }else if(text.getText().contains("��")){
					StringTokenizer st1=new StringTokenizer(text.getText(),"��");
				    double d1,d2=0;
				    d1=Double.parseDouble(st1.nextToken());
				    while(st1.hasMoreTokens()){
						StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
					    d2=Double.parseDouble(st2.nextToken());
					}
				    text.setText(text.getText()+" "+(d1*d2));
				}else if(text.getText().contains("��")){
					StringTokenizer st1=new StringTokenizer(text.getText(),"��");
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

	//Ϊ��ť��Ӷ����¼�������
   public void Text(JButton button){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str=button.getText();   //��ȡ��ť���ַ�
				text.setText(text.getText()+str);   //���ı���ͻ�ȡ���ַ����ı���
			}
		});
	}


	public static void main(String[] args){
		new Mycalcultor();
	}
}

