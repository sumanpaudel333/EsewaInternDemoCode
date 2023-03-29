package Week2.Assignment;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

class BookSort implements Comparable<BookSort> {

    private String bookName;
    private int bookPrice;
    private int bookId;

    @Override
    public int compareTo(BookSort o) {
        return this.bookPrice-o.bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookSort(String bookName, int bookPrice, int bookId) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookId = bookId;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookSort{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookId=" + bookId +
                '}';
    }
}

public class AssignmentTwo {
    public static void main(String[] args) {
        SortedSet<BookSort> bookDetail = new TreeSet<>();
        bookDetail.add(new BookSort("Java", 567, 1));
        bookDetail.add(new BookSort("PHP", 900, 2));
        bookDetail.add(new BookSort("C++", 780, 3));
        Iterator<BookSort> itr= bookDetail.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
