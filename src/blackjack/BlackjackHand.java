package blackjack;

import java.util.ArrayList;

public class BlackjackHand extends AbstractHand{

	private int sum;
	private int sumSoft;

	public BlackjackHand() {
		this.hand = new ArrayList<Card>();
	}

	@Override
	int getHandValue() {
		sum = 0;
		sumSoft = 0;
		int count = 0;
		for(Card i : this.hand){
			//System.out.println(i.suit.toString()+" "+i.rank.toString());
			if(i.rank.getValue() == 11){
				sum = sum + 11;
				sumSoft = sumSoft + 1;
				++count;
			}
			else{
				sum = sum + i.rank.getValue();
				sumSoft = sumSoft + i.rank.getValue();
			}
		}//for
		System.out.println("Your sum is "+ sum+".");
		if(count != 0) {
			System.out.println("Your soft sum is "+sumSoft+".");
		}
		if(sum == 21 || sumSoft == 21){
			this.isBlackjack();
		}
		if(sum > 21 && sumSoft > 21){
			this.isBusted();
		}
		if(sum > 21){
			return sumSoft;
		}
		return sum;
	}//method

	int getDealerHandValue() {
		sum = 0;
		sumSoft = 0;
		int count = 0;
		for(Card i : this.hand){
			//System.out.println(i.suit.toString()+" "+i.rank.toString());
			if(i.rank.getValue() == 11){
				sum = sum + 11;
				sumSoft = sumSoft + 1;
				++count;
			}
			else{
				sum = sum + i.rank.getValue();
				sumSoft = sumSoft + i.rank.getValue();
			}
		}//for
		//System.out.println("The sum is "+ sum);
		if(count != 0) {
			//System.out.println("The soft sum is "+sumSoft);
		}
		if(sum == 21 || sumSoft == 21){
			this.isBlackjack();
		}
		if(sum > 21 && sumSoft > 21){
			this.isBusted();
		}
		if(sum > 21){
			return sumSoft;
		}
		return sum;
	}//method

	@Override
	void addCard(Card card) {
		if(this.hand == null){
			this.hand = new ArrayList<Card>();
		}
		this.hand.add(card);
	}

	@Override
	void clear() {
		this.hand = new ArrayList<Card>();
	}

	@Override
	void print() {
		for(Card i : this.hand) {
			System.out.println(i.suit.toString() + " " + i.rank.toString());
		}
	}//method

	boolean isBlackjack() {
		if (sum == 21) {
			//System.out.println("Blackjack!");
			return true;
		}
		if (sumSoft == 21) {
			//System.out.println("Blackjack!");
			return true;
		}
		return false;
	}

	boolean isBusted() {
		if (sum > 21 && sumSoft > 21) {
			//System.out.println("Busted");
			return true;
		}
		return false;
	}
}//class
