package cn.ucaner.algorithm.fibonacci;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		int[] fib = new int[23];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i= 2;i<fib.length;i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
	
		System.out.print("斐波那契亚数列：");
		for(int i = 0;i<fib.length;i++)
			System.out.print(fib[i] + " ");
		
		System.out.println();
	}
}
