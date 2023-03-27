package Week2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Book {
    List<String> book = new LinkedList<>();


    void addBook(String bookName) {
        book.add(bookName);
    }

    void showBook() {
        Iterator<String> itr = book.iterator();
        for (String i : book) {
            System.out.println(" " + itr.next());
        }
    }

    void removeBook() {
        System.out.println("Enter the name of book you want to remove: ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.next();
        book.remove(bookName);
        System.out.println("The list of books after removal are: ");
        Iterator<String> itr = book.iterator();
        for (String i : book) {
            System.out.println(" " + itr.next());
        }
    }
}

public class ListDemo {
    public static void main(String[] args) {
        Book bk = new Book();
        Scanner sc = new Scanner(System.in);
        int nob;
        System.out.println("Enter the number of books you want to maintain record of: ");
        nob = sc.nextInt();
        String[] bookName = new String[nob];
        for (int i = 0; i < nob; i++) {
            System.out.println("Enter book name for: " + i);
            bookName[i] = sc.next();
            bk.addBook(bookName[i]);
        }
        bk.showBook();
        System.out.println("Do you want to remove any books?(Y/N)");
        String dec;
        dec = sc.next().toUpperCase();
        if (dec.equalsIgnoreCase("Y")) {
            bk.removeBook();
        } else if (dec.equalsIgnoreCase("N")) {
            System.out.println("Thank You!");
        } else {
            System.out.println("Invalid Keyword");
        }
    }
}
