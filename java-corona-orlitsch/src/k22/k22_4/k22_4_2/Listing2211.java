
package k22.k22_4.k22_4_2;


public class Listing2211 extends Thread{
    
    private String name;
    private Counter2211 counter;
    
    public Listing2211(String name, Counter2211 counter){
        this.name = name;
        this.counter = counter;
    }
    
    public static void main(String[] args) {
        Thread[] t = new Thread[5];
        Counter2211 cnt = new Counter2211(10);
        for (int i = 0; i < 5; i++){
            t[i] = new Listing2211("Thread-" + i, cnt);
            t[i].start();
        }
    }
    
    public void run(){
        while (true) {
            System.out.println(counter.nextNumber() + " for " + name);
        }
    }
}
