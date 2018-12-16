import java.util.*;
import javafoundations.*;
/**
 * Write a description of class Dealer here.
 *
 * @author Jessica Li
 * @version December 13, 2018
 */
public class Dealer extends Player{
    //
    Deck cards;
    int numPlayers;
    
    /**
     * 
     */
    public Dealer(int n) {
        super();
        numPlayers = n;
        cards = new Deck(numPlayers*2);
        cards.randomShuffle();
    }
    
    /**
     * 
     */
    public Card deal() {
        Card n = cards.deal();
        if (n != null){
            return n;
        } else {
            cards = new Deck(numPlayers*2);
            cards.randomShuffle();
            return cards.deal();
        }
    }
}
