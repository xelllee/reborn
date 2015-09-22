package com.xelllee.code.codility;

import java.util.HashMap;

public class SimpleTest {


    public static void main(String[] args) {

        String log = "00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" +
                "00:05:00,400-234-090";

        solution(log);


    }

    public static int solution(String S) {

        String[] lines = S.split("\n");

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int total = 0, max = 0, max_num = Integer.MAX_VALUE;
        int phone, sec;
        String[] arr;

        for (String line : lines) {
            arr = line.trim().split(",");
            if (arr.length != 2) continue;
            sec = toSec(arr[0]);
            phone = toNum(arr[1]);
            if (map.containsKey(phone)) {
                sec += map.get(phone);
                map.put(phone, sec);
            } else {
                map.put(phone, sec);
            }
        }

        for (int key : map.keySet()) {
            sec = map.get(key);
            if (sec >= max) {
                max = sec;
                max_num = Math.min(max_num, key);
            }
            total += secsToCents(sec);
        }

        //promo
        total -= secsToCents(max);

        return total;
    }


    private static int secsToCents(int sec) {

        return (sec < 300) ? sec * 3 : ((sec % 60 == 0) ? (sec / 60) * 150 : ((sec / 60) + 1) * 150);
    }

    public static int toSec(String duration) {

        String[] arr = duration.split(":");
        if (arr.length != 3) return 0;
        int sum = 0;
        sum += Integer.parseInt(arr[0]) * 3600;
        sum += Integer.parseInt(arr[1]) * 60;
        sum += Integer.parseInt(arr[2]);
        return sum;

    }

    public static int toNum(String phone) {
        return Integer.parseInt(phone.replace("-", ""));
    }

}
