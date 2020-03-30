
package k22.k22_4.k22_4_3;

import java.util.Vector;


public class Consumer2213 extends Thread{
    private Vector v;
    
    public Consumer2213 (Vector v){
        this.v = v;
    }
    
    public void run(){
        while (true) {
            synchronized(v) {
                if(v.size() < 1){
                    try {
                        v.wait();
                    } catch (InterruptedException e){
                        //nichts
                    }
                }
                System.out.println(" Konsument fand " + (String)v.elementAt(0));
                v.removeElementAt(0);
                System.out.println(" (verbleiben: "+v.size()+")");
            }
            try {
                Thread.sleep((int)(100*Math.random()));
            } catch (InterruptedException e) {
                //nichts
            }
        }
    }  
}
