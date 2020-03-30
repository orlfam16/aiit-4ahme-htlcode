package k22.k22_4.k22_4_4;

import java.io.IOException;
import java.io.PipedOutputStream;


public class Producer2214 extends Thread{
    
    private PipedOutputStream pipe;
    
    public Producer2214(PipedOutputStream pipe) {
        this.pipe = pipe;
    }
    
    public void run(){
        while (true) {
            byte b = (byte)(Math.random() * 128);
            try{
                pipe.write(b);
                System.out.println("Produzent erzeugte " + b);
            } catch (IOException e) {
                System.err.println(e.toString());
            }
            try {
                Thread.sleep((int)(100*Math.random()));
            } catch (InterruptedException e){
                //nichts
            }
        }
    }
}
