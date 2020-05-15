
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
    public Long count;
    
    public Server() {}
    
    public void start(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        timeOffset = 0;
        
        while(true){
            final Socket clientSocket = serverSocket.accept();
            //Überprüfen welche Handler geschlossen sind-------------------------
            
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
                    final Request req = gson.fromJson(line, Request.class); //neues Request Objekt, welches die Zeichen beinhaltet
                    
                    Gson gsonrsp = new Gson();
                    Response rsp = gsonrsp.fromJson(line, Response.class);//neues Response Objekt wird erstellt
                    count++;
                    rsp.setCount(count);


                    if(req.isMaster()){
                        for(ConnectionHandler c : handlers){
                            master = true;
                            if(c != this && c.isMaster() == true){
                                master = false;
                                //response zurücksenden--------------------------
                                break;
                            }
                        }
                    }

                    if (req.isStart()){
                        startMillis = System.currentTimeMillis();
                    }

                    if (req.isClear()){
                        if(isTimeRunning()){
                            startMillis = System.currentTimeMillis();
                        }

                        timeOffset = 0;
                    }

                    if(req.isStop()){
                        timeOffset = getTimeMillis();
                        startMillis = 0;
                    }

                    if (req.isEnd()){

                        handlers.remove(this);
                        //ServerApplication schließen-----------------------------
                        serverSocket.close();
                    }
                }
            } catch(Exception ex){
                ex.printStackTrace();
                try{
                    socket.close();
                } catch(Exception ex1){
                        socket.isClosed();
                    }
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
        

        public Boolean isMaster() {
            return master;
        }
        
        public Boolean isRunning() {
            return running;
        }

        public Long getCount() {
            return count;
        }

        public Long getTime() {
            return time;
        }

        public void setMaster(Boolean master) {
            this.master = master;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public void setRunning(Boolean running) {
            this.running = running;
        }

        public void setTime(Long time) {
            this.time = time;
        }
    }
}



