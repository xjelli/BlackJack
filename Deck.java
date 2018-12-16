import javafoundations.*;
import java.util.*;
import java.io.*;
import images.*;
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
    private LinkedList<String> imageNames;
    
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
        imageNames = new LinkedList<String>();
        addImages();
    }
    
    private void addImages() {
        imageNames.add("AS.png");
        imageNames.add("2S.png");
        imageNames.add("3S.png");
        imageNames.add("4S.png");
        imageNames.add("5S.png");
        imageNames.add("6S.png");
        imageNames.add("7S.png");
        imageNames.add("8S.png");
        imageNames.add("9S.png");
        imageNames.add("10S.png");
        imageNames.add("JS.png");
        imageNames.add("QS.png");
        imageNames.add("KS.png");  
        
        imageNames.add("AD.png");
        imageNames.add("2D.png");
        imageNames.add("3D.png");
        imageNames.add("4D.png");
        imageNames.add("5D.png");
        imageNames.add("6D.png");
        imageNames.add("7D.png");
        imageNames.add("8D.png");
        imageNames.add("9.png");
        imageNames.add("10D.png");
        imageNames.add("JD.png");
        imageNames.add("QD.png");
        imageNames.add("KD.png"); 
        
        imageNames.add("AC.png");
        imageNames.add("2C.png");
        imageNames.add("3C.png");
        imageNames.add("4C.png");
        imageNames.add("5C.png");
        imageNames.add("6C.png");
        imageNames.add("7C.png");
        imageNames.add("8C.png");
        imageNames.add("9C.png");
        imageNames.add("10C.png");
        imageNames.add("JC.png");
        imageNames.add("QC.png");
        imageNames.add("KC.png"); 
        
        imageNames.add("AH.png");
        imageNames.add("2H.png");
        imageNames.add("3H.png");
        imageNames.add("4H.png");
        imageNames.add("5H.png");
        imageNames.add("6H.png");
        imageNames.add("7H.png");
        imageNames.add("8H.png");
        imageNames.add("9H.png");
        imageNames.add("10H.png");
        imageNames.add("JH.png");
        imageNames.add("QH.png");
        imageNames.add("KH.png"); 
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
