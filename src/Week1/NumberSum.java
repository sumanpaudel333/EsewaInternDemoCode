package Week1;

public class NumberSum {
    public static void main(String[] args) {
        int count=0,i=0;
        while (i<=10){
            count=count+i;
            i=++i;
        }
        System.out.println("The sum of numbers from 1 to 10 is: "+count);
    }
}
