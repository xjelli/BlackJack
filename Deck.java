import javafoundations.*;
import java.util.*;
import java.io.*;
/**
 * This class represents a collection of Cards objects stored in a Stack,
 * using the javafoundations package implementation of ArrayStack
 * 
 *
 * @author Jessica Li
 * @version December 12, 2018
 */
public class Deck {
    // instance variable
    private ArrayStack<Card> allCards;

    /**
     * constructor
     */
    public Deck(int numOfDecks) {
        allCards = new ArrayStack<Card>();
        for (int j = 1; j <= numOfDecks; j++) {
            for (int i = 1; i <= 13; i++) {
                allCards.push(new Card("Spades", i));
                allCards.push(new Card("Diamonds", i));
                allCards.push(new Card("Clubs", i));
                allCards.push(new Card("Hearts", i));
            }
        }
    }

    /**
     * Recreate the allCards stack by randomly shuffling the cards around
     * using the Random class and the Java implementation of a LinkedList
     */
    public void randomShuffle() {
        Random rand = new Random();
        LinkedList list = new LinkedList();
        int size = allCards.size();
        for(int i = 0; i < size; i++) {
            list.add(allCards.pop());
        }
        for(int i = 0; i < size; i++) {
            int j = rand.nextInt(size-i); 
            allCards.push((Card)list.get(j));
            list.remove(j);
        }
    }
    /**
     * 
     */
    public int sizeOfDeck() {
        return allCards.size();
    }
    /**
     * 
     */
    public Card deal() {
        if(!allCards.isEmpty()) {
            return allCards.pop();
        } else {
            return null;
        }
    }

    /**
     * returns a string representation of the deck
     */
    public String toString() {
        return "Top of deck: \n" + allCards.toString() + "Bottom of deck\n";
    }

    /**
     * testing some key methods
     */
    public static void main(String[] args){
        //Deck deck1 = new Deck(1);
        Deck deck2 = new Deck(2);
        //System.out.println("Deck1: " + deck1.toString());
        System.out.println("Deck2: " + deck2.toString());
        //deck1.randomShuffle();
        deck2.randomShuffle();
        //System.out.println("Deck1 shuffled: " + deck1.toString());
        System.out.println("Deck2 shuffled: " + deck2.toString());
        System.out.println("Size of deck2: " + deck2.sizeOfDeck());
        System.out.println("Deal a card from deck2: " + deck2.deal().toString());
        System.out.println("Size of deck2: " + deck2.sizeOfDeck());
    }
}
