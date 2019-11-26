// Login Window
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow {
  public LoginWindow(){
    makeLogin();
  }
  public void makeLogin(){
    JFrame mainWindow = new JFrame("Welcome");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(600,400);

    JLabel logPanel = new JLabel("Login");
    logPanel.setBounds(100,30,300,30);
    JLabel u = new JLabel("Username:");
    u.setBounds(80,70,200,30);
    JLabel p = new JLabel("Password:");
    p.setBounds(80,110,200,30);
    JTextField user = new JTextField();
    user.setBounds(300,70,200,30);
    JPasswordField pass = new JPasswordField();
    pass.setBounds(300,110,200,30);
    JButton login = new JButton("Login");
    login.setBounds(150,160,100,30);
    JCheckBox showPassword = new JCheckBox("Show Password");
    JButton close = new JButton("Close");
    close.setBounds(300,160,100,30);
    JButton account = new JButton("Sign-Up");
    account.setBounds(220,200,100,30);

    login.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String username = user.getText();
        String password = pass.getText();
        if (username.equals("wow") && password.equals("omg")){
          logPanel.setText("Login - Welcome to sendIt.");

        }
        else {
          logPanel.setText("Login - Wrong user/password combo");
        }
      }
    });
    close.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });
    account.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        accountGUI one = new accountGUI();
        mainWindow.setVisible(false);
      }
    });

    mainWindow.add(logPanel);
    mainWindow.add(u);
    mainWindow.add(user);
    mainWindow.add(p);
    mainWindow.add(pass);
    mainWindow.add(login);
    mainWindow.add(close);
    mainWindow.add(account);

    mainWindow.setLayout(null);
    mainWindow.setVisible(true);
  }
  public static void main(String[] args){
    LoginWindow x = new LoginWindow();
  }
}
