package com.sun;

import java.time.LocalDate;
import java.util.*;

public class ArrayCombinations {
    public static List<List<String>> findContinuousLines(Set<String> stations, Map<String, String> map) {
        List<List<String>> continuousLines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();

        for (String station : stations) {
            if (map.containsKey(station)) {
                currentLine.add(station);
            } else {
                if (currentLine.size() > 1) {
                    continuousLines.add(new ArrayList<>(currentLine));
                }
                currentLine.clear();
            }
        }

        if (currentLine.size() > 1) {
            continuousLines.add(new ArrayList<>(currentLine));
        }

        return continuousLines;
    }

    public static void main(String[] args) {
        Set<String> setArray = new HashSet<>(Arrays.asList("福州南", "福清西", "莆田", "泉港", "泉州东", "泉州南", "厦门北", "漳州"));
        Map<String, String> map = new HashMap<>();
        map.put("福州南", "someValue");
        map.put("福清西", "someValue");
        map.put("泉港", "someValue");
        map.put("泉州东", "someValue");
        map.put("泉州南", "someValue");

        List<List<String>> continuousLines = findContinuousLines(setArray, map);
        System.out.println("连续的集合为:");
        for (List<String> line : continuousLines) {
            System.out.println(line);
        }
    }
}
