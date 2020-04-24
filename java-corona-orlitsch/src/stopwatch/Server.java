
package stopwatch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    
    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
    
    public Server() {
    }
    
    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        timeOffset = 0;
        
        while(true){
            final Socket clientSocket = serverSocket.accept();
            final ConnectionHandler h = new ConnectionHandler(clientSocket);   
            handlers.add(h);
        } 
    }
    
    public boolean isTimeRunning(){
        return startMillis > 0;
    }
    
    public long getTimeMillis(){
        return timeOffset;
    }
    
    //---------------------------------------------------------------------------
    
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(8080);
    }
    
    //---------------------------------------------------------------------------
    
    public class ConnectionHandler extends Thread {
    
        private Socket socket;
        private boolean master;
    
        public ConnectionHandler (Socket socket){
            this.socket = socket;
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
}



