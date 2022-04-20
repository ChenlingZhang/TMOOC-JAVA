package Day04;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,7};
        int target = 5;
        int ans = new Solution().search(nums,target);
        System.out.println(ans);

    }
}
    class Solution {
        public int search(int[] nums, int target) {
            int arrayLength = nums.length;
            int startpoint = 0;
            int endpoint = arrayLength - 1;

            while (endpoint >= startpoint) {
                int mid = (endpoint - startpoint) / 2 + startpoint;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    startpoint = mid+1;
                } else if (nums[mid] > target) {
                    endpoint = mid-1;
                }
            }
            return -1;
        }
    }


