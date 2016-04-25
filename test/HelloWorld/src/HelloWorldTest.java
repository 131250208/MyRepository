import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;



public class HelloWorldTest {
	PrintStream console = null;
    ByteArrayOutputStream bytes = null;
    HelloWorld hello;

    @org.junit.Before
    public void setUp() throws Exception {
        
    	hello = new HelloWorld();
    		
        bytes = new ByteArrayOutputStream();
        console = System.out;

        System.setOut(new PrintStream(bytes));


    }

    @org.junit.After
    public void tearDown() throws Exception {
        
        System.setOut(console);
    }

    @org.junit.Test
    public void testResult() throws Exception {
    	hello.helloWorld();

    	String s = new String("Hello World! Hello Java!\n");
        assertEquals(s, bytes.toString());
    }

}
