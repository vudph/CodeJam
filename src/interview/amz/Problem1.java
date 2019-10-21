package interview.amz;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// test id: 23280666240033

public class Problem1 {
	
	public int minimumTime(int numOfParts, List<Integer> parts) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
		
		//adding the parts to PQ
        for (int i = 0; i < numOfParts; i++) { 
            pq.add(parts.get(i)); 
        } 
  
        int totalTime = 0; 
        
        // Loop until the size of PQ still > 1
        while (pq.size() > 1) { 
            //extract shortest size of two parts from PQ 
            int first = pq.poll(); 
            int second = pq.poll(); 
            // then insert the new part to PQ 
            totalTime += first + second; 
            pq.add(first + second); 
        } 
  
        return totalTime;
	}

	public static void main(String[] args) {
		System.out.println(new Problem1().minimumTime(4, Arrays.asList(20,4,8,2)));
	}

}
