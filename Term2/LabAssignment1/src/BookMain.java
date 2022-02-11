import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BookMain {
    public static void main(String[] args) {

        System.out.println("\n\u001B[31m***** Exception's *******\u001B[0m");
        //Testing Empty File
        BookCollection emptyFileTest = new BookCollection("emptyFile.csv");
        //Testing File with Wrong Name
        BookCollection wrongFileTest = new BookCollection("boo1kList.csv");

        //Create the bookCollection Object
        BookCollection bCollection = new BookCollection("BookList.csv");

        //Get Authors from Book Collection
        HashSet<String> authors = bCollection.getAuthors();
        System.out.println("\n\u001B[31m***** All Authors from Book Collection *******\u001B[0m");
        System.out.print(authors.toString());

        //Get Books which have over 750 Pages
        System.out.println("\n\u001B[31m***** All Books over 750 Pages *******\u001B[0m");
        ArrayList<Book> books = bCollection.getLongBooks();
        System.out.print(books.toString());

        //Get Book by Title
        System.out.println("\n\n\u001B[31m***** Get Book by Title 'Japanese Girls and Women' *******\u001B[0m");
        Book book = bCollection.getBookByTitle("Japanese Girls and Women");
        System.out.print(book.toString());

        //Get Book by wrong Title
        System.out.println("\n\n\u001B[31m***** Get Book by wrong Title 'Abc Japanese Girls and Women' *******\u001B[0m");
        Book wrongBook = bCollection.getBookByTitle("Abc Japanese Girls and Women");
        if(wrongBook == null){
            System.out.print("'Abc Japanese Girls and Women' Not Exist");
        }


        //Get 10 most Popular Books from BookCollection
        System.out.println("\n\n\u001B[31m***** Get 10 most Popular Books from BookCollection ******* \u001B[0m ");
        Book[] popularBooks = bCollection.mostPopular();
        System.out.println(Arrays.toString(popularBooks));
    }
}
