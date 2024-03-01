import java.util.*;

public class ContinuousLines {
    public static List<List<String>> findContinuousLines(Set<String> stationSet, Map<String, Integer> stationMap) {
        List<String> stations = new ArrayList<>(stationSet);
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : stationMap.entrySet()) {
            if (entry.getValue() == 1 && stations.contains(entry.getKey())) {
                result.add(entry.getKey());
            }
        }

        List<List<String>> continuousLines = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();

        for (String station : result) {
            if (currentLine.isEmpty() || stations.indexOf(station) == stations.indexOf(currentLine.get(currentLine.size() - 1)) + 1) {
                currentLine.add(station);
            } else {
                continuousLines.add(currentLine);
                currentLine = new ArrayList<>();
                currentLine.add(station);
            }
        }

        if (!currentLine.isEmpty()) {
            continuousLines.add(currentLine);
        }

        return continuousLines;
    }

    public static void main(String[] args) {
        Set<String> stations = new HashSet<>(Arrays.asList("福州南", "福清西", "莆田", "泉港", "泉州东", "泉州南", "厦门北", "漳州"));
        Map<String, Integer> map = new HashMap<>();
        map.put("福州南", 1);
        map.put("福清西", 1); // 0 表示无效站点

        map.put("莆田", 1);
        map.put("泉港",1);
        map.put("泉州东", 1);

        map.put("泉州南", 1);

        map.put("厦门北", 1);
        map.put("漳州", 1);



        // 添加更多站点...

        List<List<String>> continuousLines = findContinuousLines(stations, map);

        for (List<String> line : continuousLines) {
            if (line.size() > 1) {
                System.out.println("连续线路：" + line + "，起点：" + line.get(0) + "，终点：" + line.get(line.size() - 1));
            }
        }
    }
}
