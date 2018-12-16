import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * IGNORE THIS CLASS. 
 * THIS IS ME MESSING AROUND AND I DON'T WANT TO DELETE IT YET
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrialPage extends JPanel
{
    private JLabel message, player1, player2, player3;
    private JTextField playerName1, playerName2, playerName3;
    private JButton play;
    
    private JFrame frame;
    private JPanel nextPanel1, nextPanel2;
    private JTabbedPane tp;

    /**
     * Constructor for objects of class PlayWithFriendsPage
     */
    public TrialPage(JFrame frame, JTabbedPane tp, GamePanel gamePanel, AboutPanel aboutPanel)
    {
        //setBackground(Color.cyan);
        this.frame = frame;
        this.nextPanel1 = gamePanel;
        this.nextPanel2 = aboutPanel;
        this.tp = tp;
        setLayout (new GridLayout (3, 1));
        
        add(firstPanel());        
        add(secondPanel());
        add(thirdPanel());
        
    }
    
    private JPanel firstPanel()
    {
        JPanel firstPanel = new JPanel();
        //firstPanel.setBackground(Color.cyan);
        message = new JLabel("Please enter players' names:");
        Font baskerville = new Font ("Baskerville", Font.PLAIN, 24);
        message.setFont(baskerville);
        firstPanel.add(message);
        return firstPanel;
    }
    
    private JPanel secondPanel()
    {
        JPanel secondPanel = new JPanel();
        
        player1 = new JLabel("Player 1: ");
        player2 = new JLabel("Player 2: ");
        player3 = new JLabel("Player 3: ");
        
        playerName1 = new JTextField(10);
        playerName2 = new JTextField(10);
        playerName3 = new JTextField(10);
        
        secondPanel.add(player1);
        secondPanel.add(playerName1);
        secondPanel.add(player2);
        secondPanel.add(playerName2);
        secondPanel.add(player3);
        secondPanel.add(playerName3);
        
        return secondPanel;
    }

    private JPanel thirdPanel()
    {
        JPanel thirdPanel = new JPanel();
        
        play = new JButton("Play!");
        play.addActionListener(new ButtonListener());
        
        thirdPanel.add(play);
        
        return thirdPanel;
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == play){
                //save names in text boxes to...
                //if no name then assume no player
                
                //takes user to GamePanel




                tp.addTab ("Game", nextPanel1);
                tp.addTab("Rules", nextPanel2);
        
                frame.getContentPane().removeAll();
                frame.getContentPane().add(tp);
                frame.pack();
                frame.setVisible(true);
                
            }
        }
    }
}
