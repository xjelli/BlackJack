import java.util.*;
import javafoundations.*;

/**
 * Write a description of class BlackJack here.
 *
 * @author Jessica Li
 * @version December 16, 2018
 */
public class BlackJack {
    //
    LinkedList<Player> players;
    Dealer dealer;
    int[] status;
    double[] bets;
    Scanner keyboard = new Scanner(System.in);
    
    /**
     * 
     */
    public BlackJack(Human player1) {
        players = new LinkedList<Player>();
        players.add(player1);
        status = new int[1];
        bets = new double[1];
        dealer = new Dealer(2);
    }
    
    /**
     * 
     */
    public BlackJack(Human player1, Human player2) {
        players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        status = new int[2];
        bets = new double[2];
        dealer = new Dealer(4);
    }
    
    /**
     * 
     */
    public BlackJack(Human player1, Human player2, Human player3) {
        players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        status = new int[3];
        bets = new double[3];
        dealer = new Dealer(6);
    }
    
    /**
     * 
     */
    public BlackJack(Human player1, CPU player2, CPU player3) {
        players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        status = new int[3];
        bets = new double[3];
        dealer = new Dealer(6);
    }
    
    /**
     * 
     */
    public void makeBets() {
        for(int i = 0; i < players.size(); i++) {
            System.out.println("bet:");
            double bet = keyboard.nextDouble();
            makeBet(players.get(i), bet);
        }
    } 
    
    /**
     * 
     */
    private void makeBet(Player p, double bet) {
        int i = players.indexOf(p);
        bets[i] = bet;
    }
    
    /**
     * 
     */
    public void turnDealer() {
        Card temp = dealer.deal();
        while(dealer.sumHand() <= 16) {
            dealer.hit(temp);
        }
    }
    
    /**
     * 
     */
    public void turnCPU(CPU player) {
        Card temp = dealer.deal();
        while(player.sumHand() <= 16) {
            player.hit(temp);
        }
    }
    
    /**
     * 
     */
    public void turnHuman(Human player1) {
        
    }
    
    /**
     * 
     */
    public void clearRound(){
        for(int i = 0; i < players.size(); i++) {
            status[i] = 0;
            bets[i] = 0;
            players.get(i).clearHand();
        }
    }
    
    /**
     * 
     */
    public void startRound() {
        for(int i = 0; i < players.size(); i++) {
            Card temp1 = dealer.deal();
            Card temp2 = dealer.deal();
            players.get(i).hit(temp1));
            players.get(i).hit(temp2);
            status[i] = players.get(i).stand();
        }
    }
    
    /**
     * 
     */
    public int[] endRound() {
        for(int i = 0; i < players.size(); i++) {
            status[i] = players.get(i).stand();
        }
        return status;
    }
}
