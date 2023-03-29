package Week2.Assignment;

import java.util.*;

class Book{
    SortedSet<String> book = new TreeSet<>();
    SortedSet<Integer> bookPrice=new TreeSet<>();

    void addBook(String bookName) {
        book.add(bookName);
    }
    void addBookPrice(int bookPr) {
        bookPrice.add(bookPr);
    }

    void showBook() {
        Iterator<String> itr = book.iterator();
        Iterator<Integer> itr1 = bookPrice.iterator();
        while (itr.hasNext()){
            System.out.println(" " + itr.next());
            System.out.println(" " + itr1.next());
        }
    }

    void removeBook() {
        System.out.println("Enter the name of book you want to remove:  ");
        Scanner sc = new Scanner(System.in);
        String bookName = sc.next();
        book.remove(bookName);
        System.out.println("The list of books after removal are: ");
        Iterator<String> itr = book.iterator();
        while (itr.hasNext()){
            System.out.println(" " + itr.next());
        }
    }
}
public class AssignmentOne {
    public static void main(String[] args) {
        Book bk = new Book();
        Scanner sc = new Scanner(System.in);
        int nob;
        System.out.println("Enter the number of books you want to maintain record of: ");
        nob = sc.nextInt();
        String[] bookName = new String[nob];
        int[] bookPrice=new int[nob];
        for (int i = 0; i < nob; i++) {
            System.out.println("Enter book name for: " + i);
            bookName[i] = sc.next();
            bookPrice[i]=sc.nextInt();
            bk.addBook(bookName[i]);
            bk.addBookPrice(bookPrice[i]);
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
