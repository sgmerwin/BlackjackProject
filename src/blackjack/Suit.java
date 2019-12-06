package blackjack;

public enum Suit {
	
	   HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

    Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;

}
