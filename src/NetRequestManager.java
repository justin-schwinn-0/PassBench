import java.io.*;
import java.net.*;

public class NetRequestManager
{
    private static Socket client;
    private static String IP = "173.172.0.219";
    private static int port =  25565;
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

        return "something bad";
    }
    public static String addUserAttempt(String username, String password, String p2)
    {
        try 
        {
            String result = InputValidator.validCreateUser(username, password, p2);
            if(result.compareTo("") == 0)
            {
                connect();
                out.println("addU%"+username+"::"+password);
                return in.readLine();
            }
            else
                return result;
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }

        return "Account creation error";
    }
    public static String LoginUser(String username, String password)
    {
        try 
        {
            String r = InputValidator.validLogin(username, password);
            if(r.compareTo("") == 0)
            {
                connect();
                out.println("logU%"+username+"::"+password);
                return in.readLine();
            }
            else
            {
                return r;
            }
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }
        return "Login error";

    }
    public static void connect() throws Exception
    {
        client = new Socket(IP,port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
}