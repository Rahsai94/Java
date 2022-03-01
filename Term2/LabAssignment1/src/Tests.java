import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tests {
    private static final String[] ranks = {"Royal Flush", "Straight Flush", "4-of-a-kind", "Full House", "Flush", "Straight",
            "3-of-a-kind", "2 Pair", "1 Pair", "High Card"};

    private static final String[] authors = {"Clement Clarke Moore"," John Camden Hotten"," John Locke"," Thomas Hobbes",
            " Niccolò Machiavelli"," L. Frank Baum"," Michel de Montaigne"," Charlotte Perkins Gilman"," Ayn Rand"," Kate Chopin",
            " Unknown"," Charlotte Brontë"," Timothy Dexter"," Louisa May Alcott"," Plato"," Herman Melville"," Ludwig Wittgenstein",
            " F. Scott Fitzgerald"," Oscar Wilde"," A. A. Milne"," J. M. Barrie"," James Joyce"," Arthur Conan Doyle"," Rudyard Kipling",
            " Lewis Carroll"," Mark Twain"," Voltaire"," Frances Hodgson Burnett"," Franz Kafka"," Washington Irving"," Jonathan Swift",
            " Jacob Grimm and Wilhelm Grimm"," Jack London"," Jane Austen"," Harriet Beecher Stowe"," Henry David Thoreau"," Agatha Christie",
            " Edgar Allan Poe"," Henrik Ibsen"," Jules Verne"," Emperor of Rome Marcus Aurelius"," Bishop of Hippo Saint Augustine",
            " Nathaniel Hawthorne"," Benjamin Franklin"," Anonymous"," Friedrich Wilhelm Nietzsche"," Dante"," United States. Office of Strategic Services",
            " Chauncey Brewster Tinker"," Vatsyayana"," L. M. Montgomery"," Leon Kuperman"," Victor Hugo"," Charles Dickens"," Hermann Hesse",
            " Henry James"," W. E. B. Du Bois"," H. G. Wells"," Philip K. Dick"," Alexandre Dumas"," Frederick Douglass"," José Rizal",
            " Mary Wollstonecraft Shelley"," graf Leo Tolstoy"," Fyodor Dostoyevsky"," Kahlil Gibran"," Silvanus P. Thompson",
            " Miguel de Cervantes Saavedra"," Edith Wharton"," Friedrich Engels and Karl Marx"," Bram Stoker"," Robert Louis Stevenson",
            " Joseph Conrad"," Emily Brontë"," Upton Sinclair"," Homer"," Bernard Shaw"," None"," Alice Mabel Bacon"};

    private static final String[] longBooks = {"Frankenstein; Or The Modern Prometheus","A Christmas Carol in Prose; Being a Ghost Story of Christmas",
            "Alice's Adventures in Wonderland","The Scarlet Letter","A Tale of Two Cities","A Modest Proposal",
            "Crime and Punishment","The Strange Case of Dr. Jekyll and Mr. Hyde","Grimms' Fairy Tales",
            "Metamorphosis","Heart of Darkness","Tractatus Logico-Philosophicus","The Count of Monte Cristo Illustrated",
            "Simple Sabotage Field Manual","Don Quixote","Anna Karenina","Wuthering Heights","The Wonderful Wizard of Oz",
            "The Time Machine","Peter Pan","Leviathan","Narrative of the Life of Frederick Douglass an American Slave",
            "Beowulf: An Anglo-Saxon Epic Poem","Essays of Michel de Montaigne — Complete","Emma","David Copperfield",
            "Japanese Girls and Women","Candide","Korean—English Dictionary","Sense and Sensibility",
            "The Translations of Beowulf: A Critical Bibliography","A Pickle for the Knowing Ones","The Jungle Book",
            "Autobiography of Benjamin Franklin","Pygmalion","The Secret Garden","The Works of Edgar Allan Poe — Volume 2",
            "Ethan Frome","The Legend of Sleepy Hollow"};

    public static void main(String[] args) {

        testBooks();
        testCards();

    }

    public static void testBooks(){
        BookCollection bCollection = new BookCollection("BookList.csv");
        HashSet<String> authorsCorrect = new HashSet<String>(Arrays.asList(authors));
        System.out.println("\nAuthors:");
        System.out.println("Answer Authors: \n" + bCollection.getAuthors());

        if(authorsCorrect.size() == bCollection.getAuthors().size()) {
            System.out.println("Authors set is correct length!");
        }
        else{
            System.out.println("Authors length is not correct, investigate further");
        }

        System.out.println("\nLongs books:");
        ArrayList<Book> longBooksAnswer = bCollection.getLongBooks();

        for(Book b: longBooksAnswer){
            System.out.println(b.getTitle());
        }

        if(longBooksAnswer.size() == longBooks.length){
            System.out.println("\nLong books length is correct");
        }
        else{
            System.out.println("long books length is incorrect, investigate further");
        }

        for(String s: longBooks){
            boolean found = false;
            for(Book b: longBooksAnswer){
                if(s.equals(b.getTitle())){
                    found = true;
                }
            }
            if(!found){
                System.out.println("unable to find the book " + s + " in answer");
            }
        }

        System.out.println("\nbook by name:");
        System.out.println("found: "+ bCollection.getBookByTitle("Dracula").getTitle());
        System.out.println("found: " +bCollection.getBookByTitle("Metamorphosis").getTitle());
        System.out.println("found: " +bCollection.getBookByTitle("Peter Pan").getTitle());
        System.out.println("found: " +bCollection.getBookByTitle("Essays of Michel de Montaigne — Complete").getTitle());


        System.out.println("\npopular books:");
        Book[] pop =bCollection.mostPopular();
        for(Book b: pop){
            System.out.println(b.getTitle());
        }
    }
    public static void testCards(){
        HashMap<String, Integer> fails = new HashMap<>();
        String failingHands = "";

        for(String s: ranks){
            fails.put(s, 0);
        }

        HashMap<String, Integer> successes = new HashMap<>(fails);

        try{
            Scanner in = new Scanner(new File("testHands.txt"));
            while(in.hasNextLine()){
                String[] row = in.nextLine().split(",");
                Deck d = new Deck(true);
                Hand h = new Hand();

                for(int i = 1; i<row.length; i+=2){
                    h.addCard(d.dealSpecificCard(row[i], row[i+1]));
                }
                if(!row[0].equals(h.getHandRank())){
                    fails.put(row[0], fails.get(row[0])+1);
                    if(fails.get(row[0])  < 10){
                        failingHands += "Expected: " + row[0] + " Got: " + h.getHandRank() + " Hand:" + h + "\n";
                    }
                }
                else{
                    successes.put(row[0], successes.get(row[0])+1);
                }

            }

        }catch(FileNotFoundException fe){
            System.out.println("can't find file");
        }

        System.out.println("Failed Tests");
        System.out.println(fails);
        System.out.println(failingHands);

        System.out.println("successful tests");
        System.out.println(successes);
    }
}
