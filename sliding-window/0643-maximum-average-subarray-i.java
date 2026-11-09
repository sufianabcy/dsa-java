class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0,maxSum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxSum=sum;
        for(int i=k;i<n;i++){
            sum-=nums[i-k];
            sum+=nums[i];
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum/k;
    }
}
//the trick was to add the next element and remove the prev element so we can move forward with k window and that's how we get O(n)


