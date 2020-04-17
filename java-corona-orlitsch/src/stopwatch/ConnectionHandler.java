
package stopwatch;

import java.net.Socket;


public class ConnectionHandler extends Thread {
    
    private Socket socket;
    private boolean master;
    
    public ConnectionHandler (Socket socket){
        
    }
    
    public boolean isClosed() {
        return true;//um Fehlermeldung zu verhindern
    }
    
    public boolean isMaster() {
        return false; //um Fehlermeldung zu verhindern
    }
    
    
    @Override
    public void run(){
    
    
    }
    
}
