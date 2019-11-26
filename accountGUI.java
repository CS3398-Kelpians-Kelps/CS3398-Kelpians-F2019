// make an account

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class accountGUI {
  public accountGUI(){
    createGUI();
  }
  public static void main(String[] args){
    accountGUI g1 = new accountGUI();
  }
  public void createGUI(){
    JFrame mainF = new JFrame("Account Sign-Up");
    mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainF.setSize(600,400);

    JLabel account = new JLabel("Create an Account with sendIt:");
    account.setBounds(100,30,300,30);

    JLabel name1 = new JLabel("First Name:");
    name1.setBounds(80,70,200,30);
    JLabel name2 = new JLabel("Last Name:");
    name2.setBounds(80,110,200,30);
    JLabel newUsername = new JLabel("Username:");
    newUsername.setBounds(80,150,200,30);
    JLabel newPass = new JLabel("Password:");
    newPass.setBounds(80,190,200,30);

    JTextField firstname = new JTextField();
    firstname.setBounds(300,70,200,30);
    JTextField lastname = new JTextField();
    lastname.setBounds(300,110,200,30);
    JTextField username = new JTextField();
    username.setBounds(300,150,200,30);
    JPasswordField password = new JPasswordField();
    password.setBounds(300,190,200,30);

    JPanel buttons = new JPanel();
    buttons.setBounds(80,230,400,40);
    JButton create = new JButton("Create Account");
    JButton close = new JButton("Close");
    JPanel random = new JPanel();//don't delete this it might put the buttons at the very top
    random.setBounds(0,0,0,0);//I don't know why it does that blame Java

    close.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });

    create.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });

    mainF.add(name1);
    mainF.add(name2);
    mainF.add(newUsername);
    mainF.add(newPass);
    mainF.add(firstname);
    mainF.add(lastname);
    mainF.add(username);
    mainF.add(password);
    mainF.add(account);
    mainF.add(buttons);
    buttons.add(create);
    buttons.add(close);
    mainF.add(random);

    mainF.setVisible(true);
    mainF.setLayout(null);
  }
}
