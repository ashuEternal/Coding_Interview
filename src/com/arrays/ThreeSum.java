package com.arrays;
/*Given an array of integers. Find three elements a,b,c from the array
such that a+b+c = 0.
 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] s = {3,5,7,9,-8,2,-6};
        List<List<Integer>> res = threeSum(s);
        for(int i = 0;i<res.size();i++)
        {
            System.out.println(res.get(i));
        }
    }
    public static List<List<Integer>> threeSum(int[] s)
    {
        Arrays.sort(s);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0;i<s.length-2;i++)
        {
            if(i==0||(i>0 && s[i]!=s[i-1])){
                int l = i+1,h = s.length-1,sum = 0-s[i];
                while (l<h)
                {
                    if(s[l]+s[h]==sum) {
                        res.add(Arrays.asList(s[i], s[l], s[h]));
                        while(l<h && s[l]==s[l+1]) l++;
                        while(l<h && s[h]==s[h-1]) h--;
                        l++; h--;
                    }
                    else if(s[l] + s[h] < sum) l++;
                    else h--;
                }
            }
        }
        return res;
    }
}
