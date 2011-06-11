package util;

import java.util.HashSet;
import java.util.Set;

public class ListUtils {
	
	public static String[] unique(String[] strings) {
	    Set set = new HashSet();
	    for (int i=0; i<strings.length; i++) {
	        String name = strings[i].toLowerCase();
	        set.add(name);
	    }
	    return (String[])set.toArray(new String[0]);
	}

}
