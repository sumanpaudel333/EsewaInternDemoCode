package Week3;

public class ThreadDemo extends Thread{
   @Override
    public void run(){
        for (int i=0;i<10;i++){
            System.out.println("Child Thread");
        }
    }
}
class MainThreadDemo{
    public static void main(String[] args) {
        ThreadDemo th=new ThreadDemo();
        th.start();
        for (int i=0;i<10;i++){
            System.out.println("Main Thread");
        }
    }
}