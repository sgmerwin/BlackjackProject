package blackjack;

import java.util.Scanner;

public class App {
	
    protected Scanner input;
    protected int choice = 0;
    protected Deck deck;
    protected int sum = 0;

    public void start(){
        this.input = new Scanner(System.in);
            try {
                System.out.println("How many cards do you want?");
                choice = input.nextInt();
                if(choice < 1 || choice > 52){
                    System.out.println("Enter an int between 1 - 52");
                    start();
                }
                deal();
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer between 0 - 52");
                start();
            }
        }//start
    public void deal(){
        this.deck = new Deck();
        System.out.println("The size of the deck is "+deck.checkDeckSize());
        deck.shuffle();
        for(int i = 0; i < choice; i++){
            System.out.println(deck.cards.get(0).suit+" "+deck.cards.get(0).rank);
            sum = sum + deck.cards.get(0).rank.getValue();
            deck.dealCard();
        }
        System.out.println(sum);
    }//deal

}
