package laDDER_A;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Stone {
	static int lower_bound(int arr[], int N, int X)
	{
	    int mid;
	 
	    // Initialise starting index and
	    // ending index
	    int low = 0;
	    int high = N;
	 
	    // Till low is less than high
	    while (low < high) {
	        mid = low + (high - low) / 2;
	 
	        // If X is less than or equal
	        // to arr[mid], then find in
	        // left subarray
	        if (X <= arr[mid]) {
	            high = mid;
	        }
	 
	        // If X is greater arr[mid]
	        // then find in right subarray
	        else {
	            low = mid + 1;
	        }
	    }
	   
	    // if X is greater than arr[n-1]
	    if(low < N && arr[low] < X) {
	       low++;
	    }
	       
	    // Return the lower_bound index
	    return low;
	}
	 
	// Function to implement upper_bound
	static int upper_bound(int arr[], int N, int X)
	{
	    int mid;
	 
	    // Initialise starting index and
	    // ending index
	    int low = 0;
	    int high = N;
	 
	    // Till low is less than high
	    while (low < high) {
	        // Find the middle index
	        mid = low + (high - low) / 2;
	 
	        // If X is greater than or equal
	        // to arr[mid] then find
	        // in right subarray
	        if (X >= arr[mid]) {
	            low = mid + 1;
	        }
	 
	        // If X is less than arr[mid]
	        // then find in left subarray
	        else {
	            high = mid;
	        }
	    }
	   
	    // if X is greater than arr[n-1]
	    if(low < N && arr[low] <= X) {
	       low++;
	    }
	 
	    // Return the upper_bound index
	    return low;
	}
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int t=fs.nextInt();
		while(t-->0)
		{
			int n=fs.nextInt();
			int l=fs.nextInt();
			int r=fs.nextInt();
			int arr[]=fs.nextInts(n);
			int presum[]=new int[n];
			for(int i=1;i<n;i++)
			{
				presum[0]=arr[0];
				presum[i]=presum[i-1]+arr[i];
			}
			sort(arr);
			int ans=0;
			for(int i=0;i<n;i++)
			{
				ans+=upper_bound(arr, n, l-arr[i]);
				ans-=lower_bound(arr, n, r-arr[i]);
			}
			System.out.println(ans);
		}
		
	}
	public static void sort(int[] arr) {
		//because Arrays.sort() uses quicksort which is dumb
		//Collections.sort() uses merge sort
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int x : arr)
			ls.add(x);
		Collections.sort(ls);
		for (int i = 0; i < arr.length; i++)
			arr[i] = ls.get(i);
	}

}
class FastScanner {
	//I don't understand how this works lmao
	private int BS = 1 << 16;
	private char NC = (char) 0;
	private byte[] buf = new byte[BS];
	private int bId = 0, size = 0;
	private char c = NC;
	private double cnt = 1;
	private BufferedInputStream in;

	public FastScanner() {
		in = new BufferedInputStream(System.in, BS);
	}

	public FastScanner(String s) {
		try {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		} catch (Exception e) {
			in = new BufferedInputStream(System.in, BS);
		}
	}

	private char getChar() {
		while (bId == size) {
			try {
				size = in.read(buf);
			} catch (Exception e) {
				return NC;
			}
			if (size == -1)
				return NC;
			bId = 0;
		}
		return (char) buf[bId++];
	}

	public int nextInt() {
		return (int) nextLong();
	}

	public int[] nextInts(int N) {
		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			res[i] = (int) nextLong();
		}
		return res;
	}

	public long[] nextLongs(int N) {
		long[] res = new long[N];
		for (int i = 0; i < N; i++) {
			res[i] = nextLong();
		}
		return res;
	}

	public long nextLong() {
		cnt = 1;
		boolean neg = false;
		if (c == NC)
			c = getChar();
		for (; (c < '0' || c > '9'); c = getChar()) {
			if (c == '-')
				neg = true;
		}
		long res = 0;
		for (; c >= '0' && c <= '9'; c = getChar()) {
			res = (res << 3) + (res << 1) + c - '0';
			cnt *= 10;
		}
		return neg ? -res : res;
	}

	public double nextDouble() {
		double cur = nextLong();
		return c != '.' ? cur : cur + nextLong() / cnt;
	}

	public double[] nextDoubles(int N) {
		double[] res = new double[N];
		for (int i = 0; i < N; i++) {
			res[i] = nextDouble();
		}
		return res;
	}

	public String next() {
		StringBuilder res = new StringBuilder();
		while (c <= 32)
			c = getChar();
		while (c > 32) {
			res.append(c);
			c = getChar();
		}
		return res.toString();
	}

	public String nextLine() {
		StringBuilder res = new StringBuilder();
		while (c <= 32)
			c = getChar();
		while (c != '\n') {
			res.append(c);
			c = getChar();
		}
		return res.toString();
	}

	public boolean hasNext() {
		if (c > 32)
			return true;
		while (true) {
			c = getChar();
			if (c == NC)
				return false;
			else if (c > 32)
				return true;
		}
	}
}
	
	



