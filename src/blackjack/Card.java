package blackjack;

public class Card {
	protected Rank rank;
    protected Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" + rank + " of "
                 + suit +
                '}';
    }

}
