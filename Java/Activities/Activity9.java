package Day3;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> myList = new ArrayList<String>();
		myList.add("Rama");
		myList.add("Sama");
		myList.add("Vima");
		myList.add("Sita");
		myList.add("Gita");

		for(int i = 0 ; i <myList.size() ; i++) {
			System.out.println(myList.get(i));		
			}		
		System.out.println("The size of the list is : " +myList.size());
		myList.removeLast();
		System.out.println("The size of the list after removing is : " +myList.size());
		System.out.println("The 3rd name in the ArrayList is : "+myList.get(2));
		System.out.println("The 3rd name in the ArrayList is : "+myList.contains("Sita"));
	}
  }
