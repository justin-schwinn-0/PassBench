import java.io.File;
import java.io.FileWriter;

public class LocalDataManager 
{

    public static void save(String name,Record r)
    {
        try (FileWriter wr = new FileWriter(new File(name))) 
        {
            wr.append(r.cpu);
            wr.append("\n");
            wr.append(r.user);
            wr.append("\n");
            wr.append(r.dataType);
            wr.append("\n");
            wr.append(r.testType);
            wr.append("\n");
            wr.append(r.perf);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
