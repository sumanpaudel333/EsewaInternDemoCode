package Week1;

public class ExceptionDemo {
    public static void main(String[] args) {
       /* try {
            int a=100/0;
            System.out.println("Block inside exception part"+a);
        }
        catch (ArithmeticException e){
            System.out.println("Could not proceed your request: "+e);
        }*/
        try{
            int[] num={1,2,3,4,5};
            System.out.println(num[3]);
            int m=100/0;
            System.out.println(m);
        }
        catch (ArrayIndexOutOfBoundsException | ArithmeticException e){
            System.out.println("Could not proceed "+e);
        }
        }
    }

