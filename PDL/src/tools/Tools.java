package tools;

import java.util.ArrayList;
import java.util.Iterator;

public class Tools {

	public static int getSommeAL(ArrayList<Integer> al){
		Iterator<Integer> it = al.iterator();
		int sumRes = 0;
		while(it.hasNext()){
			sumRes = sumRes + it.next().intValue();
		}
		
		return sumRes;
	}
	
}
