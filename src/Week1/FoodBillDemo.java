package Week1;

import java.util.Scanner;
import java.lang.Math;
public class FoodBillDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double mealPrice, tip, tax,tipOff;
        System.out.println("Enter meal price: ");
        mealPrice = sc.nextDouble();
        System.out.println("Enter the percentage number of tip: ");
        tip = sc.nextDouble();
        //demo
        System.out.println("Enter the percentage number of tax");
        tax = sc.nextDouble();
        double total;
        if (mealPrice >= 5000 && mealPrice <= 10000) {
            total = (mealPrice - 500) + ((tip / 100) * mealPrice) + ((tax / 100) * mealPrice);
            System.out.println("The total price after flat discount is: " + Math.round(total));
        } else if (mealPrice > 10000) {
            tip = ((tip / 100) * mealPrice);
            tipOff= ((double)20/100)*tip;
            tax= (tax/100) * mealPrice;
            total = ((mealPrice - 700)) + (tip - tipOff) + tax;
            System.out.println("The total meal price with flat discount and off is: " +  Math.round(total));
        } else {
            total = mealPrice + ((tip / 100) * mealPrice) + ((tax / 100) * mealPrice);
            System.out.println("The total price of meal is: " + Math.round(total));
        }
    }
}
//trying out