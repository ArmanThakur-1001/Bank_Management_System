package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel limit0 = new JLabel("NOTE:");
        limit0.setBounds(170,390,400,30);
        limit0.setForeground(Color.WHITE);
        limit0.setFont(new Font("System",Font.BOLD,12));
        image.add(limit0);
        
        JLabel limit = new JLabel("The Limit is Above 100 RS");
        limit.setBounds(170,405,400,30);
        limit.setForeground(Color.WHITE);
        limit.setFont(new Font("System",Font.BOLD,12));
        image.add(limit);
                
        JLabel limit2 = new JLabel("The Amount can not exceed 1 Lakh RS");
        limit2.setBounds(170,420,400,30);
        limit2.setForeground(Color.WHITE);
        limit2.setFont(new Font("System",Font.BOLD,12));
        image.add(limit2);
                
        
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){ 
            String number = amount.getText();
            Date date = new Date();
            if ( number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
           }else if (number.matches("[1-9]{1}[0]{6,10}")){
                JOptionPane.showMessageDialog(null,"Deposit limit is above 100 Rs \nLimit can not exceed 1 Lakh Rs" ,"Error", JOptionPane.ERROR_MESSAGE);
           }else if (number.matches("[0-9]{0,1}[0-9]{0,1}")){
                JOptionPane.showMessageDialog(null,"Deposit limit is above 100 Rs \nLimit can not exceed 1 Lakh Rs" ,"Error", JOptionPane.ERROR_MESSAGE);
           }else if (number.matches("[a-zA-Z@^=_.,;'#$*!&%]{1,20}")){
                JOptionPane.showMessageDialog(null,"Format is invalid \nAmount must be in Numbers only" ,"Error", JOptionPane.ERROR_MESSAGE);
           }else if (number.matches("[+-]+[0-9]{1,20}")){
                JOptionPane.showMessageDialog(null,"Format is invalid \nAmount must be positive" ,"Error", JOptionPane.ERROR_MESSAGE);
                }else {               
               
               try{
              Conn conn = new Conn();
              String query = "insert into bank values ('"+ pinnumber +"','"+ date +"','Deposit','"+ number+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                System.out.println(e);
            }
            }
        }else if(ae.getSource()== back){ 
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Deposit("").setVisible(true);
    }
}
