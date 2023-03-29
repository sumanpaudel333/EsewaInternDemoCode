package Week2;

public class ThreadLambdaDemo {
    public static void main(String[] args) {
        Runnable thread1=()->{
          for (int i=0;i<=10;i++){
              System.out.println("The value of i is: "+i);
          try {
              Thread.sleep(1000);
          }
          catch (InterruptedException e){
              e.printStackTrace();
          }
          }
          };
        Thread th=new Thread(thread1);
        th.start();

        Runnable thread2=()->{
          try{
              for (int i=1;i<=10;i++){
                  System.out.println("2 X "+i+" ="+i*2);
                  Thread.sleep(2000);
              }
          }
          catch (InterruptedException e){
              e.printStackTrace();
          }
        };
        Thread t2=new Thread(thread2);
        t2.start();
    }
}
