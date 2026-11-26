class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 1. 窗口长度固定为 k = s1.length()
        // 2. 右边进一个字符；窗口超过 k 时，左边出一个
        // 3. 每一步比较两个计数数组是否相同
        int k = s1.length();
        if (k > s2.length()) return false;
        int[] need = new int[26], win = new int[26];
        for (char c : s1.toCharArray()) need[c - 'a']++;

        for (int right = 0; right < s2.length(); right++) {
            win[s2.charAt(right) - 'a']++;                    // 进
            if (right >= k) win[s2.charAt(right - k) - 'a']--; // 出
            if (Arrays.equals(need, win)) return true;
        }
        return false;
    }
}