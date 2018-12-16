import java.util.*;
import javafoundations.*;
/**
 * Write a description of class Blackjack here.
 *
 * @Jessica Li
 * @December 13, 2018
 */
public class BlackJackDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Human or Computer players?");
        if (keyboard.next().equals("H")) {
            System.out.println("Player 1 name:");
            Human player1 = new Human(keyboard.next());
            System.out.println("Player 2 name:");
            Human player2 = new Human(keyboard.next());
            System.out.println("Player 3 name:");
            Human player3 = new Human(keyboard.next());
            LinkedList<Human> players = validPlayers(player1, player2, player3);
            LinkedList<Integer> status = new LinkedList<Integer>();
            LinkedList<Double> bets = new LinkedList<Double>();
            for(int i = 0; i < bets.size(); i++) {
                System.out.println("Bet:");
                bets.add(keyboard.nextDouble());
            }
            Dealer dealer = new Dealer(players.size());
            while(!players.isEmpty()) {
                for(int i = 0; i < players.size(); i++) {
                    Human temp = players.get(i);
                    while(players.get(i).validHand()) {
                        System.out.println("Hit or Stand");
                        if(!keyboard.next().equals("Stand")) {
                            temp.hit(dealer.deal());
                        } else {
                            status.add(temp.stand());
                        }
                    }
                    if(status.get(i) == -1) {
                        temp.setMoney(temp.getMoney() - 2*bets.get(i));
                        players.remove(i);
                    } else {
                        while(dealer.sumHand() <=16) {
                            dealer.hit(dealer.deal());
                        }
                        if(dealer.stand() == -1) {
                            for(int j = 0; j < players.size(); j++) {
                                
                            }
                        }
                    }
                }
            }
        } else {
            Human player1 = new Human("name");
            CPU player2 = new CPU();
            CPU player3 = new CPU();
            BlackJack game = new BlackJack(player1, player2, player3);
            while(!quitGame()) {
                game.makeBets();
                game.startRound();
                game.turnHuman(player1);
                game.turnCPU(player2);
                game.turnCPU(player3);
                game.turnDealer();
                game.endRound();
                game.clearRound();
            }
        }
    }
   
    public static boolean quitGame() {
        return false;
    }
    private static LinkedList<Human> validPlayers(Human one,Human two, Human three) {
        LinkedList<Human> players = new LinkedList<Human>();
        if (!one.getName().equals(null) && !one.getName().equals("")) {
            players.add(one);
        }
        if (!two.getName().equals(null) && !two.getName().equals("")) {
            players.add(two);
        }
        if (!three.getName().equals(null) && !three.getName().equals("")) {
            players.add(three);
        }
        return players;
    }
}
