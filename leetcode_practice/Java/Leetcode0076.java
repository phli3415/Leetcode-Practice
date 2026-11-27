class Solution {
    public String minWindow(String s, String t) {
        // 返回 String：s 中包含 t 所有字符（含重复）的最短子串
        // need: 每个字符还差几个；count: 还差几种字符
        // 窗口合法 = count == 0 → 收缩 left，在 while 里更新最短
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        int count = need.size();
        int left = 0, bestStart = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) - 1);
                if (need.get(c) == 0) count--;
            }
            while (count == 0) {                          // 合法：尝试缩短
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    bestStart = left;
                }
                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    need.put(d, need.get(d) + 1);
                    if (need.get(d) == 1) count++;        // 吐出后又缺这种字符了
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + minLen);
    }
}