package Week3;

public class Company {
    int n;
    boolean f = false;

    synchronized public void produced_item(int n) throws InterruptedException {
        if (f) {
            wait();
        }
        this.n = n;
        System.out.println("Produced: " + n);
        f = true;
        notify();
    }

    synchronized public int consume_item() throws InterruptedException {
        if (!f) {
            wait();
        }
        System.out.println("Consumed: " + this.n);
        f = false;
        notify();
        return this.n;
    }
}
