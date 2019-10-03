package Sendit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextGui
{
    public void SendText()
    {
        JFrame mainFrame = new JFrame("SendIt - Windows Edition 2019");
        ImageIcon img = new ImageIcon(SenditGui.class.getResource("Sendit-icon.png"));
        mainFrame.setIconImage(img.getImage());
        mainFrame.setSize(900,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //PANELS
        JPanel panel = new JPanel();
        panel.setSize(75,75);
        panel.setLayout(new FlowLayout());
        JLabel msgPanel = new JLabel("actions displayed here");

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
                msgPanel.setText("You have chosen: " + itemPicked);
            }
        });
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String itemPicked = e.getActionCommand();
                msgPanel.setText("You have chosen: " + itemPicked);
            }
        });

        // TEXT BOX
        JLabel msgLabel = new JLabel("Enter your message: ");
        JTextField message = new JTextField(20);

        //BUTTONS
        JButton sendIt = new JButton("Send");
        sendIt.setPreferredSize(new Dimension(100,50));
        JButton closeIt = new JButton("Cancel");
        closeIt.setPreferredSize(new Dimension(100,50));

        // BUTTON ACTION LISTENERS
        closeIt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                SenditGui gui = new SenditGui();
                gui.homegGui();
            }
        });
        sendIt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                msgPanel.setText("Your message is: " + message.getText());
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
