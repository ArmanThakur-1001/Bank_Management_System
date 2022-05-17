package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField oldpin,pin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel oldpintext = new JLabel("Enter old Pin:");
        oldpintext.setBounds(165,320,180,25);
        oldpintext.setForeground(Color.WHITE);
        oldpintext.setFont(new Font("System",Font.BOLD,16));
        image.add(oldpintext);
        
        oldpin = new JPasswordField();
        oldpin.setFont(new Font("Raleway",Font.BOLD,25));
        oldpin.setBounds(330,320,180,25);
        image.add(oldpin);
        
        JLabel pintext = new JLabel("New Pin:");
        pintext.setBounds(165,360,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,360,180,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setBounds(165,400,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,400,180,25);
        image.add(repin);
        
        
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
                
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==change){
            try{
                String opin = oldpin.getText();
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!opin.equals("1234")){
                    JOptionPane.showMessageDialog(null,"Old Pin does not match");
                    return;
                }        
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered New Pin does not match");
                        return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter New Pin");
                    return;
                }if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter enter Pin");
                    return;
                }
                
                else{
                Conn co = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin ='"+ pinnumber +"'";
                String query2 = "update login set pin = '"+rpin+"' where pin ='"+ pinnumber +"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber ='"+ pinnumber +"'";
                
                co.s.executeUpdate(query1);
                co.s.executeUpdate(query2);
                co.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
                }}catch(Exception e){
                System.out.println(e);
            }
        }else{
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
