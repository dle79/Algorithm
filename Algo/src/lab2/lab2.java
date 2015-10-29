package lab2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lab2 {
	public static void main(String args[])
	{
		int a[] = {1, 4 ,7, 8, 17};
		int b[] = {2, 4, 8, 11, 13, 21, 23, 25};
		int c[] = merge(a,b);
		System.out.println(Arrays.toString(c));
		
		List<Integer> X = new ArrayList<Integer>();
		X.add(2);
		X.add(4);
		X.add(8);
		X.add(11);
		X.add(13);
		X.add(21);
		X.add(23);
		X.add(25);
		System.out.println(PowerSet(X));
	}
	public static int[] merge(int[] a, int b[])
	{
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		
		while(i < a.length && j < b.length)
		{
			if(a[i] < b[j])
			{
				c[k++] = a[i++];
			}
			else
			{
				c[k++] = b[j++];
			}
		}
		while(i < a.length)
		{
			c[k++] = a[i++];
		}
		while(j < b.length)
		{
			c[k++] = b[j++];
		}
		return c;
	}
	public static List<Set<Integer>> PowerSet(List<Integer> X) {
		List<Set<Integer>> P = new ArrayList<Set<Integer>>();
		Set<Integer> S = new HashSet<Integer>();
		P.add(S);
		List<Set<Integer>> T = new ArrayList<Set<Integer>>();
		
		if(X.isEmpty()) {
			return P;
		}
		
		while(!X.isEmpty()) {
			
			//Integer f = X.remove(0);
			int f = X.remove(0);
			
			for(Set<Integer> x : P) {			
				T.add(x);
			}
			for(Set<Integer> x : T) {
				S = new HashSet<Integer>();
				S.add(f);
				S.addAll(x);
				P.add(S);					
			}					
		}			
		return P;	
	}
}
