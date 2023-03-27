package Week1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataTypeDemo {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int input = sc.nextInt();
            if (input > Integer.MIN_VALUE && input < Integer.MAX_VALUE) {
                if (input >= Short.MIN_VALUE && input <= Short.MAX_VALUE) {
                    if (input >= Byte.MIN_VALUE && input <= Byte.MAX_VALUE) {
                        System.out.println(input + " can be fitted in long,int,short and byte and byte is prefer");
                    } else {
                        System.out.println(input + " can be fitted in long,int and short and short is prefer");
                    }
                } else {
                    System.out.println(input + " can be fitted in long and int and int is prefer");
                }
            } else {
                System.out.println(input + "can be fitted in long");
            }

        } catch (InputMismatchException e) {
            System.out.println("cannot be fitted anywhere");
        }
    }
}