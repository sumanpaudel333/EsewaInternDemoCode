package Week3;

class TGroupDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class ThreadGroupDemo{
    public static void main(String[] args) {
        TGroupDemo tg=new TGroupDemo();
        ThreadGroup tg1=new ThreadGroup("Parent thread group");
        Thread t1=new Thread(tg1,tg,"Thread-1");
        t1.start();
        Thread t2=new Thread(tg1,tg,"Thread-2");
        t2.start();
        Thread t3=new Thread(tg1,tg,"Thread-3");
        t3.start();
        t2.setPriority(1);
        System.out.println("The thread group for the defined threads are: "+tg1.getName());
        tg1.list();
    }
}
