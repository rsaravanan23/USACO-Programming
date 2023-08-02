import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.util.Map.entry;

public class YearOfTheCow {

	public static void main(String[] args) throws IOException {
		Scanner initial = new Scanner(System.in);
		
		
		int numOfLines = initial.nextInt();
		Map<String, Integer> oxRel = Map.ofEntries(entry("Ox", 0) , entry("Tiger", 1), entry("Rabbit", 2) , entry("Dragon" , 3) 
				, entry("Snake" , 4) , entry("Horse", 5) , entry("Goat" , 6) , entry("Monkey", 7), entry("Rooster", 8)
				, entry("Dog", 9) , entry("Pig", 10) , entry("Rat" , 11));
		
		Map<String, String> nameToYear = new HashMap<String, String>();
		nameToYear.put("Bessie", "Ox");
		
		Map<String, Integer> scoresRelToBessie = new HashMap<String, Integer>();
		
		for(int x = 0; x < numOfLines; x++) { 
			String name = "";
			String pos = "";
			String year = "";
			String otherCow = "";
			for(int y = 0; y < 8; y++) { 
				if(y == 0) name = initial.next();
				else if(y == 3) pos = initial.next();
				else if(y == 4) year = initial.next();
				else if(y == 7) otherCow = initial.next();
			}
			
			if(otherCow.equals("Bessie")) { 
				if(pos.equals("previous")) { 
					int diff = oxRel.get(year) - 12;
					scoresRelToBessie.put(name, diff);
				} else { 
					int diff = oxRel.get(year);
					scoresRelToBessie.put(name, diff);
				}
			} else { 
				String otherCowYear = nameToYear.get(otherCow);
				if(pos.equals("previous")) { 
					int diff = 0;
					if(oxRel.get(otherCow) > oxRel.get(name)) { 
						diff = oxRel.get(otherCowYear) - oxRel.get(year);
					} else { 
						diff = oxRel.get(otherCowYear) + 12 - (oxRel.get(year));
					}
					scoresRelToBessie.put(name, scoresRelToBessie.get(otherCow) - diff);
				} else { 
					
					int diff = 0;
					
					if(oxRel.get(otherCow) > oxRel.get(name)) { 
						diff = oxRel.get(otherCowYear) - oxRel.get(year);
					} else { 
						diff = oxRel.get(otherCowYear) + 12 - (oxRel.get(year));
					}
				}
			}
			
			nameToYear.put(name, year);
		}
		
		System.out.print(Math.abs(scoresRelToBessie.get("Elsie")));
	}

}
