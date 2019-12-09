package com.cg.captain.datastructure;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public  class BubbleSortEx {
	static void  bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}

	/* Prints the array */
	void printArray(int arr[])
	{ 
		System.out.println("Bubble sorted array");
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(""+arr[i] + " ");
		System.out.println();
	}

	// Driver method to test above
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the arra elements :"+i);
			arr[i]=sc.nextInt();
		}

		
		BubbleSortEx ob = new BubbleSortEx();
		Instant end=Instant.now();
		Instant start=Instant.now();
		bubbleSort(arr);
		Long duration=Duration.between(start,end).toMillis();
		double seconds=duration/1000.0;
		System.out.println("bubble sort takes : "+seconds);
		ob.printArray(arr);
	}


}
