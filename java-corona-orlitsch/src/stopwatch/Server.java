
package stopwatch;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;


public class Server {
    
    private ServerSocket serverSocket;
    
    public Server() throws IOException {
    
    serverSocket = new ServerSocket(8080);
    
    }
    private final List<ConnectionHandler> handlers = new List<>();
    private long timeOffset;
    private long startMillis;
    
    public void start(int port){
    
    
    }
    
    public boolean isTimeRunning(){
        return false;
    }
    
    public long getTimeMillis(){
        return 100;
    }
    
    public static void main(String[] args) {
        
        new Server();
        
    }
    
}
