package Week2;

import java.util.Scanner;

class NegativeRadiusException extends Exception{
    @Override
    public String getMessage() {
        return "Negative number is not allowed in radius";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
public class ThrowDemo {
    public static double exceptionThrow(int r) throws NegativeRadiusException{
        double area;
        if (r<0){
           throw new NegativeRadiusException();
       }
           area = Math.PI * r * r;
        return area;
    }

    public static void main(String[] args) {
        int r;
        System.out.println("Enter a radius of circle");
        Scanner sc=new Scanner(System.in);
        r= sc.nextInt();
        try {
            System.out.println(exceptionThrow(r));
        }
        catch (NegativeRadiusException e){
            System.out.println(e.getMessage());
        }
    }
}
