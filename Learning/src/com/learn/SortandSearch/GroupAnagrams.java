package com.learn.SortandSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void group(String[] arr) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : arr) {
			String sortedS = sort(s);
			if (map.containsKey(sortedS)) {
				map.get(sortedS).add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				map.put(sortedS, list);
			}
		}
		
		int index=0;
		for(String key:map.keySet()) {
			List<String> list=map.get(key);
			System.out.println(list);
			for(String s:list) {
				arr[index++]=s;
			}
		}

	}

	public static String sort(String s) {
		char[] chArray = s.toCharArray();
		Arrays.sort(chArray);
		return new String(chArray);
	}

	public static void main(String[] args) {
		String[] arr = { "aba", "pet", "tem", "baa", "bab", "tep", "tme", "etp", "met" };
		group(arr);
//		for(String s:arr)
//		System.out.print(s+" ");
	}
}
