import java.io.*;
import java.net.*;

public class NetRequestManager
{
    private static Socket client;
    private static String IP = "173.172.0.219";
    private static int port = 7845;
    private static PrintWriter out;
    private static BufferedReader in;

    public static String sendRecord(Record r)
    {
        try 
        {
            connect();
            out.println("addR%"+r.toString());
            return in.readLine();
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }

        return "Record sent!";
    }
    public static void connect() throws Exception
    {
        client = new Socket(IP,port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
}