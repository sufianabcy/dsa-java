class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int sum=0;
        int left=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }

        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
//Here main thing to remember is keep adding to right and then check (using while loop so that you can push left forward till the sum<target basically at the exact point where after subtracting left sum is less that target)
