import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FirstTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
    
	}

	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void out() {
		setUpStreams();
	    First.main(null);
	    restoreStreams();
	    String expectedOutput = "Hello World!\n";
	     if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
	            // Windows systems use a carriage return / new line combo
	            expectedOutput = expectedOutput.replaceAll("\n", "\r\n");
	        }
	    assertEquals(expectedOutput, outContent.toString());

	}

}
