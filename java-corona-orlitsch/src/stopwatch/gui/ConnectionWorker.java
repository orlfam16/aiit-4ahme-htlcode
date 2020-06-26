package stopwatch.gui;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.SwingWorker;
import java.util.List;
import stopwatch.Server;
import stopwatch.Server.Response;

public class ConnectionWorker extends SwingWorker<String, Response> {

    private Socket socket;
    private Response resp;

    @Override
    protected void process(List<Response> chunks) {
        super.process(chunks); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String doInBackground() throws Exception {
        final Gson g = new Gson();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());

        while (true) {
            try {
                final Server.Request req = g.fromJson(reader.readLine(), Server.Request.class);
                //final Request req = new Request();
                final String reqString = g.toJson(req);
                writer.write(reqString);
                writer.flush();

                final String respString = reader.readLine();
                final Response resp = g.fromJson(respString, Response.class);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

//        System.out.println("Do in Background " + Thread.currentThread().getId());
//        Thread.sleep(1000);
//
//        publish(1);
//
//        Thread.sleep(1000);
//
//        publish(2);
//
//        Thread.sleep(1000);
    }
}
