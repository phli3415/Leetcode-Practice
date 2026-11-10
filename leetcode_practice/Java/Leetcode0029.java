class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor){
            return 1;
        }
        else if(divisor == -1 && Integer.MIN_VALUE == dividend){
            return Integer.MAX_VALUE;
        }
        else if(divisor == 1){
            return dividend;
        }
        else if(divisor == -1){
            return -dividend;
        }

        int sign = 1;
        if(dividend>0 && divisor<0) sign = -1;
        if(dividend<0 && divisor>0) sign = -1;
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        int ans = 0;
        while(n >= d){
            int p = 0;
            while(n >= d<<p){
                p++;
            }
            p--;
            n-=d<<p;
            ans+=1<<p;
        }
        if(ans>=Math.pow(2,31) && sign==1) return Integer.MAX_VALUE;
        if(ans>=Math.pow(2,31) && sign==-1) return Integer.MIN_VALUE;

        return ans*sign;
    }
}