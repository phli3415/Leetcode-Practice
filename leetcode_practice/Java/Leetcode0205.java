class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        for(int i = 0; i< t.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            else{
                if(seen.contains(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                seen.add(t.charAt(i));
            }
        }

        return true;
    }
}