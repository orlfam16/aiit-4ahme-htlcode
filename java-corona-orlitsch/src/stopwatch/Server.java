
package stopwatch;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    
    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
    
    public Server() {}
    
    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        timeOffset = 0;
        
        while(true){
            final Socket clientSocket = serverSocket.accept();
            //Überprüfen welche Handler geschlossen sind
            
            if (handlers.size() < 3){
                final ConnectionHandler handler = new ConnectionHandler(clientSocket);   
                new Thread(handler).start(); //hintergrund Thread
                handlers.add(handler);
            } else {
                clientSocket.close();
            }
            
        } 
    }
    
    public boolean isTimeRunning(){
        return startMillis > 0;
    }
    
    public long getTimeMillis(){
        if(startMillis == 0){
            return timeOffset;
        } else{
            return (System.currentTimeMillis() - startMillis) + timeOffset;
        }
    }
    
    //---------------------------------------------------------------------------
    
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(8080);
    }
    
    //---------------------------------------------------------------------------
    
    private class ConnectionHandler extends Thread {
    
        private Socket socket;
        private boolean master;
    
        public ConnectionHandler (Socket socket){
            this.socket = socket;
        }
    
        public boolean isClosed() {
            return socket.isClosed();
        }
    
        public boolean isMaster() {
            return master;
        }
    
    
        @Override
        public void run(){ //für die Hintergrundthreads
            
            try{
                while(true){
                    final BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));

                    final String line = reader.readLine(); //Zeichen werden in line gespeichert 

                    final Gson gson = new Gson();
                    gson.toJson(line);//die neuen Zeilen werden in ein Objekt gespeichert

                    final Request r = gson.fromJson(line, Request.class); //neues Request Objekt, welches die Zeichen beinhaltet


                    if(r.isMaster()){
                        for(ConnectionHandler c : handlers){
                            master = true;
                            if(c != this && c.isMaster() == true){
                                master = false;
                                break;
                            }
                        }
                    }

                    if (r.isStart()){
                        startMillis = System.currentTimeMillis();
                    }

                    if (r.isClear()){
                        if(isTimeRunning()){
                            startMillis = System.currentTimeMillis();
                        }

                        timeOffset = 0;
                    }

                    if(r.isStop()){
                        timeOffset = getTimeMillis();
                        startMillis = 0;
                    }

                    if (r.isEnd()){

                        handlers.remove(this);
                        //ServerApplication schließen
                    }
                }
            } catch(Exception ex){
                ex.printStackTrace();
            } 
        }
    }
    
    //--------------------------------------------------------------------------
    
    public class Request{
        
        public Boolean master;
        public Boolean start;
        public Boolean stop;
        public Boolean clear;
        public Boolean end;
        
        
        public boolean isMaster(){
            return master;
        }
        
        public boolean isStart(){
            return start;
        }
        
        public boolean isStop(){
            return stop;
        }
        
        public boolean isClear(){
            return clear;
        }
        
        public boolean isEnd(){
            return end;
        }

        public void setMaster(Boolean master) {
            this.master = master;
        }

        public void setStart(Boolean start) {
            this.start = start;
        }

        public void setStop(Boolean stop) {
            this.stop = stop;
        }

        public void setClear(Boolean clear) {
            this.clear = clear;
        }

        public void setEnd(Boolean end) {
            this.end = end;
        }

        public Boolean getMaster() {
            return master;
        }

        public Boolean getStart() {
            return start;
        }

        public Boolean getStop() {
            return stop;
        }

        public Boolean getClear() {
            return clear;
        }

        public Boolean getEnd() {
            return end;
        }  
    }
    
    //--------------------------------------------------------------------------
    
    public class Response{
        
        public Boolean master;
        public Long count;
        public Boolean running;
        public Long time;
        
        
        
    }
    
    
    
}



