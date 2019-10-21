package interview.amz;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	
	public List<Integer> cellComplete(int states[], int days) {
		int astate[] = new int[states.length + 2];
		astate[0] = 0;
		astate[states.length] = 0;
		for (int i = 0; i < states.length; i++) {
			astate[i + 1] = states[i];
		}
		for (int i = 0; i < days; i++) {
			int temp[] = new int[astate.length];
			for (int j = 1; j < astate.length - 1; j++) {
				if (astate[j] == 1 && (astate[j-1] == astate[j+1])) {
					temp[j] = 0;
				} else  if (astate[j] == 0 && (astate[j-1] != astate[j+1])) {
					temp[j] = 1;
				} else {
					temp[j] = astate[j];
				}
					
			}
			astate = temp;
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i < astate.length - 1; i++) {
			res.add(astate[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> re = new Demo1().cellComplete(new int[]{1,1,1,0,1,1,1,1}, 2000);
		System.out.println();
	}

}
