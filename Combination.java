
import java.util.ArrayList;

class Combination {
    public void combinate(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> re;
        //i是多长的组合
        for (int i = 0; i < n; i++) {
            re = new ArrayList<>();
            combinate(i+1, nums, 0, re);
        }
    }

    public void combinate(int n, int[] nums, int start, ArrayList<Integer> re) {
        if (n == 0) {
            System.out.println(re);
            return;
        }
        if (start==nums.length) {
            return;
        }
        re.add(nums[start]);
        combinate(n - 1, nums, start + 1, re);
        re.remove(re.size() - 1);
        combinate(n, nums, start + 1, re);
    }

    public static void main(String[] args) {
        new Solution().zuhe(new int[]{1, 2, 3});
    }
}
