package Week3;

public class Producer extends Thread{
    Company c;
    Producer(Company c){
        this.c=c;
    }
    public void run(){
        int i=0;
        while (true){
            try {
                this.c.produced_item(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            i++;
        }
    }
}
