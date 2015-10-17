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
		
		while (in.hasNext()) {
			String inLine = in.next();
			lines.add(inLine);
		}
		
		Collections.reverse(lines);
		
		while (!lines.isEmpty()) {
			String temp = lines.get(0);
			ArrayList<String> words = new ArrayList<String>();
			Scanner tempin = new Scanner(temp);
			
			while (tempin.hasNext()) {
				words.add(tempin.next());
			}
			Collections.reverse(words);
			
			while (!words.isEmpty()) {
				out.print(words.get(0));
				words.remove(0);
			}
			
			lines.remove(0);
			tempin.close();
		}
		
		out.close();
		in.close();
	
	}
}
