package Week2;

import java.util.Scanner;

class MyException extends Exception{
    @Override
    public String getMessage() {
        return "This is custom exception";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
public class ExceptionHandleDemo {
    public static void main(String[] args) {
        int a;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        a=sc.nextInt();
        if (a<100){
            try {
                throw new MyException();
            }
            catch (MyException e){
                System.out.println(e.getMessage());
            }
            }
        else {
            System.out.println("You have entered a valid number");
        }
    }
}
