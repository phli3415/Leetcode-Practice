class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }

        int start = 0;
        int end = 0;
        boolean [][] arr = new boolean[s.length()][s.length()];
        int max = 1;

        for(int i = 0; i<s.length(); i++){
            arr[i][i] = true;
            for(int j = 0; j < i; j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || arr[i-1][j+1])){
                    arr[i][j] = true;
                    if(i-j+1>max){
                        max = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }
}