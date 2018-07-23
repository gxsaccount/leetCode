class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max=0,right=height.length-1,left=0;
        while(right!=left){
            if(height[right]>height[left]){
                max=Math.max(max,height[left]*(right-left));
                ++left;
            }
            else{
                max=Math.max(max,height[right]*(right-left));
                right--;
            }
        }
        return max;
    }
}
