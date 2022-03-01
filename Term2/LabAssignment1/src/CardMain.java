public class CardMain {
    public static void main(String[] args) {

        Deck d = new Deck(true);
        System.out.println(d);

        Hand h = new Hand();
        for(int i = 0; i<5; i++) {
            h.addCard(d.deal());
        }

        System.out.println("\u001B[31m******* Check Random Hand ******\u001B[0m");
        System.out.println(h);
        System.out.println(h.getHandRank());


        //Testing Check Royal Flush Rank
        System.out.println("\u001B[31m******* Check Royal Flush Card ******\u001B[0m");
        Hand royalFlush = new Hand();
        d = new Deck(true);
        royalFlush.addCard(d.dealSpecificCard("10", "Clubs"));
        royalFlush.addCard(d.dealSpecificCard("A", "Clubs"));
        royalFlush.addCard(d.dealSpecificCard("J", "Clubs"));
        royalFlush.addCard(d.dealSpecificCard("Q", "Clubs"));
        royalFlush.addCard(d.dealSpecificCard("K", "Clubs"));

        System.out.println(royalFlush);
        System.out.println(royalFlush.getHandRank());

        //Testing Check Straight Flush Rank
        System.out.println("\u001B[31m******* Check Straight Flush Card ******\u001B[0m");
        Hand straightFlush = new Hand();
        d = new Deck(true);
        straightFlush.addCard(d.dealSpecificCard("6", "Spades"));
        straightFlush.addCard(d.dealSpecificCard("7", "Spades"));
        straightFlush.addCard(d.dealSpecificCard("8", "Spades"));
        straightFlush.addCard(d.dealSpecificCard("9", "Spades"));
        straightFlush.addCard(d.dealSpecificCard("10", "Spades"));

        System.out.println(straightFlush);
        System.out.println(straightFlush.getHandRank());

        //Testing Check Four Kind Rank
        System.out.println("\u001B[31m******* Check Four Kind Card ******\u001B[0m");
        Hand fourKind = new Hand();
        d = new Deck(true);
        fourKind.addCard(d.dealSpecificCard("7", "Hearts"));
        fourKind.addCard(d.dealSpecificCard("7", "Diamonds"));
        fourKind.addCard(d.dealSpecificCard("7", "Spades"));
        fourKind.addCard(d.dealSpecificCard("7", "Clubs"));
        fourKind.addCard(d.dealSpecificCard("10","Hearts"));

        System.out.println(fourKind);
        System.out.println(fourKind.getHandRank());

        //Testing Check Full House Rank
        System.out.println("\u001B[31m******* Check Full House Card ******\u001B[0m");
        Hand fullHouse = new Hand();
        d = new Deck(true);
        fullHouse.addCard(d.dealSpecificCard("2", "Hearts"));
        fullHouse.addCard(d.dealSpecificCard("2", "Diamonds"));
        fullHouse.addCard(d.dealSpecificCard("2", "Spades"));
        fullHouse.addCard(d.dealSpecificCard("8", "Clubs"));
        fullHouse.addCard(d.dealSpecificCard("8","Hearts"));

        System.out.println(fullHouse);
        System.out.println(fullHouse.getHandRank());

        //Testing Check Straight Rank
        System.out.println("\u001B[31m******* Check Straight Card ******\u001B[0m");
        Hand straight = new Hand();
        d = new Deck(true);
        straight.addCard(d.dealSpecificCard("6", "Hearts"));
        straight.addCard(d.dealSpecificCard("7", "Diamonds"));
        straight.addCard(d.dealSpecificCard("8", "Spades"));
        straight.addCard(d.dealSpecificCard("9", "Clubs"));
        straight.addCard(d.dealSpecificCard("10","Hearts"));

        System.out.println(straight);
        System.out.println(straight.getHandRank());

        //Testing Check Straight Rank
        System.out.println("\u001B[31m******* Check Three of Kind Card ******\u001B[0m");
        Hand threeOfKind = new Hand();
        d = new Deck(true);
        threeOfKind.addCard(d.dealSpecificCard("2", "Diamonds"));
        threeOfKind.addCard(d.dealSpecificCard("2", "Spades"));
        threeOfKind.addCard(d.dealSpecificCard("3", "Hearts"));
        threeOfKind.addCard(d.dealSpecificCard("5", "Spades"));
        threeOfKind.addCard(d.dealSpecificCard("A","Clubs"));

        System.out.println(threeOfKind);
        System.out.println(threeOfKind.getHandRank());


    }
}
