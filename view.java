//to make easier the inputs
import java.util.Scanner;

public class view {

    public static void main(String[] args) {
        //to make easier the inputs
        Scanner input = new Scanner(System.in);

        //we ask for max rank and suit
        System.out.print("How many ranks? ");
        int maxRank = input.nextInt(); 
        System.out.print("How many suits? ");
        int maxSuit = input.nextInt();

        //we verfy that there are valid values
        boolean valid = false;
        while (!valid) {
            if (maxRank >= 0 && maxSuit >= 0) {
                valid = true;
            } else {
                System.out.println("Invalid input, please enter values greater than 1.");
                System.out.print("How many ranks? ");
                maxRank = input.nextInt();
                System.out.print("How many suits? ");
                maxSuit = input.nextInt();
            }
        }

        if (valid == true) {

        
        //a boolean to run the program multiple times, unitl the user selects the option 4
        boolean programrun = false;
        while (!programrun) {
            //give the info of the cards
            DeckofCards deck = new DeckofCards(maxSuit, maxRank);
            System.out.println(deck.toString());
            //ask the user to choose an option
            System.out.print("1=shuffle, 2=deal 1 hand, 3=deal 100000 times, 4=quit: ");
            int userOption = input.nextInt();

            //conditional to select the options and execute the corresponding methods
            switch (userOption) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    System.out.print("How many cards? ");
                    int userAmmount = input.nextInt();
                    deck.deal(userAmmount);
                    break;
                case 3:
                    System.out.print("How many cards? ");
                    int handSize = input.nextInt();
                    deck.histogram(handSize);
                    break;
                case 4:
                    programrun = true;
                    break;
                default:
                    break;
            }
        }
        }
        //bye wheb the loop ends
        System.out.println("BYE!");

        //somewhy and somehow the program does not works without this, I cant find the error and this was recomended by the terminal
        input.close();
    }

}