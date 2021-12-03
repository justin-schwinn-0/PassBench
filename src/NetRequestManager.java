import java.io.*;
import java.net.*;

public class NetRequestManager
{
    private Socket client;
    private String IP;
    private int port;
    private PrintWriter out;
    private BufferedReader in;

    public String sendRecord(Record r)
    {
        try 
        {
            connect();
            out.println("addR%"+r.toString());
            return in.readLine();
        } 
        catch (Exception e) 
        {
            //TODO: handle exception
        }

        return "Record sent!";
    }
    public void connect() throws Exception
    {
        client = new Socket(IP,port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
}