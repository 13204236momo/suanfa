package com.example.suan;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * LeetCode地址：https://leetcode-cn.com/problems/two-sum/
 */

public class Subject1 {

    /**
     *方法一：暴力破解
     * 通过两层嵌套循环，使数组中的每两个元素依次相加，直至找出和为target的两个元素
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *方法二：借助HashMap实现
     * 1.建立一个空HashMap
     * 2.从头遍历
     * 3.设res与i元素和为target，即res = target - nums[i]
     * 4.将每次循环的元素存入HashMap，key为该元素，value为该元素的下标
     * 5.当下次循环计算出的res已存在与HashMap中，则说明当前的i元素和HashMap中的res元素符合条件，将他们返回
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
