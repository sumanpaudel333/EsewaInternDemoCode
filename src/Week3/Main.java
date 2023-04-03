package Week3;

public class Main {
    public static void main(String[] args) {
        Company c=new Company();
        Producer producer=new Producer(c);
        Consumer consumer=new Consumer(c);
        producer.start();
        consumer.start();
        Thread.currentThread().setPriority(1);
        System.out.println(Thread.currentThread().getPriority());
    }
}
