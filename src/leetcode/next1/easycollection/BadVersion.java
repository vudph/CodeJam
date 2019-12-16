package leetcode.next1.easycollection;

public class BadVersion {
	int m;
	public int firstBadVersion(int n, int m) {
        this.m = m;
        int first = 0;
        int l = 1;
        int r = n;
        while (l <= r) {
        	int mid = l + (r - l)/2;
        	if (isBadVersion(mid)) {
        		first = mid;
        		r = mid - 1;
        	} else {
        		l = mid + 1;
        	}
        }
        return first;
	}
//  1,2,3,4,5,6,7,8,9,10
//	g,g,g,g,g,g,b,b,b,b (assumption, first bad is 4, begin 4 to 10 are bad version all) -> first bad is 4 -> result 
	
//  l=1, r=10 -> mid=1+(10-1)/2=5 => l=6, r=10 => mid=7+(10-7)/2=8 => l=6, r=8, mid=7 => l=6, r=7, mid=6 => l=11, r=10 
    
    private int search(int l, int r) {
        if (l > r) 
            return -1;
        int mid = l + (r - l)/2;
        if (isBadVersion(mid)) {
            return search(l, mid);          
        } else {
        	return search(mid, r);
        }        
    }
    
    private boolean isBadVersion(int i) {
    	if (i >= m)
    		return true;
    	return false;
    }
	public static void main(String[] args) {
		System.out.println(new BadVersion().firstBadVersion(10, 7));
	}

}
