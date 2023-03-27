package Week1;

public class ContinueDemo {
    public static void main(String[] args){
        int[] integerArr={10,20,30,40,50};
        for (int x:integerArr){
            if(x==30){
                continue;
            }
            System.out.println(x);
        }

        }
    }
