class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] rm = new int [height.length];
        int [] lm = new int [height.length];
        rm[0] = height[0];
        lm[n-1] = height[n-1];
        for(int i = 1; i<n;i++){
            rm[i]=Math.max(rm[i-1], height[i]);
        }
        for(int i= n-2; i>= 0; i--){
            lm[i] = Math.max(lm[i+1], height[i]);
        }
        int sum = 0;
        for(int i= 0; i< n; i++){
            sum+=(Math.min(rm[i], lm[i]) - height[i]);
        }
        return sum;
        
    }
}