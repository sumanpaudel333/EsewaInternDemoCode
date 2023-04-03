package Week3;

public class ThreadImplementationRunnable implements Runnable{

    String threadName;
    private Thread t;

    ThreadImplementationRunnable(String name){
        threadName=name;
        System.out.println("Creating Thread: "+name);
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("Child Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void start(){
        System.out.println("Starting Thread: "+threadName);
        if (t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
class ThreadMain{
    public static void main(String[] args) throws InterruptedException {
        ThreadImplementationRunnable thr=new ThreadImplementationRunnable("My thread");
        thr.start();
        for (int i=0;i<10;i++){
            System.out.println("Main Thread");
            Thread.sleep(2000);
        }
    }
}
