package com.infy.arrays;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Object;

public class FindSecondOccurence {
	public static void streamAPIway(Integer arr[]) {
		List<Integer> targetList = Arrays.asList(arr).stream().distinct().sorted().collect(Collectors.toList());
		Integer maxValue = targetList.stream().max(Comparator.comparing(Integer::valueOf)).get();
		Integer index = targetList.stream().collect(Collectors.toList()).indexOf(maxValue);
		System.out.println(" Second Largest: -- " + targetList.get(index - 1));
	}

	public static void basicWay(int arr[]) {
		Arrays.sort(arr);
		int sum = 0;
		int x = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				al.add(arr[i]);
				sum = sum + arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			x = x + arr[i];
		}
		sum = sum + arr[arr.length - 1];
		al.add(arr[arr.length - 1]);// To Get last element
		Object[] b = al.toArray();
		for (Object object : b) {
			System.out.print(object + " ");
		}
		System.out.println("===========Sum is :" + sum + " ------------" + x);
	}

	public static void main(String[] args) {
		// Integer arr[] = { 77, 88, 55, 2, 66, 66, 11, 44, 22, 44, 99, 94, 100 };
		// FindSecondOccurence.streamAPIway(arr);
		int arr[] = { 10, 100, 200, 10, 100, 200, 10 };
		FindSecondOccurence.basicWay(arr);
	}
}
