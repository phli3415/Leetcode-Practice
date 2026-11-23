class Solution {
    int [] mem;
    
    public int jump(int[] nums) {
        mem = new int[nums.length+1];
        return dp(nums,0);

    }

    public int dp(int[]nums, int index){
        if(index>=nums.length-1){
            return 0;
        }
        if(mem[index]!= 0){
            return mem[index];
        }
        int min = 100000;
        for(int i = 1; i<=nums[index]; i++){
            min = Math.min(min, dp(nums, index+i));
        }
        min++;
        mem[index] = min;
        return min;
    }
}