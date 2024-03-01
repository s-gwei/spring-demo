package com.sun;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = 17*100;
        int b = 20;
        System.out.println("输出"+(a/b));
//        String[] stations = {"福州南", "福清西", "莆田", "泉港", "泉州东", "泉州南", "厦门北", "漳州"};
//        Map<String, Integer> map = new HashMap<>();
//        map.put("福州南", 1);
//        map.put("福清西", 1);
//        map.put("泉港", 1);
//        map.put("泉州东", 1);
//
//        map.put("莆田", 0);
//
//        List<List<String>> results = findAllConsecutiveStations(stations, map);
//        if (results != null && !results.isEmpty()) {
//            for (List<String> result : results) {
//                System.out.println("起点：" + result.get(0) + "，终点：" + result.get(result.size() - 1) + "，路径：" + result);
//            }
//        } else {
//            System.out.println("未找到符合条件的连续元素。");
//        }
    }

    public static List<List<String>> findAllConsecutiveStations(String[] stations, Map<String, Integer> map) {
        List<List<String>> allResults = new ArrayList<>();
        List<String> consecutiveStations = new ArrayList<>();
        boolean foundStart = false;

        for (int i = 0; i < stations.length - 1; i++) {
            String currentStation = stations[i];
            String nextStation = stations[i + 1];

            if (map.containsKey(currentStation) && map.get(currentStation) == 1 &&
                    map.containsKey(nextStation) && map.get(nextStation) == 1) {
                if (!foundStart) {
                    foundStart = true;
                    consecutiveStations.add(currentStation);
                }
                consecutiveStations.add(nextStation);
            } else {
                if (foundStart && consecutiveStations.size() >= 2) {
                    allResults.add(new ArrayList<>(consecutiveStations));
                }
                consecutiveStations.clear();
                foundStart = false;
            }
        }

        if (foundStart && consecutiveStations.size() >= 2) {
            allResults.add(new ArrayList<>(consecutiveStations));
        }

        return allResults.isEmpty() ? null : allResults;
    }
}
