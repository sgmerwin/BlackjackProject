package blackjack;

import java.util.ArrayList;

public abstract class AbstractHand {
    protected ArrayList<Card> hand;

    abstract int getHandValue();

    abstract void addCard(Card card);

    abstract void clear();

    abstract void print();

}
