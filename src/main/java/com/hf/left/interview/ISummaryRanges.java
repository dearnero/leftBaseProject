package com.hf.left.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/24 21:25
 * @version: 1.0
 */
public class ISummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            int low = i;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1] + 1){
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ans.add(temp.toString());
        }
        return ans;
    }
}
