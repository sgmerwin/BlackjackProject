package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
    protected List<Card> cards;

    public Deck(){
        cards = createDeck();
    }

    private List<Card> createDeck(){
        List<Card> deck = new ArrayList<Card>(52);
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
        return deck;
    }//method

    public int checkDeckSize(){
        return cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card dealCard(){
        return cards.remove(0);
    }

}
