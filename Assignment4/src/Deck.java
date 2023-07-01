import java.util.Arrays;

public class Deck {

    private Card cards[] = new Card[52];


    private String suits[] = {"Clubs", "Spades", "Hearts", "diamonds"};
    private String cardRanks[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};

    public Deck() {
//        Declared inside the function to reduce scope.

        int cardCounter = 0;

//        Creating a Deck of cards
        for (String suit: this.suits) {
            for (String card: this.cardRanks) {
                this.cards[cardCounter] = new Card(suit, card);
                cardCounter++;
            }
        }
    }


    public boolean checkCard(boolean real) {
        if (real) {
            for (Card card: this.cards) {
                if(!card.isPlayed()) {
                    return true;
                }
            }
        } else {
            for (Card card: this.cards) {
                if(!card.isSimulated()) {
                    return true;
                }
            }
        }

        return false;
    }

//not done***************************
    public Card draw(boolean real) {
//        checking if there are any unplayed cards in the deck
        if (!checkCard(real)) {
            return null;
        }


        int randIndex;

        while (true) {
//          Generating a random index
            randIndex = (int)(Math.random()*53);

//            if the draw is real
            if(real) {
                //          if the card is unplayed
                if (!cards[randIndex].isPlayed()) {
                    cards[randIndex].setPlayed(true);
                    return cards[randIndex];
                }
            } else {
                if (!cards[randIndex].isSimulated()) {
                    cards[randIndex].setSimulated(true);
                    return cards[randIndex];
                }
            }
        }
    }


    public void shuffle() {
        for (Card card: cards) {
            card.setPlayed(false);
        }
    }

    public void resetSimulation() {
        for (Card card: cards) {
            card.setSimulated(false);
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deckOfCards=" + Arrays.toString(cards) +
                '}';
    }
}
