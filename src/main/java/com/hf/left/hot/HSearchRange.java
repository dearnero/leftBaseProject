package com.hf.left.hot;

public class HSearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int left = 0, right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left) /2;
            if (nums[mid] == target){
                int lf = mid, rt = mid;
                while (lf >= 0 || rt <= nums.length - 1){
                    if (lf >= 0  && nums[lf] == target){
                        ans[0] = lf;
                    }
                    if (rt <= nums.length - 1 && nums[rt] == target){
                        ans[1] = rt;
                    }
                    lf--; rt++;
                }
                break;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new HSearchRange().searchRange(new int[]{1}, 1);
    }
}
