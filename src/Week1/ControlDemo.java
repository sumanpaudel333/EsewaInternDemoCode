package Week1;

import java.util.Scanner;

public class ControlDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your grade: ");
        char grade = sc.next().charAt(0);
        switch (grade) {
            case 'A':
                System.out.println("Well Done");
                break;
            case 'B':
            case 'C':
                System.out.println("You Passed");
                break;
            case 'D':
                System.out.println("You passed");
            case 'E':
                System.out.println("Better try again");
                break;
            default:
                System.out.println("Invalid Grade");
        }
        System.out.println("Your grade is: " + grade);
    }
}
