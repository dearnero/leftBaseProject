package com.hf.left.algorithms.tree;

import java.util.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/4 10:28
 * @version: 1.0
 */
public class MinMutation433 {

    public int minMutation(String startGene, String endGene, String[] bank) {

        if (startGene.equals(endGene)){
            return 0;
        }
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)){
            return -1;
        }
        char[] temp = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(startGene);
        Deque<String> records = new LinkedList<>();
        records.offerLast(startGene);
        int index = 1;
        while (!records.isEmpty()){
            int size = records.size();
            for (int tt = 0; tt < size; tt++) {
                String pollFirst = records.pollFirst();
                for (int i = 0; i < pollFirst.toCharArray().length; i++) {
                    for (int k = 0; k < temp.length; k++) {
                        char[] charArray = pollFirst.toCharArray();
                        charArray[i] = temp[k];
                        String aa = new String(charArray);
                        if (bankSet.contains(aa) && !visitedSet.contains(aa)){
                            if (aa.equals(endGene)){
                                return index;
                            }
                            visitedSet.add(aa);
                            records.add(aa);
                        }
                    }
                }
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        new MinMutation433().minMutation("AACCGGTT", "AACCGGTA",  new String[]{"AACCGGTA"});
    }
}
