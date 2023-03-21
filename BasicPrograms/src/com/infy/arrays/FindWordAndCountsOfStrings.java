package com.infy.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindWordAndCountsOfStrings {
	public static void main(String[] args) {
		String s = "kids Jack sparrow kids and kids of Jack kids kids sparrow";
		String temp[] = s.split(" ");
		HashMap<String, Integer> output = new HashMap<String, Integer>();
		for (int i = 0; i < temp.length - 1; i++) {
			int count = 1;
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[i].equals(temp[j])) {
					count++;
				}
			}
			if (!output.containsKey(temp[i])) {

				output.put(temp[i], count);
			}

		}
		output.entrySet().stream().forEach(x -> System.out.println(x));
//		Set<Map.Entry<String, Integer>> entry = output.entrySet();
//		Iterator<Map.Entry<String, Integer>> itr = entry.iterator();
//		itr.forEachRemaining(out -> System.out.println(" Elemets: " + out));

	}
}
