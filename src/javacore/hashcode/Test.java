package javacore.hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		System.out.println("============= BAD ============");
		PersonNoHashcode a1 = new PersonNoHashcode("Vu");
		Map<PersonNoHashcode, String> map = new HashMap<>();
		map.put(a1, "802 S 9th Street");
		System.out.println(map.get(new PersonNoHashcode("Vu")));
//		
//		List<PersonNoHashcode> list = new ArrayList<>();
//		list.add(a1);
//		PersonNoHashcode b1 = new PersonNoHashcode("Vu");
//		System.out.println(a1.equals(b1));
//		System.out.println(list.contains(b1));
		
		System.out.println("============= GOOD ============");
		PersonHashcode a2 = new PersonHashcode("Vu");
		Map<PersonHashcode, String> map2 = new HashMap<>();
		map2.put(a2, "802 S 9th Street");
		PersonHashcode a3 = new PersonHashcode("Vu123");
		map2.put(a3, "1302 S Main St");
		System.out.println(map2.get(new PersonHashcode("Vu")));
	}

}
