package leetcode.next1.easycollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleArray {
	private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    
    public int[] shuffle0() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.remove(removeIdx);
        }
        for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
        return array;
    }
    
    private void swapAt(int i, int j) {
    	int tmp = array[i];
    	array[i] = array[j];
    	array[j] = tmp;
    }
    
    private int randRange(int min, int max) {
    	return rand.nextInt(max - min) + min;
    }
    
    public int[] shuffle1() {
    	for (int i = 0; i < array.length; i++) {
			swapAt(i, randRange(i, array.length));
		}
    	
    	return array;
    }

	public static void main(String[] args) {
		ShuffleArray s = new ShuffleArray(new int[] {1,2,3});
		s.shuffle0();
//		System.out.println();
//		s.shuffle0();
//		System.out.println();
//		s.shuffle0();
//		System.out.println();
//		s.shuffle0();
		
		System.out.println();
		Random rand = new Random();
		System.out.println(rand.nextInt(5)); // [0->4]
		System.out.println(rand.nextInt(5 - 2) + 2); // [2,4]
	}

}
