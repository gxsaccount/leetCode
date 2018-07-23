//https://leetcode.com/submissions/detail/126150631/
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(tempMap.containsKey(temp)){
                return new int[]{tempMap.get(temp),i};
            }
            tempMap.put(nums[i],i);
        }      
        throw new IllegalArgumentException("no solution");
    }
}
