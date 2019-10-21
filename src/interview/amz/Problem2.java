package interview.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2 {
	
	static class App implements Comparable<App>{
		int appId;
		int appMem;
		public App(int appId, int appMem) {
			this.appId = appId;
			this.appMem = appMem;
		}
		
		@Override
		public int compareTo(App o) {
			return this.appMem - o.appMem;
		}
		
		@Override
		public String toString() {
			return "[" + appId + "," + appMem + "]";
		}
	}
	
	public List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroundAppList) {
		List<List<Integer>> resultApps = new ArrayList<>();
		// build custom app list
		List<App> fgAppList = new ArrayList<>();
		for (List<Integer> list : foregroundAppList) {
			App app = new App(list.get(0), list.get(1));
			fgAppList.add(app);
		}
		// sort the foreground app list with capacity descending
		Collections.sort(fgAppList, Collections.reverseOrder());

		List<App> bgAppList = new ArrayList<>();
		for (List<Integer> list : backgroundAppList) {
			App app = new App(list.get(0), list.get(1));
			bgAppList.add(app);
		}
		// sort the foreground app list with capacity ascending
		Collections.sort(bgAppList);

		List<App> res = new ArrayList<>(); //temp res in one list
		int max = Integer.MIN_VALUE; // keep track the max value
		for (App fgApp : fgAppList) {
			for (App bgApp : bgAppList) {
				if (fgApp.appMem + bgApp.appMem > deviceCapacity) {
					break; // stop to loop the remaining ones
				}
				if (fgApp.appMem + bgApp.appMem <= deviceCapacity && (fgApp.appMem + bgApp.appMem) >= max) {
					res.add(fgApp);
					res.add(bgApp);
					max = fgApp.appMem + bgApp.appMem;
				}
			}
		}
		//build the result as output requirement
		for (int i = 0; i < res.size(); i += 2) {
			App app1 = res.get(i);
			App app2 = res.get(i + 1);
			if (app1.appMem + app2.appMem == max) {
				List<Integer> l = new ArrayList<>();
				l.add(app1.appId);
				l.add(app2.appId);
				resultApps.add(l);
			}
		}
		return resultApps;
	}

	public static void main(String[] args) {
		new Problem2().optimalUtilization(10, Arrays.asList(Arrays.asList(1,3), Arrays.asList(2,5), Arrays.asList(3,7), Arrays.asList(4,10)), 
												Arrays.asList(Arrays.asList(1,2),Arrays.asList(2,3),Arrays.asList(3,4),Arrays.asList(4,5)));
	}

}
