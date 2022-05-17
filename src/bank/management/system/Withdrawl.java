package bank.management.system;

import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
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
        try{        
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()== withdraw){
                
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                }else if (number.matches("[a-zA-Z@^+=_.,;'#$*!&%-]{1,20}")){
                JOptionPane.showMessageDialog(null,"Format is invalid \nAmount must be in Numbers only" ,"Error", JOptionPane.ERROR_MESSAGE);
                }else if (number.matches("[+-]+[0-9]{1,20}")){
                JOptionPane.showMessageDialog(null,"Format is invalid \nAmount must be positive" ,"Error", JOptionPane.ERROR_MESSAGE);
                }
                else{

                    Conn conn = new Conn();
                    
                    ResultSet rs = conn.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if ( rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return ;
                }
                    
                    conn.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
                
                System.out.println(e);
        }
            
    }
    
    public static void main(String args[]) {
        new Withdrawl("").setVisible(true);
    }
}
