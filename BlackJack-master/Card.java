
/**
 * This class represents a card, which contains the suite
 * and an integer. Integers 11, 12, 13 represent Jack, Queen, and King,
 * respectively. The blackjack value of the card reduces Jack, Queen, and King
 * cards to have a value of ten.
 *
 *
 * @author Jessica Li
 * @version December 12, 2018
 */
public class Card implements Comparable<Card> {
    // instance variables
    private int value;
    private int blackjack;
    private String suit;
    private int imageNum;
    
    /**
     * constructor 
     */
    public Card(String s, int v)
    {
        suit = s;
        value = v;
        if (value > 10) {
            blackjack = 10;
        } else {
            blackjack = value;
        }
        imageNum = assignImageNum(s);
    }
    
    private int assignImageNum(String suit){
        if(suit.equals("Spades")) {
            return value -1;
        } else if(suit.equals("Diamonds")){
            return value+12;
        } else if(suit.equals("Clubs")){
            return value+25;
        } else {
            return value+38;
        }
    }
    
    public int getImageNum() {
        return imageNum;
    }

    /**
     * implements compareT0 method in Comparable interface; assumes lowercase
     */
    public int compareTo(Card c) {
        return (blackjack - c.getBlackjack());
    }

    /**
     * getter
     */
    public int getBlackjack() {
        return blackjack;
    }

    /**
     * setter
     */
    public void setBlackjack(int b) {
        blackjack = b;
    }

    /**
     * getter
     */
    public int getValue() {
        return value;
    }

    /**
     * setter
     */
    public void setValue(int v) {
        value = v;
    }

    /**
     * getter
     */
    public String getSuit() {
        return suit;
    }

    /**
     * setter
     */
    public void setSuit(String s) {
        suit = s;
    }

    /**
     * returns a string representation of the object
     */
    public String toString() {
        String s = "";
        switch(value){
            case 11: s = "Jack";
            break;
            case 12: s = "Queen";
            break;
            case 13: s = "King";
            break;
            default: s += value;
            break;
        }
        return s + " of " + suit;
    }
    /*
    /**
     * Main method to test some key methods
     */
    /*public static void main(String[] args) {
        Card test1 = new Card("Hearts", 7);
        Card test2 = new Card("Spades", 12);
        System.out.println("card 1: " + test1.toString());
        System.out.println("card 2: " + test2.toString());
        System.out.println("card 2 compared to card 1 (by blackjack value): " + test2.compareTo(test1));
    }*/
}
