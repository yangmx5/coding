package hotOneHundred;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagrams(arr);

        for (List<String> list : ret) {
            StringBuffer buffer = new StringBuffer();
            for (String str : list) {
                buffer.append(str);
                buffer.append(",");
            }
            System.out.println(buffer.toString());
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
