
/*数组中的逆序对*/

class Solution {
    public static void main(String[] args) {
        System.err.println(new Solution().InversePairs(new int[]{7,5,6,4}));
        System.err.println(new Solution().InversePairs(new int[]{1,2,5,4,3}));
    }

    public int InversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, copy.length);
        int re= InversePairs(nums, copy, 0, copy.length-1);
        return re;
    }

    public int InversePairs(int[] nums, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = nums[start];
            return 0;
        }

        int count = 0;
        int length = (end - start) / 2;
        int left = InversePairs(copy,nums, start, start + length);
        int right = InversePairs(copy,nums, start + length + 1, end);
        int i = start + length;
        int j = end;
        int copyIndex = end;

        while (i >= start && j >= start + length + 1) {
            if (nums[i] > nums[j]) {
                count += j - (start + length);
                copy[copyIndex--] = nums[i--];
            } else {
                copy[copyIndex--] = nums[j--];
            }
        }

        while (i >= start) {
            copy[copyIndex--] = nums[i--];
        }
        while (j >= start + length + 1) {
            copy[copyIndex--] = nums[j--];
        }
        return count + left + right;
    }
}
