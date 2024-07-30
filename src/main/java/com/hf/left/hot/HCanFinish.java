package com.hf.left.hot;

import java.util.*;

/**
 * @description: 207. 课程表
 * 算法: 入度表 + 邻接表 + bfs(广度优先遍历)
 * 1. 入度表：统计每个节点的入度数
 * 2. 邻接表：每个节点执行下一个节点的数组
 * 3. 对于bfs首先处理入度数为0的值
 *  3.1 处理完成之后，从邻接表中获取到下一批节点列表，判断是否可以再入队处理（入度数为0）
 * @link <a href = "https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-100-liked">207. 课程表</a>
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
