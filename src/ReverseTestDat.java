import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;


public class ReverseTestDat {

	@Test
	public void testWeirdLatinWords() throws FileNotFoundException {
		File input = new File("input.txt");
		File output = new File("output.txt");
		
		PrintWriter inPrint = new PrintWriter(input);
		inPrint.println("“Lorem ipsum dolor sit amet");
		inPrint.close();
		
		ReverseFile.reverse(input, output);
		
		Scanner out = new Scanner(output);
		
		String expected = "amet sit dolor ipsum Lorem";
		String actual = out.nextLine();
		
		assertEquals("You got it wrong", expected, actual);
	}

}
