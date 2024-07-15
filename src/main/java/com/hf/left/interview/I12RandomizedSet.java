package com.hf.left.interview;

import java.util.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 14:56
 * @version: 1.0
 */
public class I12RandomizedSet {

    List<Integer> nums;

    Map<Integer, Integer> indices;

    Random random;

    public I12RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)){
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    /**
     * 保证数组中间值的移除操作，不会影响到数组的连续性
     */
    public boolean remove(int val) {
        if (!indices.containsKey(val)){
            return false;
        }
        // 1. 获取待删除值的索引
        Integer index = indices.get(val);
        // 2. 获取到数组最后一位
        int last = nums.get(nums.size() - 1);
        // 3. 将数组最后一位，复制给待删除值索引位
        nums.set(index, last);
        // 4. 更新索引map中最后一位值的索引
        indices.put(last, index);
        // 5. 移除最后一位置
        nums.remove(nums.size() - 1);
        // 6. 移除目标值的索引
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
