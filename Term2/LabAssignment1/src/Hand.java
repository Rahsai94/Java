import java.util.ArrayList;

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

        int[] suits =  new int[4];
        int[] values = new int[14];

        // Local Variables for card status
        boolean triple = false, flush = false, fourOfKind = false, series = true;
        int pair = 0;
        int seriesValue = hand.get(0).getNumericValue()-1;


        //Count Suits
        for (int i = 0; i < hand.size(); i++){

            //get the repeated values of cards
            values[hand.get(i).getNumericValue()-1]++;

            //Check Series value
            seriesValue++;

            switch (hand.get(i).getSuit()){
                case "Clubs":
                    suits[0]++;
                    break;
                case "Hearts" :
                    suits[1]++;
                    break;
                case "Diamonds":
                    suits[2]++;
                    break;
                case "Spades":
                    suits[3]++;
                    break;
            }

            //Check Series of Cards in hand
            if(seriesValue != hand.get(i).getNumericValue()){
                series = false;
                if(i == 4  && hand.get(i-1).getNumericValue() == 5 && hand.get(4).getNumericValue() == 14){
                    series = true;
                }
            }

        }

        //Check flush suit
        for (int i: suits) {
            if(i == 5){
                flush = true;
            }
        }

        //Check pair and triple card
        for (int i: values) {
            if(i == 3){
                triple = true;
            }
            if(i == 2){
                pair++;
            }
        }


        //royal flush (J,Q,K,A,10 all the same suit)
        if((hand.get(0).getNumericValue() == 10) && flush){
            return ranks[0];
        }

        //straight flush (5 cards in a row all  same suit e.g. 3S, 4S, 5S, 6S, 7S)
        if(flush && series){
            return ranks[1];
        }

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)
        for (int i: values) {
            if(i == 4){
                return ranks[2];
            }
        }

        //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)
        if(triple && (pair == 1)){
            return ranks[3];
        }

        //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)
        if(flush){
            return ranks[4];
        }

        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)
        if(series){
            return ranks[5];
        }

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)
        if(triple){
            return ranks[6];
        }

        //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)
        if(pair == 2){
            return ranks[7];
        }

        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)
        if(pair == 1){
            return ranks[8];
        }

        //high card (None of the other hands match, the highest value of the card)
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
