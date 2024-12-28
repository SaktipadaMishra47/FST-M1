package Day3;

import java.util.HashSet;
import java.util.Set;


public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> hs = new HashSet<String>();
		hs.add("A");
		hs.add("B");
		hs.add("C");
		hs.add("D");
		hs.add("E");
		hs.add("F");
		
		System.out.println("Hash set is displayed : " +hs);
		System.out.println("Size of the hash Set : " +hs.size());
		System.out.println("Removing A from HashSet: " + hs.remove("D"));
		System.out.println("Updated hasset " + hs);
		System.out.println("Size of the updated hash Set : " +hs.size());
		System.out.println("If set contains F - " + hs.contains("F"));
		
		
		
	}

}
