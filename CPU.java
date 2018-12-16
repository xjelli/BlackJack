import java.util.*;
import javafoundations.*;
/**
 * Write a description of class CPU here.
 *
 * @author Jessica Li
 * @version December 13, 2018
 */
public class CPU extends Player{
    //
    private int toBet;
    private int numDecks = 6;
    private double money;
    private final double BET_UNIT = 20;
    
    /**
     * 
     */
    public CPU() {
        super();
        toBet = 0;
        money = 1000.0;
    }
    
    /**
     * 
     */
    public void countCard(Card c) {
        switch(c.getValue()) {
            case 2: case 3: case 4: case 5: case 6: toBet++; break;
            case 7: case 8: case 9: break;
            default: toBet--; break;
        }
        toBet = toBet/numDecks;
    }
    
    /**
     * 
     */
    public double bet() {
        double bet = 0;
        if (toBet > 0) {
            bet = toBet*BET_UNIT + BET_UNIT;
        } else if (toBet <= 0) {
            bet = BET_UNIT;
        }
        return bet;
    }
}
