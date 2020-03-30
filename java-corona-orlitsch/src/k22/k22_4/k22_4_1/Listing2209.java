package k22.k22_4.k22_4_1;

public class Listing2209 extends Thread {
    
    static int cnt = 0;
    
    public static void main(String[] args) {
        Thread t1 = new Listing2209();
        Thread t2 = new Listing2209();
        
        t1.start();
        t2.start();
    }
    
    public void run(){
        
        while(true){
            System.out.println(cnt++);
        }
    } 
}
