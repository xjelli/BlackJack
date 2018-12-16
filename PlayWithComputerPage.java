import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class PlayWithComputerPage here.
 *
 *
 * To Do: Save input name and number of CPU players to use in GamePanel. 
 * Extra: Use player 1 as a default if the textfield is left blank?
 * 
 * 
 * @author Maya Igarashi
 * @version v.1
 */
public class PlayWithComputerPage extends JPanel
{
    //instance variables
    private JLabel message, player1, cpu;
    private JTextField playerName1;
    private JButton play;
    
    private JFrame frame;
    private JPanel nextPanel1, nextPanel2;
    private JTabbedPane tp;
    private LinkedList<Player> players;
    
    /**
     * Constructor for objects of class PlayWithComputerPage
     * @param JFrame, JTabbedPane, GamePanel, AboutPanel, LinkedList<Player>
     */
    public PlayWithComputerPage(JFrame frame, JTabbedPane tp, GamePanel gamePanel, AboutPanel aboutPanel, LinkedList<Player> players)
    {
        //setBackground(Color.cyan);
        //initalize
        this.frame = frame;
        this.nextPanel1 = gamePanel;
        this.nextPanel2 = aboutPanel;
        this.tp = tp;
        this.players = players;
        
        setLayout (new GridLayout (3, 1));
        
        add(firstPanel());        
        add(secondPanel());
        add(thirdPanel());
    }
    
    /**
     * firstPanel displays text asking for player's names and number of CPU players
     * @return firstPanel
     */
    private JPanel firstPanel()
    {
        JPanel firstPanel = new JPanel();
        //firstPanel.setBackground(Color.cyan);
        message = new JLabel("You will be playing with two computer players");
        Font baskerville = new Font ("Baskerville", Font.PLAIN, 24);
        message.setFont(baskerville);
        
        firstPanel.add(message);
        
        return firstPanel;
    }
    
    /**
     * secondPanel provides textfields for player to input their name
     * @return secondPanel
     */
    private JPanel secondPanel()
    {
        JPanel secondPanel = new JPanel();
        
        player1 = new JLabel("Please enter your name: ");
        //cpu = new JLabel("You will be playing with 2 computers");
        
        playerName1 = new JTextField(10);
           
        secondPanel.add(player1);
        secondPanel.add(playerName1);
        //secondPanel.add(cpu);
        
        return secondPanel;
    }

    /**
     * thirdPanel provides a button to push after the textfields have been 
     * filled. 
     * @return thirdPanel
     */
    private JPanel thirdPanel()
    {
        JPanel thirdPanel = new JPanel();
        
        play = new JButton("Play!");
        play.addActionListener(new ButtonListener());
        
        thirdPanel.add(play);
        
        return thirdPanel;
    }
    
    
    /**
     * ButtonListener: will listen to button and save text from text boxes and 
     * then take user to the GamePanel
     */
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == play){
                //save names in text box
                String name = playerName1.getText();
                
                //if no name has been entered then "Player 1" is used as a default name
                if (name.equals("")) {
                    name = "Player 1";
                }
                validPlayers(name);
                
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
    /**
     * Helper method to check if a the text is valid and then save it to a LinkedList<Player> 
     */
    private void validPlayers(String name1) {
            if (!name1.equals(null) && !name1.equals("")) {
                players.add(new Human(name1));
            }
            players.add(new CPU());
            players.add(new CPU());
            
            System.out.println(players.toString());
        }
    
    /**
     * Getter for the LinkedList<Player>
     * @return LinkedList<Player> players
     */
    public LinkedList<Player> getPlayers(){
        return players;
    }
}
