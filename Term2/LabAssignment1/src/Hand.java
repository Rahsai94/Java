import java.util.ArrayList;
import java.util.Arrays;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<>();
    private final String[] ranks = {"Royal Flush", "Straight Flush", "4-of-a-kind", "Full House", "Flush", "Straight",
            "3-of-a-kind", "2 Pair", "1 Pair", "High Card"};

    public void addCard(Card c){
        if(hand.size() < 5){
            hand.add(c);
        }
    }

    public String getHandRank(){
        if(hand.size() != 5){
            return "Incorrect hand size";
        }
        //sort the hand
        hand.sort(new SortCards());

        //high card (None of the other hands match, the highest value of the card)
        for (Card card: hand) {

            System.out.println(card.toString());
        }
        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)

        //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)

        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)

        //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)

        //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)

        //straight flush (5 cards in a row all of the same suit e.g. 3S, 4S, 5S, 6S, 7S)

        //royal flush (J,Q,K,A,10 all of the same suit)

        return ranks[9];
    }

    public String toString(){
        String output = "";
        for(Card c: hand){
            if(c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output += "\u001B[31m[ " + c.getValue() + " , " + c.getSuit() + " ] \u001B[0m";
            }
            else{
                output += "[ " + c.getValue() + " , " + c.getSuit() + " ] ";
            }
        }

        return output;
    }
}
