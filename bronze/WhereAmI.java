import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WhereAmI {

	public static void main(String[] args) throws IOException {
		BufferedReader read =
		    new BufferedReader(new FileReader("whereami.in"));
		StringTokenizer initial = new StringTokenizer(read.readLine());
		int numOfFarms = Integer.parseInt(initial.nextToken());
		
		StringTokenizer letters = new StringTokenizer(read.readLine());
		
		PrintWriter written = new PrintWriter("whereami.out");
	
		String farmSeq = letters.nextToken();
		
		Set<String> set = new HashSet<String>();
		
		if(farmSeq.length() == 1) {
			written.print(1);
			written.close();
		}
		
		for(int j = 1; j <= farmSeq.length(); j++) { 
			boolean bool = true;
			for(int k = 0; k <= numOfFarms - j; k++) { 
				if(set.contains	(farmSeq.substring(k, j + k))) {
					bool = false; 
					break; 
				}
				set.add(farmSeq.substring(k, j+k));
			}
			if(bool) { 
				written.print(j);
				written.close();
			}	
		}
		
		written.print(-1);
		written.close();
	}

}
