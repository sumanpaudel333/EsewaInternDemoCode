package Week3;

public class ThreadDemo extends Thread {
    String threadName;
    Thread t;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating thread: " + name);
    }

    @Override
    public void run() {
        System.out.println("Running Thread");
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside Thread: "+threadName+" "+i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start() {
        System.out.println("Starting Thread: ");
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class MainThreadDemo {
    public static void main(String[] args) {
        ThreadDemo th = new ThreadDemo("My Thread");
        th.start();
        ThreadDemo th1 = new ThreadDemo("My Thread-1");
        th1.start();
    }
}