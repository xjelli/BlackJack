import java.util.*;
import javafoundations.*;
/**
 * Write a description of class Human here.
 *
 * @authorJessica Li
 * @version December 13, 2018
 */
public class Human extends Player {
    //
    String name;
    double money;
    
    /**
     * Constructor for objects of class Human
     */
    public Human(String n)
    {
        super();
        name = n;
        money = 1000.0;
    }
    
    /**
     * 
     */
    public boolean validBet(double d) {
        return d >= money;
    }
    
    /**
     * 
     */
    public double getMoney() {
        return money;
    }
    
    /**
     * 
     */
    public void setMoney(double m) {
        money = m;
    }
    
    /**
     * 
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     */
    public void setName(String s) {
        name = s;
    }
}
