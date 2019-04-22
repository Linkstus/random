package prob1;
import java.util.TreeMap;
import java.util.Scanner;

public class TallyProgram {
	protected static TreeMap<Character, Integer> tally = new TreeMap<>();
	
	
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String s = user.next();
		count(s);
		
		System.out.println(tally.toString());
	}
	public static void count(String s) {
		int i = 0;
		
		while (i < s.length()) {
			char c = s.charAt(i);
			char c1 = Character.toLowerCase(c);
			if(tally.containsKey(c1)) {
				int count = tally.get(c1);
				if(Character.isUpperCase(c)) {
					tally.put(c1, --count);
				}
				else if(Character.isLowerCase(c)) {
					tally.put(c, ++count);
				}
			}
			else {
				if(Character.isUpperCase(c)) {
					tally.put(c1, -1);
				}
				else {
					tally.put(c1, 1);
				}
			}
			i++;
		}
	}
	
	
}
