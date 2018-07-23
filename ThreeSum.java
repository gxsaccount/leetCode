class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        if(nums.length<3) return res; 
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i-1]==nums[i]) continue;
            int twoSum=0-nums[i];
            int lo=i+1;
            int hi=nums.length-1;
            while(lo<hi){
                int sum = nums[lo]+nums[hi];
                if(sum==twoSum){
                    List<Integer> re = new ArrayList();
                    int num1=nums[lo];
                    int num2=nums[hi];
                    re.add(nums[i]);
                    re.add(nums[lo]);
                    re.add(nums[hi]);
                    res.add(re);
                    while(lo<hi&&nums[lo]==num1){
                        ++lo;
                    }
                    while(lo<hi&&nums[hi]==num2){
                        --hi;
                    }
                }
                else if(sum<twoSum){
                    ++lo;
                }
                else{
                    --hi;
                }
            }
            
        }
        return res;
    }
}
