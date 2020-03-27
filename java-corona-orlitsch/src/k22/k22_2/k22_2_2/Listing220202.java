
package k22.k22_2.k22_2_2;


public class Listing220202 {
    
    public static void main (String[] args){
        MyThread220202 t = new MyThread220202();
       // Thread started
        t.start(); 
        
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            //nichts
        }
        //deprecated
        t.stop();
    }
    
}
