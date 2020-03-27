
package k22.k22_2.k22_2_2;


public class MyThread220202 extends Thread {
    
    @Override
    public void run (){
        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }
    
}

