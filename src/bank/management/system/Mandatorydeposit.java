package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Mandatorydeposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,exit;
    String pinnumber;
    
    Mandatorydeposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        JLabel limit0 = new JLabel("The Amount should be 1000 Rs");
        limit0.setBounds(170,390,400,30);
        limit0.setForeground(Color.WHITE);
        limit0.setFont(new Font("System",Font.BOLD,20));
        image.add(limit0);
        
                
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
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
           }else if (number.matches("[a-zA-Z@^=_.,;'#$*!&%]{1,20}")){
                JOptionPane.showMessageDialog(null,"Format is invalid \nAmount must be in Numbers only" ,"Error", JOptionPane.ERROR_MESSAGE);
           }else if (number.matches("[+-]+[0-9]{1,20}")){
                JOptionPane.showMessageDialog(null,"Format is invalid \nAmount must be positive" ,"Error", JOptionPane.ERROR_MESSAGE);
           }else if (!number.matches("1000")){
                JOptionPane.showMessageDialog(null,"The Amount should be 1000 Rs only." ,"Error", JOptionPane.ERROR_MESSAGE);
           }else {               
               
               try{
              Conn conn = new Conn();
              String query = "insert into bank values ('"+ pinnumber +"','"+ date +"','Deposit','"+ number+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");
              setVisible(false);
              new Login().setVisible(true);
                }catch (Exception e){
                System.out.println(e);
            }
            }
        }else if(ae.getSource()== exit){  
            String number = amount.getText();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
           }else if (!number.equals(1000)){
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
           }
        else{
            System.exit(0);
            new Login().setVisible(true);
            }
        }
            
    }
    
    public static void main(String args[]) {
        new Mandatorydeposit("").setVisible(true);
    }
}
