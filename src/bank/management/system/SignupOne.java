package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JRadioButton male,female,other,married,single;
    JButton next;
    JDateChooser dateChooser;
    JLabel formno;
    
    SignupOne(){
        this.formno = formno;
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(20,5,100,100);
        add(label);
        
        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name = new JLabel("Name:*");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:*");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:*");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender:*");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
                
        
        JLabel email = new JLabel("Email Address:*");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel martial = new JLabel("Marital Status:*");
        martial.setFont(new Font("Raleway",Font.BOLD,20));
        martial.setBounds(100,390,200,30);
        add(martial);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        single = new JRadioButton("Single");
        single.setBounds(450,390,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(single);
        maritalgroup.add(other);
        
        
        JLabel address = new JLabel("Address:*");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:*");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:*");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pin Code:*");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        

           
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
     
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";                  
        }else if (female.isSelected()){
            gender = "Female";  
        }
        String email = emailTextField.getText();


        
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if (single.isSelected()){
            marital = "Single";        
        }else if ( other.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");                
            }else if (!(name.matches("[a-zA-Z\\s]{5,20}"))){
                JOptionPane.showMessageDialog(null, "Only Letters are allowed to be entered in the Name field", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required");                
            }else if (!(fname.matches("[a-zA-Z\\s]{5,20}"))){
                JOptionPane.showMessageDialog(null, "Only Letters are allowed to be entered in the  Father's name field", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");                
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");                
            }else if (!(email.matches("^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$"))){
                            JOptionPane.showMessageDialog(null, "Please enter a valid email \nExample: Yourname@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");                
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is Required");                
            }else if (!(pin.matches("\\d{6}"))){
                            JOptionPane.showMessageDialog(null, "Please enter a valid 6 Digit Pin Code", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State Field is Required");                
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+ formno +"','"+ name +"','"+ fname +"','"+ dob +"','"+ gender +"','"+ email +"','"+ marital +"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        

        
        

    }
    public static void main(String[] args){
        new SignupOne().setVisible(true);
    }
}

