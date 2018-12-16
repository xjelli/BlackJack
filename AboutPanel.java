import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
/**
 * Sets up a tab for the main program that explains the gameplay of Blackjack 
 *
 * TO DO: Put useful text here and format it nicely
 * 
 * @author Maya Igarashi
 * @version (v.1)
 */
public class AboutPanel extends JPanel
{
    // instance variables - replace the example below with your own
    private JLabel text;

    /**
     * Constructor for objects of class AboutPanel
     */
    public AboutPanel()
    {
        // initialise instance variables
        this.setLayout(new BorderLayout());
        //JTextArea text = new JTextArea();
        text = new JLabel("<html>The winner is declared based on how close a player's hand is to 21. However, " + 
        "if the player's hand totals over 21 their hand is declared “bust” and has no value. <br>" + 
        "A player can choose to either “hit” or “stand.” <br>" +
        "'Hit': a new card is added to a player's hand face up <br>" + 
        "'Stand': no new cards are added and the turn ends giving the dealer and other players the same choices"+
        " in order going around from the dealer’s left<br>"+
        "Each card is its face value except:<br>"+
        "   - Jack, queen, and king are all worth ten points<br>"+
        "   - The ace has a value of one if the player has more than ten points already " +
        "in the hand, otherwise it is worth eleven points.<br>" + 
        "   - The ace is the only card with a flexible point value.<html>");
        Font baskerville = new Font ("Baskerville", Font.PLAIN,24);
        text.setFont(baskerville);
        add(text);
        //setBackground(Color.green);
    }

    
}
