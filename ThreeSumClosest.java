//https://leetcode.com/problems/3sum-closest/description/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int re= re=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i-1]==nums[i]) continue;
            int twoSum=target-nums[i];
            int lo=i+1;
            int hi=nums.length-1;
            while(lo<hi){
                int sum = nums[lo]+nums[hi];
                re=Math.abs(twoSum-sum)>Math.abs(target-re)?re:sum+nums[i];
                if(sum==twoSum){
                    return target;
                }
                else if(sum<twoSum){
                    ++lo;
                }
                else{
                    --hi;
                }
            }
        }
        return re;
    }
}
