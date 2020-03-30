
package k22.k22_4.k22_4_4;

import java.io.IOException;
import java.io.PipedInputStream;


public class Consumer2214 extends Thread {
    
    private PipedInputStream pipe;

    public Consumer2214(PipedInputStream inPipe) {
        this.pipe = pipe;
    }
    
    public void run() {
        while (true) {
            try{
                byte b = (byte)pipe.read();
                System.out.println(" Konsument fand " + b);
            } catch (IOException e) {
                System.err.println(e.toString());
            }
            try {
                Thread.sleep((int)(100 * Math.random()));
            } catch (InterruptedException e) {
                //nichts
            }
        }
    } 
}
