
package k22.k22_4.k22_4_3;

import java.util.Vector;


public class Listing2213 {
    
    public static void main(String[] args) {
        
        Vector v = new Vector();
        
        Producer2213 p = new Producer2213(v);
        Consumer2213 c = new Consumer2213(v);
        p.start();
        c.start();
    }
}
