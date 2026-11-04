import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(ans-target);

        for(int i = 0 ; i < nums.length-2; i++) {

            int FI = i+1;
            int LI = nums.length-1;

            while(FI < LI) {
                int sum = nums[i] + nums[FI] + nums[LI];
                int CurrDiff = Math.abs(sum-target);

                if(CurrDiff < diff) {
                    ans=sum;
                    diff = CurrDiff;
                }
                else if (sum < target) {
                    FI++;
                }
                else {
                    LI--;
                }

        
            }
        }
        return ans;
        
    }
}