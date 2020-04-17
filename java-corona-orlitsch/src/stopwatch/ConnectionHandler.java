
package stopwatch;

import java.net.Socket;


public class ConnectionHandler extends Thread {
    
    private Socket socket;
    private boolean master;
    
    public ConnectionHandler (Socket socket){
        
    }
    
    public boolean isClosed() {
        return true;
    }
    
    public boolean isMaster() {
        return true;
    }
    
    
    @Override
    public void run(){
    
    
    }
    
}
