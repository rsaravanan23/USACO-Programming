import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class WhyDidTheCowCrossTheRoad {

	public static void main(String[] args) throws IOException {
		BufferedReader read =
		    new BufferedReader(new FileReader("cowqueue.in"));
		StringTokenizer initial = new StringTokenizer(read.readLine());
		
		int numOfCows = Integer.parseInt(initial.nextToken());
		Cow[] cows = new Cow[numOfCows];
		
		for(int x = 0; x < numOfCows; x++) { 
			StringTokenizer token = new StringTokenizer(read.readLine());
			int beginning = Integer.parseInt(token.nextToken());
			int timeDuration = Integer.parseInt(token.nextToken());
			cows[x] = new Cow(beginning, timeDuration);
		}
		
		Arrays.sort(cows, Comparator.comparingInt(cow -> cow.startTime));
		
		int beginTime = cows[0].startTime + cows[0].durationTime;
		
		for(int i = 1; i < numOfCows; i++) { 
			if(cows[i].startTime > beginTime) { 
				beginTime = cows[i].startTime + cows[i].durationTime;
			} else { 
				beginTime += cows[i].durationTime;
			}
		}
		
		PrintWriter written = new PrintWriter("cowqueue.out");
		written.println(beginTime);
		written.close();
	}

}

class Cow { 
	public int startTime;
	public int durationTime;
	
	public Cow(int start, int duration) { 
		startTime = start;
		durationTime = duration;
	}
}
