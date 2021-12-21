package laDDER_A;
import java.io.*;
import java.lang.*;
import java.util.*;


public class Panoramixs_Prediction{

static void sive(int n)
{
	boolean arr[]=new boolean[n];
	Arrays.fill(arr, true);
	arr[0]=false;
	arr[1]=false;
	for(int i=2;i<n;i++)
	{
		if(arr[i])
		{
			for(int j=i*i;j<n;j+=i)
			{
				arr[j]=false;
			}
		}
	}
	for(int i=0;i<n;i++)
	{
		if(arr[i])
		{
			System.out.print(i+",");
		}
	}
}
	public static void main(String[] args) {

		FastScanner fs= new FastScanner();
//		sive(50);
		int arr[]= {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
		int a=fs.nextInt();
		int b=fs.nextInt();
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==a&&arr[i+1]==b)
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
			
		          
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