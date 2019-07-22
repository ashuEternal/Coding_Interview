package com.arrays;
import java.util.HashMap;

/*
Given an array A and a key K, find the indexes of the two elements of array whose sum is equal to K
Time Complexity: O(n)
*/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr={1,5,7,9,10,11,15};
        int n = arr.length;
        int k = 8;
        int[] sol = twoSum(arr,n,k);
        System.out.print(sol[0]+" "+sol[1]);
    }
    private static int[] twoSum(int[] a,int n,int k)
    {
        int[] res = new int[2];
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i = 0;i<n;i++)
        {
            Integer x = h.get(k-a[i]);
            if(x==null)
            {
                h.put(a[i],i);
            }
            else
            {
                res[0]=x;
                res[1]=i;
            }
        }
        return res;
    }
}
