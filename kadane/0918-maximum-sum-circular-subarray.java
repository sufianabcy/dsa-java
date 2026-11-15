class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int max=nums[0],currmax=nums[0];
        int sum=nums[0];
        int min=nums[0],minSum=0;
        for(int i=1;i<n;i++){
            currmax=Math.max(nums[i],nums[i]+currmax);
            max=Math.max(currmax,max);
            min=Math.min(nums[i],nums[i]+min);
            minSum=Math.min(min,minSum);
            sum+=nums[i];
        }
        if(max<0)return max;
        return Math.max(max,sum-minSum);
    }
}
