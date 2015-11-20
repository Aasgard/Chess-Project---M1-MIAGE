package tools;

import java.util.List;
import java.util.Iterator;

public class Tools {

	public static int getSommeAL(List<Integer> al){
		Iterator<Integer> it = al.iterator();
		int sumRes = 0;
		while(it.hasNext()){
			sumRes = sumRes + it.next().intValue();
		}
		
		return sumRes;
	}
	
}
