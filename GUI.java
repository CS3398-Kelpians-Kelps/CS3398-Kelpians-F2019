import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    public GUI() {
      makeGUI();
    }

    public static void main(String[] args){
      GUI clientGUI = new GUI();
    }

    public void makeGUI(){
      // MAIN WINDOW
      JFrame mainFrame = new JFrame("sendIt");
      mainFrame.setSize(700,400);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //PANELS
      JPanel panel = new JPanel();
      panel.setSize(75,75);
      panel.setLayout(new FlowLayout());
      JLabel msgPanel = new JLabel("Your actions are displayed here.");

      // MENU BAR
      JMenuBar bar = new JMenuBar();
      JMenu menu1 = new JMenu("File");
      JMenu menu2 = new JMenu("Help");
      bar.add(menu1);
      bar.add(menu2);
      JMenuItem item1 = new JMenuItem("Open");
      JMenuItem item2 = new JMenuItem("About sendIt");
      menu1.add(item1);
      menu2.add(item2);

      // MENU BAR ACTION LISTENERS
      item1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          String itemPicked = e.getActionCommand();
          msgPanel.setText("You want to open a file.");
        }
      });
      item2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          String itemPicked = e.getActionCommand();
          msgPanel.setText("You want to learn more about sendIt.");
        }
      });

      // TEXT BOX
      JLabel msgLabel = new JLabel("Enter your message:");
      JTextField message = new JTextField(20);

      //BUTTONS
      JButton sendIt = new JButton("Send");
      sendIt.setPreferredSize(new Dimension(100,50));
      JButton closeIt = new JButton("Close");
      closeIt.setPreferredSize(new Dimension(100,50));

      // BUTTON ACTION LISTENERS
      closeIt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          System.exit(0);
        }
      });
      sendIt.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          msgPanel.setText("Your message to send is: " + message.getText());
        }
      });

      panel.add(msgLabel);
      panel.add(message);
      panel.add(sendIt);
      panel.add(closeIt);
      panel.add(msgPanel);

      mainFrame.add(bar, BorderLayout.NORTH);
      mainFrame.add(panel);
      mainFrame.setVisible(true);

    }

}
