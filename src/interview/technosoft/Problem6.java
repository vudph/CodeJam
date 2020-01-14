package interview.technosoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

	public static long playlist(List<Integer> songs) {
		int count = 0;
		for (int i = 0; i < songs.size() - 1; i++) {
			for (int j = i + 1; j < songs.size(); j++) {
				int sum = songs.get(i) + songs.get(j);
				if (sum % 60 == 0) {
					System.out.println(i + "," + j);
					count++;
				}
			}
		}
		return count;
		
//		int n = songs.size();
//		int freq[] = new int[60]; 
//		  
//        // Count occurrences of all remainders 
//        for (int i = 0; i < n; i++) 
//            freq[songs.get(i) % 60]++; 
//  
//        // If both pairs are divisible by '60' 
//        int sum = freq[0] * (freq[0] - 1) / 2; 
//  
//        for (int i = 1; i <= 30 && i != (60 - i); i++) {
//        	sum += freq[i] * freq[60 - i]; 
//        }
//        
//        sum += (freq[30] * (freq[30] - 1) / 2); 
//        return sum;
		
//		HashMap<Integer, Integer> hm = new HashMap<>();
//		int count = 0;
//		for (int t : songs) {
//			count += hm.getOrDefault((60 - t % 60) % 60, 0);
//			hm.put(t % 60, hm.getOrDefault(t % 60, 0) + 1);
//		}        
//		return count;
		
//		int[] counts = new int[60];
//        int sum = 0;
//        for (int i = 0; i < time.length; i++) {
//            int r = time[i] % 60;
//            sum += counts[(60 - r) % 60];
//            counts[r]++;
//        }
//        return sum;
		
//		int[] length_mod = new int[60];
//		int count = 0;
//
//		for (int i = 0; i < songs.size(); i++) {
//			length_mod[songs.get(i) % 60]++;
//		}
//
//		int zeroCount = 0;
//		for (int i = 0; i < length_mod[0]; i++) {
//			zeroCount += i;
//		}
//		count += zeroCount;
//
//		int thirtyCount = 0;
//		for (int i = 0; i < length_mod[30]; i++) {
//			thirtyCount += i;
//		}
//		count += thirtyCount;
//
//		for (int i = 1; i < 30; i++) {
//			count += length_mod[i] * length_mod[60 - i];
//		}
//
//		return count;
	}

	public static void main(String[] args) {
		System.out.println(playlist(Arrays.asList(0,30,20,150,100,120,80,40,60,160)));
		System.out.println(200 / 60);
	}

}
