package Week2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Book{
    List<String> book=new LinkedList<>();
void addBook(String bookName){
    book.add(bookName);
}
void showBook(){
    Iterator<String> itr= book.iterator();
    for (String i:book) {

        System.out.println(" "+itr.next());
    }
    }
}
public class ListDemo {
    public static void main(String[] args) {
    Book bk=new Book();
        Scanner sc=new Scanner(System.in);
        int nob;
        System.out.println("Enter the number of books you want to maintain record of: ");
        nob=sc.nextInt();
        String[] bookName=new String[nob];
        for (int i=0;i<nob;i++){
            System.out.println("Enter book name for: "+i);
            bookName[i]=sc.next();
            bk.addBook(bookName[i]);
        }
        bk.showBook();
    }
}
