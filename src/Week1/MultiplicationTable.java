package Week1;

import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
        System.out.println("Enter a number to generate a multiplication table: ");
        int num= sc.nextInt();
        System.out.println("The multiplication table for "+num+" is: ");
        for (int i=1;i<=10;i++){
            System.out.println(num+" X "+i+" = "+(num*i));
        }
    }
}
