package com.hf.left.hot;

/**
 * @description: 只出现一次的数字
 * @link <a href = "https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked">只出现一次的数字</a>
 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
 * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
 * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 * @author: huang fu
 * @date: 2024/8/24 20:43
 * @version: 1.0
 */
public class HSingleNumber {

    public int singleNumber(int[] nums){
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
