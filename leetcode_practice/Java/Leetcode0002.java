class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while (set.contains(c) && left <= i){
                set.remove(s.charAt(left));
                left++; 
            }

            set.add(c);
            max = Math.max(i + 1 - left, max);
        }

        return max;
    }
}