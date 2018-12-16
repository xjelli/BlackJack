import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
/**
 * Write a description of class BlackjackGUI here.
 * Overall GUI :D
 *
 * @author (Maya Igarashi)
 * @version (v.1)
 */
public class BlackjackGUI extends JFrame
{     
    public static void main(String[] args) {
        LinkedList<Player> players = new LinkedList<Player>();
        //set up frame
        JFrame frame = new JFrame("Blackjack");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        //set up different panels
        JTabbedPane tp = new JTabbedPane();
        GamePanel gamePanel = new GamePanel(players);
        AboutPanel aboutPanel = new AboutPanel();
        
        
        PlayWithFriendsPage friendsPanel = new PlayWithFriendsPage(frame, tp, gamePanel, aboutPanel, players);
        PlayWithComputerPage cpuPanel = new PlayWithComputerPage(frame, tp, gamePanel, aboutPanel, players);
  
        frame.getContentPane().add(new WelcomePage(frame, friendsPanel, cpuPanel));      
        
        frame.setPreferredSize(new Dimension(800, 600));
        
        frame.pack();
        frame.setVisible(true);
    }
}
