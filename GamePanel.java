import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class GamePanel here.
 * 
 * To Do: 
 *  -Put input names into stuff
 *  -Add Cards
 *  -Add Bet method
 *  -Add Players turns
 *  -Add win/lose conditions
 *  -ect
 *  
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel
{
    //instance variables
    private JLabel nLabel, sLabel1, sLabel2, sLabel3, cLabel;
    private JLabel nHand, sHand1, sHand2, sHand3;
    private JButton eButton, wButton;
    private LinkedList<Player> players;
    
    /**
     * Constructor for objects of class GamePanel
     */
    public GamePanel(LinkedList<Player> players)
    {
        this.players = players;
        setLayout (new BorderLayout());
        setBackground(Color.green);
        
        add(northPanel(), BorderLayout.NORTH);
        add(centerPanel(), BorderLayout.CENTER);
        add (southPanel(), BorderLayout.SOUTH);
        add(eastPanel(), BorderLayout.EAST);
        add(westPanel(), BorderLayout.WEST);
        

        setPreferredSize (new Dimension(800, 800));
    }
    
    /**
     * Sets up dealer
     */
    private JPanel northPanel()
    {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.setBackground(Color.green);
        nLabel = new JLabel("Dealer", SwingConstants.CENTER);
        Font baskerville = new Font ("Baskerville", Font.BOLD, 24);
        nLabel.setFont(baskerville);
        
        //nHand = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);        
        
        northPanel.add (nLabel);
        northPanel.add(nHand);

        return northPanel;
    }
    
    /**
     * Creates Dealer's hand
     */
    private JPanel dealerHand()
    {
        JPanel dealerHand = new JPanel();
        dealerHand.setLayout(new GridLayout(1, 7));
        
        //ImageIcon card1 = new ImageIcon("AS.png");
        
        nHand = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);
        dealerHand.setBackground(Color.green);
        dealerHand.add(nHand);
        
        return dealerHand;
    }
    
    /**
     * Details which player's turn it is and betting method
     */
    private JPanel centerPanel()
    {
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.green);
        cLabel = new JLabel("PLAYER'S TURN"); //Change later
        centerPanel.add(cLabel);
        
        return centerPanel;
    }
    
    /**
     * Hit Button
     */
    private JPanel eastPanel()
    {
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.green);
        
        eButton = new JButton("Stand");
        eButton.addActionListener(new ButtonListener());
        
        eastPanel.add(eButton);
        return eastPanel;
    }
    
    /**
     * Stand Button
     */
    private JPanel westPanel()
    {
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.green);
        
        wButton = new JButton("Hit");
        wButton.addActionListener(new ButtonListener());
        
        westPanel.add(wButton);
        return westPanel;
    }
    
    /**
     * How to make the buttons actually do something. Need to complete
     */
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == wButton){
                //Hit!
                //Add random card to hand
                //update hand panel
            }
            else if (event.getSource() == eButton){
                //Stand!
                //End turn
            }
        }
    }
    
    /**
     * Display the Players' hands
     */
    private JPanel southPanel(){
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 3));
        southPanel.setBackground(Color.green);
        
        sLabel1 = new JLabel("Player 1", SwingConstants.CENTER); //Make so name can be changed
        sLabel2 = new JLabel("Player 2", SwingConstants.CENTER); //Add hands
        sLabel3 = new JLabel("Player 3", SwingConstants.CENTER);
        
        sHand1 = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);
        sHand2 = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);
        sHand3 = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);
        
        //southPanel.add(sHand3);
        //southPanel.add(sHand2);
        //southPanel.add(sHand1);
        southPanel.add(playerHand3());
        southPanel.add(playerHand2());
        southPanel.add(playerHand1());
        
        southPanel.add(sLabel3);
        southPanel.add(sLabel2);
        southPanel.add(sLabel1);
        
        return southPanel;
    }
    
    /**
     * Panels to construct player's hands?
     */
    
    private JPanel playerHand1(){
        JPanel playerHand1 = new JPanel();
        playerHand1.setLayout(new GridLayout(1, 7));
        
        ImageIcon card1 = new ImageIcon("AS.png");
        
        sHand1 = new JLabel(card1, SwingConstants.CENTER);
        playerHand1.setBackground(Color.green);
        playerHand1.add(sHand1);
        
        return playerHand1;
    }
    private JPanel playerHand2(){
        JPanel playerHand2 = new JPanel();
        playerHand2.setLayout(new GridLayout(1, 7));
        sHand2 = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);
        playerHand2.setBackground(Color.green);
        playerHand2.add(sHand2);
        return playerHand2;
    }
    private JPanel playerHand3(){
        JPanel playerHand3 = new JPanel();
        playerHand3.setLayout(new GridLayout(1, 7));
        sHand3 = new JLabel("(PUT CARDS HERE)", SwingConstants.CENTER);
        playerHand3.setBackground(Color.green);
        playerHand3.add(sHand3);
        return playerHand3;
    }
    
    
    private JPanel Bet(){
        JPanel betPanel = new JPanel();
        
        return betPanel;
    }
}
