import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class PlayWithFriendsPage here.
 * 
 * To Do: Save input names and use in GamePanel (if no text assume no player)
 *
 * @author Maya Igarashi
 * @version v.1
 */
public class PlayWithFriendsPage extends JPanel
{
    //Instance Variables
    private JLabel message, player1, player2, player3;
    private JTextField playerName1, playerName2, playerName3;
    private JButton play;

    private JFrame frame;
    private JPanel nextPanel1, nextPanel2;
    private JTabbedPane tp;
    private LinkedList<Player> players;

    /**
     * Constructor for objects of class PlayWithFriendsPage
     * @param JFrame, JTabbedPane, GamePanel, AboutPanel, LinkedList<Player>
     */
    public PlayWithFriendsPage(JFrame frame, JTabbedPane tp, GamePanel gamePanel, AboutPanel aboutPanel, LinkedList<Player> players)
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
     * firstPanel displays informative text asking for players' names
     * @return firstPanel
     */
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

    /**
     * secondPanel provides the labels and textfields for players to input names
     * @return secondPanel
     */
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

    /**
     * thirdPanel provides a "play" button to push after the textfields have been 
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
                //save names in text boxes to...
                String name1 = playerName1.getText();
                String name2 = playerName2.getText();
                String name3 = playerName3.getText();

                validPlayers(name1, name2, name3);
               
                //System.out.println(players.toString());
                
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
    private void validPlayers(String name1,String name2, String name3) {
            if (!name1.equals(null) && !name1.equals("")) {
                players.add(new Human(name1));
            }
            if (!name2.equals(null) && !name2.equals("")) {
                players.add(new Human(name2));
            }
            if (!name3.equals(null) && !name3.equals("")) {
                players.add(new Human(name3));
            }
            //System.out.println(players.toString());
        }
    /**
     * Getter for the LinkedList<Player>
     * @return LinkedList<Player> players
     */
    public LinkedList<Player> getPlayer() {
            System.out.println(players.toString());
            return players;
        }
}
