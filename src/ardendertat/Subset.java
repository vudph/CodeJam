package ardendertat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

	public List<List<Integer>> subsets(int[] S) {
		// sort the given set
		Arrays.sort(S);
		// generate subsets
		List<List<Integer>> res =  subsetsHelper(S, 0, new ArrayList<List<Integer>>());
		
		return res;
	}

	private List<List<Integer>> subsetsHelper(int[] S, int cur, List<List<Integer>> results) {
		// reach end of set -> add [] as a subset
		if (cur >= S.length) {
			results.add(new ArrayList<Integer>());
			return results;
		}
		// generate subsets with remaining elements
		results = subsetsHelper(S, cur + 1, results);
		// append the current one to all subsets made up with remaining elements
		int curSize = results.size();
		while (curSize-- > 0) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.add(S[cur]);
			res.addAll(results.get(curSize));
			results.add(res);
		}
		return results;
	}

	public static void main(String[] args) {
		new Subset().subsets(new int[] {1,2,3});
	}

}
