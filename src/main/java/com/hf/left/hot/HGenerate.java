package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/31 09:46
 * @version: 1.0
 */
public class HGenerate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(0, Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> levels = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    levels.add(1);
                } else {
                    levels.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(levels);
        }
        return ans;
    }

    public static void main(String[] args) {
        new HGenerate().generate(2);
    }
}
