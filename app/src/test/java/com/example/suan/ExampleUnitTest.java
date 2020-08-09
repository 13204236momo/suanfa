package com.example.suan;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //int[] a = {1,1,2,3,4,4};
        //System.out.println( removeDuplicates(a));
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println( maxArea(a));

    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    public int maxArea(int[] height) {
       if (height.length<2){
           return 0;
       }else {
           int i = 0;
           int j = height.length-1;
           int res = 0;
           while (i<j){
               res = height[i]<height[j]?Math.max(res,(j-i)*height[i++]):Math.max(res,(j-i)*height[j--]);
           }
           return res;
       }


    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();


        for(int i = 0;i<nums.length;i++){
            int res = target - nums[i];
            if(map.containsKey(res)){
                return new int[]{i,res};
            }else{
                map.put(nums[i],i);
            }
        }
        return null;
    }
}