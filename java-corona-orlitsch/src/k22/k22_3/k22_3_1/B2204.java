
package k22.k22_3.k22_3_1;


public class B2204 extends A2204 implements Runnable{

   public void run() {
       int i = 0;
       while (true){
           if(Thread.interrupted()){
               break;
           }
           System.out.println(i++);
       } 
   }   
}
