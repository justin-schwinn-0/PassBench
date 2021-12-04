

public class Record 
{
    String user;
    String cpu;
    String dataType;
    String testType;
    String perf;


    public Record(String[] args,String name)
    {
        if(args[0].charAt(0) == 'f')
            dataType = "Floating Point";
        else if(args[0].charAt(0) == 'i')
            dataType = "Integer";
        else
            dataType = "ERROR";

        char tt = args[1].charAt(0);

        switch(tt)
        {
            case 'a': testType = "Addition"; break;
            case 's': testType = "Subtraction"; break;
            case 'm': testType = "Multiplication"; break;
            case 'd': testType = "Division"; break;
            default: testType = "ERROR"; break;
        }

        perf = args[2];

        //TODO: Add users;

        user = name;

        cpu = System.getProperty("os.arch");

    }
    public String toString()
    {
        return user +"::"+ cpu +"::"+ dataType +"::"+ testType+"::"+ perf;
    }
    public String print()
    {
        return user +"\n"+ cpu +"\n"+ dataType +"\n"+ testType+"\n"+ perf;
    }
}
