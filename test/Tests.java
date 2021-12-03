import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.xml.namespace.QName;

import org.junit.*;

public class Tests
{
    @Test
    public void testRun() // Runnign this though JUNIT invariably causes working directory realted issues, this one will never pass but the stressTest works
    {
        Record r1 = TestRunner.runTest('i', "Addition", 100, 100);
        Record r2 = TestRunner.runTest('f', "Addition", 100, 100);
        Record r3 = TestRunner.runTest('i', "Subtraction", 100, 100);
        Record r4 = TestRunner.runTest('i', "Multiplication", 100, 100);
        Record r5 = TestRunner.runTest('i', "Division", 100, 100);

        assertEquals("Integer", r1.dataType);
        assertEquals("Floating Point", r2.dataType);
        assertEquals("Addition", r2.testType);
        assertEquals("Subtraction", r3.testType);
        assertEquals("Multiplication", r4.testType);
        assertEquals("Division", r5.testType);

    }

    public void testLogin()
    {
    //runLogin testingLogin = new runLogin("myUsername", "Password1!");
    //testingLogin = new runLogin("myUsername", "abc");
    }

    public void testButton()
    {
    //runButton testButton = new runButton(1);    
    }

    public void testSend()
    {
    //runSend testSend = new runSend("I7-8650U", "71.7.151.36");
    //runSend testSend = new runSend("", "71.7.151.36");
    //runSend testSend = new runSend("I7-8650U", "71.7.15");
    }
    @Test
    public void testSave()
    {
        String[] args = {"f","a","2.543e+08"};
        String fileName = "testSave.txt";
        Record r = new Record(args);
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