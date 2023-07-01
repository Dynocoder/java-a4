public class BlackJack {
    private int myScore;
    private int dealerScore;
    private boolean myTurn;
    private int sim_myWins;
    private int sim_dealerWins;
    private int sim_notDone;
    private final int winPoints = 21;
    private Deck deckOfCards;

    public BlackJack() {
        this.myScore = 0;
        this.dealerScore = 0;
        this.myTurn = true;

        this.deckOfCards = new Deck();

    }

    public void reset() {
        this.myScore = 0;
        this.dealerScore = 0;
        this.myTurn = true;
        deckOfCards.shuffle();

    }

    public Card draw() {
        return this.draw(false);
    }

    public Card draw(boolean simulated) {
        Card drawnCard = this.deckOfCards.draw(!simulated);

//        Add Score to the player or the dealer
        if (this.myTurn) {
            this.myScore += drawnCard.getValue();
        } else {
            this.dealerScore += drawnCard.getValue();
        }

        return drawnCard;
    }

    public String winCheck() {
        if((this.myScore > this.winPoints) || ((this.myScore == this.winPoints) && (this.dealerScore == this.winPoints))) {
            return "dealer";
        } else if(this.myScore > this.dealerScore) {
            return "player";
        }else {
            return "notDone";
        }
    }

    public void runMonteCarlo(int n, int d) {
        this.sim_dealerWins = 0;
        this.sim_myWins = 0;
        this.sim_notDone = 0;

        int tempMyScore = this.myScore;
        int tempDealerScore = this.dealerScore;
        boolean tempMyTurn = this.myTurn;


//        The number of simulations
        for (int i = 0; i < n; i++) {

            this.reset();

//            The number of draws
            for (int j = 0; j < d; j++) {
                this.draw(true);
//                if there is a winner ("player" or "dealer")
                if (!this.winCheck().equals("notDone")) {
                    break;
                }
            }

//            Incrementing the winners' score.
            if (this.winCheck().equals("dealer")) {
                this.sim_dealerWins++;
            } else if(this.winCheck().equals("player")) {
                this.sim_myWins++;
            } else {
                this.sim_notDone++;
            }




//
        }
    }

}
