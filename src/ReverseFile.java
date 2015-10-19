import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ReverseFile {
	public static void reverse(File input, File output) throws FileNotFoundException {
		ArrayList<String> lines = new ArrayList<String>();
		
		Scanner in = new Scanner(input);
		PrintWriter out = new PrintWriter(output);
		
		while (in.hasNextLine()) {
			String inLine = "" + in.nextLine();
			lines.add(inLine);
		}
		
		Collections.reverse(lines);
		
		while (!lines.isEmpty()) {
			String temp = "" + lines.get(0);
			ArrayList<String> words = new ArrayList<String>();
			Scanner tempin = new Scanner(temp);
			
			while (tempin.hasNext()) {
				words.add(tempin.next());
				words.add(" ");
			}
			
			Collections.reverse(words);
			
			if (!words.isEmpty()) {
				words.remove(0); //Removes space at the beginning
			}
			
			while (!words.isEmpty()) {
				out.print("" + words.get(0));
				words.remove(0);
			}
			
			out.println();
			lines.remove(0);
			tempin.close();
		}
		
		out.close();
		in.close();
	
	}
}
