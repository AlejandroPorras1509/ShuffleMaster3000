public class Card {
    //rank and suit of the card
    private int rank;
    private int suit;

    //constructor of the deck of cards
    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    //getter in case we need the suit
    public int  getSuit() {
        return suit;
    }

    //getter in case we need the rank
    public int getRank() {
        return rank;
    }

    //retrive the total value of the card
    public int value() {
        return suit *  rank;
    }

    @Override
    public String toString() {
        //string representation of the card
        String card = ("S" + (char)((int)'A' + (suit - 1))) + "R" + rank;
        return card;
    }

    
}
