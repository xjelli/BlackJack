import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * First window that the user will open. It will offer two options: playing with
 * your friends or playing with computers. The user will indicate their selection 
 * by clicking the corresponding button
 *
 * @author Maya Igarashi
 * @version v.1
 */
public class WelcomePage extends JPanel
{
    // instance variables 
    private JLabel title, message, friendLabel, cpuLabel;
    private JButton friendButton, cpuButton;
    private JFrame frame;
    private JPanel friendsNextPanel, cpuNextPanel;
    
    /**
     * Constructor for WelcomePage
     * Uses a grid layout
     * @param JFrame, PlayWithFriendsPage, PlayWithComputerPage
     */
    public WelcomePage(JFrame frame, PlayWithFriendsPage friendsPanel, PlayWithComputerPage cpuPanel)
    {
        //initializing
        this.frame = frame;
        this.friendsNextPanel = friendsPanel;
        this.cpuNextPanel = cpuPanel;

        //setup layout. Extra: add colors if desired
        setLayout (new GridLayout (3, 1));
        
        //Add panels to the frame
        add(titlePanel());
        add(firstPanel());        
        add(secondPanel());
    }
    
    /**
     * titlePanel provides the title "Blackjack" in fancy font
     * @return titlePanel
     */
    private JPanel titlePanel()
    {
        JPanel titlePanel = new JPanel();
        
        title = new JLabel("Blackjack");
        Font baskerville = new Font ("Baskerville", Font.PLAIN, 48);
        title.setFont (baskerville);

        titlePanel.add(title);
        
        return titlePanel;
    }
    
    /**
     * firstPanel provides a welcome message
     * @return firstPanel
     */
    private JPanel firstPanel()
    {
        JPanel firstPanel = new JPanel();
        //firstPanel.setBackground(Color.cyan);
        message = new JLabel("Welcome! Do you want to play with friends or computers?");
        Font baskerville = new Font ("Baskerville", Font.PLAIN, 24);
        message.setFont(baskerville);
        firstPanel.add(message);
        return firstPanel;
    }
    
    /**
     * secondPanel provides the two buttons to choose between playing with friends or computers
     * @return secondPanel
     */
    private JPanel secondPanel()
    {
        JPanel secondPanel = new JPanel();
        
        friendButton = new JButton("Play with Friends!");
        cpuButton = new JButton("Play with Computers!");
        
        ButtonListener listener = new ButtonListener();
        friendButton.addActionListener(listener);
        cpuButton.addActionListener(listener);
        
        secondPanel.add(friendButton);
        secondPanel.add(cpuButton);
        
        return secondPanel;
    }


    /**
     * ButtonListener to listen and respond to action
     */
    private class ButtonListener implements ActionListener{
        /**
         * actionPerformed will take the user to either PlayWithFriendsPage
         * or PlayWithComputerPage based on the button they pressed
         */
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == friendButton){
                //takes user to PlayWithFriendsPage
                frame.getContentPane().removeAll();
                frame.getContentPane().add(friendsNextPanel);
                frame.pack();
                frame.setVisible(true);
            }
            if(event.getSource() == cpuButton){
                //takes user to PlayWithComputerPage
                frame.getContentPane().removeAll();
                frame.getContentPane().add(cpuNextPanel);
                frame.pack();
                frame.setVisible(true);
            }
        }
    }
}
