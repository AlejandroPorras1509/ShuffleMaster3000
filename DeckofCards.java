public class DeckofCards {
    //max rank, defined by user
    private int maxRank;
    //max suit, defined by user
    private int maxSuit;
    //total cards, defined by the machine
    private int totalCards;
    //cards of the deck, defined by the machine
    private String[] cardsDeck;

    //constructor of the deck of cards
    public DeckofCards(int maxSuit, int maxRank) {
        this.maxRank = maxRank;
        this.maxSuit = maxSuit;
        this.totalCards = maxRank * maxSuit;
        cardsDeck = new String[totalCards];

        //create the cards of the deck
        for (int i = 0 ; i < totalCards; i++) {
            for (int j = 0; j < maxSuit; j++){
                for (int k = 0; k < maxRank; k++){
                    Card newcard = new Card(j + 1, k + 1);
                    cardsDeck[i] = newcard.toString();
                    i++;
                }
            }
        }

        //shuffle the deck by default
        for (int i = 0; i < totalCards; i++) {
            int randomCard = (int)(Math.random() * totalCards);
            String temp = cardsDeck[i];
            cardsDeck[i] = cardsDeck[randomCard];
            cardsDeck[randomCard] = temp;
        }
    }

    public void shuffle() {
        //shuffle the deck
        for (int i = 0; i < totalCards; i++) {
            int randomCard = (int)(Math.random() * totalCards);
            String temp = cardsDeck[i];
            cardsDeck[i] = cardsDeck[randomCard];
            cardsDeck[randomCard] = temp;
        }
    }

    public void deal(int userAmmount) {
        //we see if it's a valid input, if not we just break and return to the menu
        if (userAmmount <= 0) {
            System.out.println("Choose a value over 0");
            return;
        } else if (userAmmount > totalCards) {
            System.out.println("Not enough cards in the deck");
            return;
        }
        //we make a list for the hand
        String[] hand = new String[userAmmount];

        //we add the top cards to the hand
        for (int i = 0; i < userAmmount; i++) {
            hand[i] = cardsDeck[totalCards - 1 - i];
        }

        //we print the hand
        for (String hand1 : hand) {
            System.out.print("Card: " + hand1 + " ");
        }
        System.out.println();
    }

    public void histogram(int handSize) {
         //we see if it's a valid input, if not we just break and return to the menu
        if (handSize <= 0) {
            System.out.println("Choose a value over 0");
            return;
        } else if (handSize > totalCards) {
            System.out.println("Not enough cards in the deck");
            return;
        }

        //array to store the histogram values that the sum of cards is going to retrieve to us
        int[] histogramValues = new int[totalCards * 1000000];

        //we do this 100000 times as the pdf asks
        for (int x = 0; x < 100000; x++) {
            //we create an array to store the integer values of the deck
            int[] histogramDeck = new int[totalCards];

            //create the cards of the deck but now with an integrer value, not an string one
            for (int i = 0 ; i < totalCards; i++) {
                for (int j = 0; j < maxSuit; j++){
                    for (int k = 0; k < maxRank; k++){
                        Card newcard = new Card(j + 1, k + 1);
                        newcard.value();
                        histogramDeck[i] = newcard.value();
                        i++;
                    }
                }
            }
            
            //shuffle the deck
            for (int i = 0; i < totalCards; i++) {
                int randomCard = (int)(Math.random() * totalCards);
                int temp = histogramDeck[i];
                histogramDeck[i] = histogramDeck[randomCard];
                histogramDeck[randomCard] = temp;
            }

            //make the hand
            int[] hand = new int[handSize];
            for (int i = 0; i < handSize; i++) {
                hand[i] = histogramDeck[totalCards - 1 - i];
            }

            //sum the hand values
            int sum = 0;
            for (int hand1 : hand) {
                sum += hand1;
            }

            //add the sum to the histogram array
            histogramValues[sum]++;
        }
        //print the histogram
        for (int i = 0; i < histogramValues.length; i++) {
            if (histogramValues[i] != 0) {
                System.out.println(i + ": " + histogramValues[i]);
            }
        }
    }

    @Override
    public String toString() {
        //menu string with the info of the deck
        Card highCard = new Card(maxSuit, maxRank);
        return "Deck of " + totalCards + " cards: low " + 1 + " high " + highCard.value() + " top card " + cardsDeck[totalCards - 1];
    }
}
