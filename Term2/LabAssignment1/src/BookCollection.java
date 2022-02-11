import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;


public class BookCollection {
    private  ArrayList<Book> books= new ArrayList<Book>();

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    public BookCollection(String path) {
            try{
                    Scanner scanner = new Scanner(new File(path));
                    String[] parameters = scanner.nextLine().trim().split(",");
                    while(scanner.hasNextLine()){
                        String[] booksInfo = scanner.nextLine().trim().split(",");
                        books.add(new Book(booksInfo[0], booksInfo[1], Long.parseLong(booksInfo[2]), Integer.parseInt(booksInfo[3]), Integer.parseInt(booksInfo[4]), Integer.parseInt(booksInfo[5])));
                    }

            }catch (FileNotFoundException ignored){
                System.out.println("\""+path+"\" File is not found");
            }catch (NoSuchElementException fileEmpty){
                System.out.println("\""+path+"\" Given File is Empty");
            }

    }

    //3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors(){

        // Create local Hashset object
        HashSet<String> authors = new HashSet<>();

        // get all authors from books
        for (Book book: books) {
            authors.add(book.getAuthor());
        }

        // return all authors from book
        return  authors;
    }

    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks(){
        ArrayList<Book> longBooks = new ArrayList<>();

        for (Book book: books) {
            if(book.getPages() > 750){
                longBooks.add(book);
            }
        }
        return  longBooks;
    }

    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title){
        for (Book book: books) {
            if(book.getTitle().equals(title)){
                return book;
            }
        }

        return null;
    }

    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular(){
        Book[] popularBooks = new Book[10];

        books.sort(new SortedBookByLoan());

        for (int i = 0; i < popularBooks.length; i++) {
            popularBooks[i] = books.get(i);
        }
        return popularBooks;
    }

}
