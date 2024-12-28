package Day3;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer,String> colours  = new HashMap<Integer,String>();
		colours.put(1, "White");
		colours.put(2, "Green");
		colours.put(3, "Red");
		colours.put(4, "Black");
		colours.put(5, "Yellow");
		System.out.println( "Size of the Map before remove : "+colours.size());
		System.out.println( "Removed one from the Map : "+colours.remove(1) );
		
		if(colours.containsValue("Green")) {
			System.out.println("green exists in the Map");
		}else
		{
			System.out.println("green do not exist in the Map");
		}
		
		System.out.println( "Size of the Map : "+colours.size());
	}

}
