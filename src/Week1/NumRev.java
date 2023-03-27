package Week1;

import java.util.Scanner;
public class NumRev {
   static int reverse(int num){
        int a=num;
        int rev=0;
        int rem;
        while (a!=0){
            rem=a%10;
            a=a/10;
            rev=rev*10+rem;
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number to reverse: ");
        int num=sc.nextInt();
        System.out.println(NumRev.reverse(num));
    }
}
