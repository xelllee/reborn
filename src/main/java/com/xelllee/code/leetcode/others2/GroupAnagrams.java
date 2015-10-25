package com.xelllee.code.leetcode.others2;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p/>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p/>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();


        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            ArrayList<String> set;
            if (res.containsKey(key)) {
                set = res.get(key);
            } else {
                set = new ArrayList<String>() {
                };
            }
            set.add(s);
            res.put(key, set);
        }

        List<List<String>> groups = new ArrayList<List<String>>();

        for (String key : res.keySet()) {
            List<String> list = new ArrayList<String>();
            list.addAll(res.get(key));
            Collections.sort(list);
            groups.add(list);
        }


        return groups;
    }

}
