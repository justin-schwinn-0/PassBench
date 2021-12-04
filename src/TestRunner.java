import java.io.BufferedReader;
import java.io.InputStreamReader;



public class TestRunner 
{
    public static Record runTest(char dt, String testtype, int iter, int trials,String name)
    {
       
        String[] args = new String[5];
        args[0] = "StressTest";//"C:\\Users\\Justin\\Desktop\\Fall 21\\CS projects\\CS3354Project\\benchmarker\\cs3354Project\\src\\StressTest";
        args[1] ="" + dt;
        args[2] = testtype;
        args[3] ="" + iter;
        args[4] ="" + trials;
       
        try 
        {
            Process p = Runtime.getRuntime().exec(args);
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder s = new  StringBuilder();
            String l;
            while((l = r.readLine()) != null)
            {
                s.append(l + "\n");
            }

            String temp = s.toString();

            String[] lines = temp.split("\n");

            return new Record(lines,name);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    
    }
}
