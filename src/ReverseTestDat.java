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
		inPrint.println("Lorem ipsum dolor sit amet");
		inPrint.close();
		
		ReverseFile.reverse(input, output);
		
		Scanner out = new Scanner(output);
		
		String expected = "amet sit dolor ipsum Lorem";
		String actual = out.nextLine();
		out.close();
		
		assertEquals("You got it wrong", expected, actual);
	}
	
	@Test
	public void test2LinesOfWeirdLatinWords() throws FileNotFoundException {
		File input = new File("input.txt");
		File output = new File("output.txt");
		
		PrintWriter inPrint = new PrintWriter(input);
		inPrint.println("Lorem ipsum dolor sit amet");
		inPrint.println("consectetur adipiscing elit.");
		inPrint.close();
		
		ReverseFile.reverse(input, output);
		
		Scanner out = new Scanner(output);
		
		String expected = "elit. adipiscing consectetur";
		String actual = out.nextLine();
		
		assertEquals("You got line 1 wrong bitch nigga", expected, actual);
		
		expected = "amet sit dolor ipsum Lorem";
		actual = out.nextLine();
		out.close();
		
		assertEquals("You got line 2 wrong bitch nigga", expected, actual);
	}
	
	@Test
	public void test3LinesNoContent() throws FileNotFoundException {
		File input = new File("input.txt");
		File output = new File("output.txt");
		
		PrintWriter inPrint = new PrintWriter(input);
		inPrint.println("");
		inPrint.println("");
		inPrint.println("");
		inPrint.close();
		
		ReverseFile.reverse(input, output);
		
		Scanner out = new Scanner(output);
		
		String expected = "";
		String actual = out.nextLine();
		
		assertEquals("You got line 1 wrong bitch nigga", expected, actual);
		
		expected = "";
		actual = out.nextLine();
		
		assertEquals("You got line 2 wrong bitch nigga", expected, actual);
		
		expected = "";
		actual = out.nextLine();
		out.close();
		
		assertEquals("You got line 3 wrong bitch nigga", expected, actual);
	}
	
	@Test
	public void test1line2nothing3line() throws FileNotFoundException {
		File input = new File("input.txt");
		File output = new File("output.txt");
		
		PrintWriter inPrint = new PrintWriter(input);
		inPrint.println("a boy");
		inPrint.println("");
		inPrint.println("was super dumb");
		inPrint.close();
		
		ReverseFile.reverse(input, output);
		
		Scanner out = new Scanner(output);
		
		String expected = "dumb super was";
		String actual = out.nextLine();
		
		assertEquals("You got line 1 wrong bitch nigga", expected, actual);
		
		expected = "";
		actual = out.nextLine();
		
		assertEquals("You got line 2 wrong bitch nigga", expected, actual);
		
		expected = "boy a";
		actual = out.nextLine();
		out.close();
		
		assertEquals("You got line 3 wrong bitch nigga", expected, actual);
	
	}

}
