## Blackjack Project

### Week 5

### Overview
The card class uses enums rank and suit.<br>
The Deck class has an array list of cards and methods to create a deck, shuffle, deal a card, and check the deck size.<br>
There is an abstract class AbstractHand that has a field for an array list of cards and three abstract methods: addCard, clear, and print.<br>
The BlackjackHand class extends AbstractHand and use three additional fields count, sum and sumSoft as well as four additional methods: getHandValue, getNoPrintHandValue, isBlackJack, and isBusted.<br>
The sum will add an ace as 11. The sumSoft will add an ace as 1.<br>
This works well for 1 ace. If a hand has 2, 3, or 4 aces this system would have to be expanded for all of the possible combinations to be considered. So as it is, 2 aces would be added to the sumSoft as 2 ones and added to the sum as 2 elevens. If sum is greater than 21 the program uses the sumSoft.<br>
There is a count field that keeps track of the aces in the hand. Right now this just controls if the sumSoft value should be printed.<br>
This logic could be expanded with additional integer fields to keep track of all possible cases for multiple aces.<br>
There are points in the program where the hand sums need to be calculated and checked but not always with a printout. That is why there is a getHandValue and a getNoPrintHandValue.<br>
The BlackjackHand class has two boolean methods: isBlackjack and isBusted.<br>
The App class uses these methods to check conditions for the player and dealer.<br>
The App class has fields for a Scanner, Deck, a BlackjackHand for the player and the dealer, and a choice integer for the player's menu options.<br>
App has a start method that is called in main. The start method creates the deck, and the dealer and player hands.<br>
The menu has an option to show that the deck is being shuffled. In the assignment there was a comment about printing a shuffled deck to the screen. To prove the deck does shuffle, two shuffled decks can be printed. When the game is started the deck is reshuffled again.<br>
When the player chooses to play blackjack two cards are dealt to the player and two cards are dealt to the dealer. One of the dealer's cards always stays face down. When the player chooses to stay, the dealer has to take a hit if the dealer's sum is less than 17.<br>
The App class has a checkValues method for the player and a dealerCheckValues method for the dealer. <br>
The dealer's hand and the player's hand are printed at the end of a game.<br>
At the end of the game the App's start method is called again which makes a new deck and new hands. <br>
So this is a one player blackjack game that deals with one ace correctly.<br>

### How to play
When the program is run the player is provided menu choices in the terminal.<br>

### Topics/Technology Used
Eclipse and Java 13

### Lessons Learned
The card class is a great example of when to use enums and what a convenient programming structure enums are. 
