package interview.ks;

import java.awt.EventQueue;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class Problem1 {
	private static int commonCounter = 0;
	
	public  int getCount() {
		return commonCounter;
	}

	public void addCount(int val) {
		synchronized (Problem1.class) {
			commonCounter += val;
		}
	}
	
	
	
	public  void set(JTextComponent cmp, String a) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				cmp.setText(a);
			}
		});
	}
	
	static void fix(String s) {
		String t = s;
		t = t.trim();
		t = t.replace(' ', '_');
		s = t;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String x = "> This is a test <";
//		fix(x);
//		System.out.println(x);
//		
//		String aa = Base64.getEncoder().encodeToString("hello".getBytes("ascii"));
//		System.out.println(aa);
		
		int x = Math.multiplyExact(Integer.MAX_VALUE, Integer.MAX_VALUE);
		System.out.println(x);
		List<Problem1> p = new ArrayList<Problem1>();
		Collections.synchronizedCollection(p);
	}

	
}
