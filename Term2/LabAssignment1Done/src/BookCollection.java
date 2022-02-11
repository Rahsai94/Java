import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;


public class BookCollection {
    private  ArrayList<Book> books= new ArrayList<Book>();

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    BookCollection(String path) {

    }

    //3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors(){

    }

    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks(){

    }

    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title){

    }

    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular(){

    }

}
