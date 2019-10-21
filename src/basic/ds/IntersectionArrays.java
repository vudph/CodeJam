package basic.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* find intersection btw 2 arrays (collections)
	a={1, 2, 1,}, b={1, 3, 4} => {1, 3}
*/
public class IntersectionArrays {
	
	public List<Integer> findIntersection(int a[], int b[]) {
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			s.add(a[i]);
		}
		List<Integer> intersection = new ArrayList<>();
		for (int i = 0; i < b.length; i++) {
			if (s.contains(b[i])) {
				intersection.add(b[i]);
				s.remove(b[i]);
			}
		}
		return intersection;
	}

	public static void main(String[] args) {
		new IntersectionArrays().findIntersection(new int[]{1, 2, 1, 3}, new int[]{1, 1, 3, 4});
	}

}
