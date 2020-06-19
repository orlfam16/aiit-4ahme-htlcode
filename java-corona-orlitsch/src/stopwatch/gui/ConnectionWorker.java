package stopwatch.gui;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.net.Socket;
import javax.swing.SwingWorker;
import stopwatch.Server.Request;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import stopwatch.Server.Response;

public class ConnectionWorker extends SwingWorker<String, Response> {

    private Socket socket;

    @Override
    protected void process(List<Response> chunks) {
        super.process(chunks); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String doInBackground() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
