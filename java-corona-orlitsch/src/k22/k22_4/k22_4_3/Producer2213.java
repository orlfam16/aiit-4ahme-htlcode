package k22.k22_4.k22_4_3;

import java.util.Vector;


public class Producer2213 extends Thread{
    
    public Vector v;
    
    public Producer2213(Vector v) {
       this.v = v; 
    }
    
    public void run(){
        String s;
        
        while (true) {
            synchronized (v) {
                s = "Wert " + Math.random();
                v.addElement(s);
                System.out.println("Produzent erzeugt " + s);
                v.notify();
            }
            try {
                Thread.sleep((int)(100 * Math.random()));
            } catch (InterruptedException e) {
                //nichts
            }
        }
    }  
}
