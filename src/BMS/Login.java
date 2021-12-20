package BMS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf;
	JButton b1,b2,b3;
	
	Login()
	{
		super("AUTOMATED TELLER MACHINE");
		
		
		l1=new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Osward",Font.BOLD,38));
		
		
		l2=new JLabel("Card No:");
		l2.setFont(new Font("Raleway",Font.BOLD,28));
		
		l3=new JLabel("PIN:");
		l3.setFont(new Font("Raleway",Font.BOLD,28));
		
		tf1 = new JTextField(15);
		pf = new JPasswordField(15);
		
		b1 = new JButton("SIGN IN");
        
        b2 = new JButton("CLEAR");
       
        
        b3 = new JButton("SIGN UP");
       
		
		
		setLayout(null);
		
		l1.setBounds(175,50,450,200);
		add(l1);
		
		l2.setBounds(125,150,375,200);
		add(l2);
		
		l3.setBounds(125,225,375,200);
		add(l3);
		
		tf1.setFont(new Font("Arial", Font.BOLD,14));
		tf1.setBounds(300,235,230,30);
		add(tf1);
		
		pf.setFont(new Font("Arial", Font.BOLD,14));
		pf.setBounds(300,310,230,30);
		add(pf);
		
		b1.setFont(new Font("Arial",Font.BOLD,14));
		b1.setBounds(300,400,100,30);
		add(b1);
		
		b2.setFont(new Font("Arial",Font.BOLD,14));
		b2.setBounds(430,400,100,30);
		add(b2);
		
		b3.setFont(new Font("Arial",Font.BOLD,14));
		b3.setBounds(300,450,230,30);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(750,750);
		setLocation(500,200);
		setVisible(true);
		
	}
		
	public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String cardno  = tf1.getText();
                String pin  = String.valueOf(pf.getPassword());
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	
	
	public static void main(String[] args)
	{
		Login l=new Login();
		l.setVisible(true);
	}
	
}
