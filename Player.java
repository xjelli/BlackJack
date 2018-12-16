import java.util.*;
import javafoundations.*;
/**
 * Abstract class Player 
 *
 * @Jessica Li
 * @December 13, 2018
 */
public abstract class Player {
    
    LinkedList<Card> hand;
    
    public Player() {
        hand = new LinkedList<Card>();
    }
    public void hit(Card c){
        hand.add(c);
        stand();
    }
    public int stand() {
        if(validHand()) {
            if(checkWin()) {
                if (checkBlackjack()) {
                    return 0;
                }
                return 1;
            }
            return sumHand();
        } else {
            return -1;
        }
    }
    public boolean checkWin() {
        return sumHand() == 21;
    }
    public boolean validHand() {
        return sumHand() <= 21;
    }
    public boolean checkBlackjack() {
        if(hand.size() == 2) {
            if(hand.get(0).getValue() == 0 && hand.get(1).getBlackjack() == 10) {
                return true;
            }
            if(hand.get(1).getValue() == 0 && hand.get(0).getBlackjack() == 10) {
                return true;
            }
        }
        return false;
    }
    public int sumHand() {
        int sum = 0;
        for (int i = 0; i < hand.size(); i++) {
            sum += hand.get(i).getBlackjack();
        }
        return sum;
    }
    public void clearHand() {
        while(!hand.isEmpty()){
            hand.remove();
        }
    }
}
