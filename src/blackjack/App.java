package blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	protected Scanner input;
	protected int choice = 0;
	protected Deck deck;
	protected int sum = 0;
	protected BlackjackHand dealerHand;
	protected BlackjackHand userHand;
	protected boolean exit = false;

	public void start() {
		while( !exit) {
			System.out.println();
			System.out.println("Let's play blackjack!");
			this.deck = new Deck();
			dealerHand = new BlackjackHand();
			userHand = new BlackjackHand();
			deck.shuffle();
			System.out.println("The dealer shuffled a new deck.");
			menu();
		}//while
	}

	public void menu(){
		while(!exit) {
			this.input = new Scanner(System.in);
			System.out.println();
			System.out.println("1. If you want to see that the decks are being shuffled, two shuffled decks will be printed to the terminal.");
			System.out.println("2. Play Blackjack!");
			System.out.println("3. Quit");
			System.out.println("Enter the number of your choice.");
			try {
				choice = input.nextInt();
			} catch (NumberFormatException e) {
				continue;
			}
			catch(InputMismatchException e) {
				continue;
			}
			if (choice < 1 || choice > 3) {
				continue;
			}
			if (choice == 1) {
				choice1();
			}
			if (choice == 2) {
				choice2();
			}
			if (choice == 3) {
				System.out.println("Exiting App");
				choice3();
				choice = 0;
			}
		}//while
	}//method

	void choice1(){
		while(!exit) {
			deck.shuffle();
			for (int i = 0; i < 52; i++) {
				printCard(i);
			}
			System.out.println();
			System.out.println("Reshuffled");
			System.out.println();
			deck.shuffle();
			for (int i = 0; i < 52; i++) {
				printCard(i);
			}
			menu();
		}//while
	}//method

	void choice2(){
		while(!exit){
			deck.shuffle();
			System.out.println("You are dealt two cards.");
			printCard(0);
			userHand.addCard(deck.cards.get(0));
			deck.dealCard();
			printCard(0);
			userHand.addCard(deck.cards.get(0));
			deck.dealCard();
			System.out.println("The dealer is dealt two cards.");
			printCard(0);
			dealerHand.addCard(deck.cards.get(0));
			deck.dealCard();
			System.out.println("The dealer's second card is face down.");
			dealerHand.addCard(deck.cards.get(0));
			deck.dealCard();
			checkValues();
		}//while
	}//method

	void checkValues(){
		while(!exit) {
			userHand.getHandValue();
			dealerHand.getNoPrintHandValue();
			if (userHand.isBlackjack() && dealerHand.isBlackjack()) {
				System.out.println("You both have 21! Draw!");
				System.out.println("Your hand.");
				userHand.print();
				System.out.println("The dealer's hand.");
				dealerHand.print();
				start();
			}
			if (userHand.isBlackjack() && !dealerHand.isBlackjack()) {
				System.out.println("Blackjack!");
				System.out.println("Your hand.");
				userHand.print();
				System.out.println("The dealer's hand.");
				dealerHand.print();
				start();
			}
			if (!userHand.isBlackjack() && dealerHand.isBlackjack()) {
				System.out.println("House wins!");
				System.out.println("The dealer's hand.");
				dealerHand.print();
				System.out.println("Your hand.");
				userHand.print();
				start();
			}
			if(userHand.isBusted() && !dealerHand.isBusted()){
				System.out.println("Your busted!");
				System.out.println("Your hand.");
				userHand.print();
				System.out.println("The dealer's hand.");
				dealerHand.print();
				start();
			}
			if(!userHand.isBusted() && dealerHand.isBusted()){
				System.out.println("The house is busted!");
				System.out.println("You win!");
				System.out.println("Your hand.");
				userHand.print();
				System.out.println("The dealer's hand.");
				dealerHand.print();
				start();
			}
			if ((!userHand.isBlackjack() && !dealerHand.isBlackjack()) && (!userHand.isBusted() && !dealerHand.isBusted())) {
				playHand();
			}
			else{
				System.out.println("The programmer missed a case.");
				start();
			}//else
		}//while
	}//method

	void playHand(){
		while(!exit){
			this.input = new Scanner(System.in);
			System.out.println("Would you like to hit or stay?");
			System.out.println("Enter 1 for a hit and 2 to stay.");
			try {
				choice = input.nextInt();
			} catch (NumberFormatException e) {
				continue;
			}
			catch(InputMismatchException e) {
				continue;
			}
			if(choice < 1 || choice > 2){
				continue;
			}
			if(choice == 1){
				System.out.println("You take a hit.");
				System.out.println("You are dealt one card.");
				printCard(0);
				userHand.addCard(deck.cards.get(0));
				deck.dealCard();
				checkValues();
			}
			if(choice == 2){
				System.out.println("You stay.");
				dealerCheckValues();
			}
		}//while
	}//method

	void dealerCheckValues(){
		while(!exit){
			dealerHand.getNoPrintHandValue();
			if(dealerHand.isBlackjack()){
				System.out.println("House Wins!");
				System.out.println("The dealer's hand.");
				dealerHand.print();
				System.out.println("Your hand.");
				userHand.print();
				start();
			}
			if(dealerHand.isBusted()){
				System.out.println("The house is busted!");
				System.out.println("The dealer's hand.");
				dealerHand.print();
				System.out.println("Your hand.");
				userHand.print();
				start();
			}
			if(dealerHand.getNoPrintHandValue() < 17){
				System.out.println("The dealer is dealt a card.");
				printCard(0);
				dealerHand.addCard(deck.cards.get(0));
				deck.dealCard();
				continue;
			}
			if((dealerHand.getNoPrintHandValue() >= userHand.getNoPrintHandValue()) && !dealerHand.isBusted()){
				System.out.println("House Wins!");
				System.out.println("The dealer's hand.");
				dealerHand.print();
				System.out.println("Your hand.");
				userHand.print();
				start();
			}
			if((dealerHand.getNoPrintHandValue() < userHand.getNoPrintHandValue()) && !dealerHand.isBusted()){
				System.out.println("The dealer is dealt a card.");
				printCard(0);
				dealerHand.addCard(deck.cards.get(0));
				deck.dealCard();
				continue;
			}//if
		}//while
	}//method

	void choice3(){
		this.exit = true;
	}

	public void printCard(int i){
		System.out.println(deck.cards.get(i).suit.name()+" "+deck.cards.get(i).rank.name());
	}//method

}//class
