import java.util.*;
import java.util.stream.*;

public class Solution {

    public static List<List<String>> process(List<List<String>> records) {
        return records.stream()
            .filter(r -> r.get(4).equals("COMPLETED") && Integer.parseInt(r.get(2)) >= 50)
            .sorted(Solution::sortRecord)
            .collect(Collectors.toList());
    }

    private static int sortRecord(List<String> a, List<String> b) {
        int c = Integer.compare(dateKey(a.get(3)), dateKey(b.get(3)));  
        if (c != 0) return c;
        c = Integer.compare(Integer.parseInt(b.get(2)),
                            Integer.parseInt(a.get(2)));        
        if (c != 0) return c;
        return a.get(0).compareTo(b.get(0));                      
    }

    private static int dateKey(String s) {                   
        String[] p = s.split("-");
        return Integer.parseInt(p[2]) * 10000 + Integer.parseInt(p[1]) * 100 + Integer.parseInt(p[0]);
    }
}