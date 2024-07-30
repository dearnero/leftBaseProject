package com.hf.left.hot;

import java.util.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/30 10:56
 * @version: 1.0
 */
public class HCanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            Integer pop = deque.pop();
            numCourses--;
            for (Integer cur : adjacency.get(pop)) {
                if (--indegrees[cur] == 0){
                    deque.offer(cur);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        new HCanFinish().canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}});
    }
}
