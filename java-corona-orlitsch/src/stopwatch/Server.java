
package stopwatch;

import com.google.gson.Gson;
import com.google.gson.internal.Streams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        startMillis = 0;
        
        while(true){
            final Socket clientSocket = serverSocket.accept();
            for(ConnectionHandler h: handlers){
                if(h.isClosed()){
                    handlers.remove(h);
                }
            }
            
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
            long count = 0;
            
            try{
                while(true){
                    final BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                    final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                    final String line = reader.readLine(); //Zeichen werden in line gespeichert 
                    
                    if(line == null){
                        socket.close();
                        return;
                    }
                    
                    count++;
                    
                    final Gson gson = new Gson();
                    gson.toJson(line);//die neuen Zeilen werden in ein Objekt gespeichert
                    System.out.println(line);
                    final Request req = gson.fromJson(line, Request.class); //neues Request Objekt, welches die Zeichen beinhaltet
                    System.out.println(req);
                    
                    
                    if(req.isMaster()){
                        master = true;
                        for(ConnectionHandler c : handlers){
                            if(c != this && c.isMaster() == true){
                                master = false;
                                //response zurücksenden--------------------------
                                break;
                            }
                        }
                    }
                    if(master){
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
                            //Server schließen-----------------------------
                            serverSocket.close();
                            socket.close();
                            return;
                        }
                    }
                
                    //Response
                    final Response resp = new Response(master, count, isTimeRunning(), getTimeMillis());
                    System.out.println(resp);
                    final String respString = gson.toJson(resp);
                    System.out.println(respString);
                    writer.write(respString);
                    writer.flush();
               
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
            return master != null && master;
        }
        
        public boolean isStart(){
            return start != null && start;
        }
        
        public boolean isStop(){
            return stop != null && stop;
        }
        
        public boolean isClear(){
            return clear != null && clear;
        }
        
        public boolean isEnd(){
            return end != null && end;
        }

        @Override
        public String toString() {
            return "Request{" + "master=" + master + ", start=" + start + ", stop=" + stop + ", clear=" + clear + ", end=" + end + '}';
        }
        
        
    }
    
    //--------------------------------------------------------------------------
    
    public class Response{
        
        public Boolean master;
        public Long count;
        public Boolean running;
        public Long time;

        private Response(boolean master, Long count, boolean timeRunning, long timeMillis) {
            this.master = master;
            this.count = count;
            this.time = timeMillis;
            this.running = timeRunning;
            
        }
        

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

        @Override
        public String toString() {
            return "Response{" + "master=" + master + ", count=" + count + ", running=" + running + ", time=" + time + '}';
        }
        
    }
}



