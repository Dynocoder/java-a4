public class Card {

    private String suit;
    private String rank;
    private int value;

    private boolean played = false;
    private boolean simulated = false;


    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;

        if (rank.equals("Ace")) {
            this.value = 11;
        } else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
            this.value = 10;
        } else {
            this.value = Integer.parseInt(rank);
        }
    }


    public int getValue() {
        return value;
    }

    public boolean isPlayed() {
        return played;
    }

    public boolean isSimulated() {
        return simulated;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    @Override
    public String toString() {
        return "the " + this.rank + " of " + this.suit + " Value: " + this.value;
    }
}
