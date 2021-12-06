import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Scanner;

import org.junit.*;

public class Tests
{
    @Test
    public void testRun() // Running this though JUNIT invariably causes working directory realted issues, this one will never pass but the stressTest works
    {
        TestRunner.filePath = "C:\\Users\\Justin\\Desktop\\Fall 21\\CS projects\\CS3354Project\\benchmarker\\cs3354Project\\src\\StressTest"; // hack to make it work on my machine

        Record r1 = TestRunner.runTest('i', "Addition", 100, 100,"name");
        Record r2 = TestRunner.runTest('f', "Addition", 100, 100,"name");
        Record r3 = TestRunner.runTest('i', "Subtraction", 100, 100,"name");
        Record r4 = TestRunner.runTest('i', "Multiplication", 100, 100,"name");
        Record r5 = TestRunner.runTest('i', "Division", 100, 100,"name");

        TestRunner.filePath = "StressTest";

        assertEquals("Integer", r1.dataType);
        assertEquals("Floating Point", r2.dataType);
        assertEquals("Addition", r2.testType);
        assertEquals("Subtraction", r3.testType);
        assertEquals("Multiplication", r4.testType);
        assertEquals("Division", r5.testType);

    }
    @Test
    public void testCreateAccount()
    {
        String r1 = NetRequestManager.addUserAttempt("tom", "password","password"); // bad username
        String r2 = NetRequestManager.addUserAttempt("tomasfasfasfsafasfsafasfasfsafsafasfasfasfasf", "password","password"); // bad username
        String r3 = NetRequestManager.addUserAttempt("thomas", "password","asdasdad"); // confirmatoin doesnt match
        String r4 = NetRequestManager.addUserAttempt("thomas", "password","password"); // successful creation
        String r5 = NetRequestManager.addUserAttempt("thomas", "saddasdsadsadasdasdsadasdsadasdasd","saddasdsadsadasdasdsadasdsadasdasd"); // bad password length
        String r6 = NetRequestManager.addUserAttempt("thomas", "a","a"); // bad password length
        String r7 = NetRequestManager.addUserAttempt("&*^*^*^$", "a","a"); // invalid characters in username
        String r8 = NetRequestManager.addUserAttempt("thomas", "%^*#%$^$%^&" , "%^*#%$^$%^&" ); // bad password characters

        assertEquals("bad username length, 5 <= N < 20", r1);
        assertEquals("bad username length, 5 <= N < 20", r2);

        assertEquals("Passwords do not match", r3);

        assertEquals("Username taken", r4);

        assertEquals("Bad passowrd length, 6 < N <24", r5);
        assertEquals("Bad passowrd length, 6 < N <24", r6);

        assertEquals("Invalid characters in username", r7);
        assertEquals("Invalid characters in Password", r8);
    }

    @Test
    public void testLogin()
    {
        String r1 = NetRequestManager.LoginUser("thomas", "password");
        String r2 = NetRequestManager.LoginUser("a", "b");
        String r3 = NetRequestManager.LoginUser("tim", "password");

        assertEquals("", r1);
        assertEquals("Wrong username or password", r2);
        assertEquals("Wrong username or password", r3);



    }
    @Test
    public void testSend()
    {
        TestRunner.filePath = "C:\\Users\\Justin\\Desktop\\Fall 21\\CS projects\\CS3354Project\\benchmarker\\cs3354Project\\src\\StressTest"; // hack to make it work on my machine

        Record r = TestRunner.runTest('f', "Addition", 100, 100,"REMOVE");

        TestRunner.filePath = "StressTest";

        String res = NetRequestManager.sendRecord(r);

        assertEquals("Record added", res);

    }
    @Test
    public void testSave()
    {
        String[] args = {"f","a","2.543e+08"};
        String fileName = "testSave.txt";
        Record r = new Record(args,"name");
        String[] lines = new String[0];
        LocalDataManager.save(fileName, r);

        try(Scanner reader = new Scanner(new File(fileName)))
        {
            StringBuilder s = new StringBuilder();
            while(reader.hasNextLine())
                s.append(reader.nextLine()+ "\n");

            lines = s.toString().split("\n");
        }
        catch(Exception e)
        {
            assertTrue(e.toString(), false);
        }

        assertEquals("Floating Point",lines[2]);
        assertEquals("Addition", lines[3]);
        assertTrue("Perf data error", Double.parseDouble(lines[4]) > 0);
    }

    public void testConfig()
    {
    /*runConfigChanger testConfig = new runConfigChanger("235.72.65.49", 10000, 100000, 3);
    runConfigChanger testConfig = new runConfigChanger("0", 10000, 100000, 3);
    runConfigChanger testConfig = new runConfigChanger("3", 10000, 100000, 3);
    runConfigChanger testConfig = new runConfigChanger("123456789012345", 10000, 100000, 3);
    runConfigChanger testConfig = new runConfigChanger("235.72.65.49", 65536, 100000, 3);
    runConfigChanger testConfig = new runConfigChanger("3", 0, 100000, 3);
    runConfigChanger testConfig = new runConfigChanger("235.72.65.49", 10000, 0, 3);
    runConfigChanger testConfig = new runConfigChanger("235.72.65.49", 0, 100000, 0);*/
    }

    public void testConf()
    {
    //runConf testConf = new runConf("somename");
    }
}