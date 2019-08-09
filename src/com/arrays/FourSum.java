package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array, find four integers a,b,c,d such that a+b+c+d = target.
The solution set must not contain duplicate quadruplets.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] s = {1,3,5,7,3,6,4,7,4};
        int t = 11;
        List<List<Integer>> res = fourSum(s,t);
        for (int i = 0;i<res.size();i++)
            System.out.println(res.get(i));
    }
    public static List<List<Integer>> fourSum(int[] s,int t)
    {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = s.length;
        if(s == null || n<4)
            return res;
        Arrays.sort(s);
        int max = s[n-1];
        if(4*s[0]>t || 4*max<t)
            return res;
        int i,z;
        for(i = 0;i<n;i++){
            z = s[i];
            //avoid duplicate
            if(i>0 && z==s[i-1])
                continue;
            //z is too small
            if(z+3*max<t)
                continue;
            //z is too large
            if(4*z>t)
                continue;
            if(4*z==t)
            {
                if(i+3<n && s[i+3]==z)
                    res.add(Arrays.asList(z,z,z,z));
                break;
            }
            threeSum(s, t-z,i+1,n-1,res,z);
        }
        return res;
    }
    public static void threeSum(int[] s,int t, int l,int h, ArrayList<List<Integer>> res, int z1)
    {
        if(l+1>=h)
            return;
        int max = s[h];
        if(3*s[l]>t || 3*max<t)
            return;
        int i,z;
        for (i=0;i<h-1;i++)
        {
            z = s[i];
            //avoid duplicate
            if(i>0 && z==s[i-1])
                continue;
            //z is too small
            if(z+2*max<t)
                continue;
            //z is too large
            if(3*z>t)
                continue;
            if(3*z==t)
            {
                if(i+1<h && s[i+2]==z)
                    res.add(Arrays.asList(z1,z,z,z));
                break;
            }
            towSum(s, t-z,i+1,h,res,z1,z);
        }
    }
    public static void towSum(int[] s,int t, int l, int h, ArrayList<List<Integer>> res,int z1, int z2)
    {
        if(l>=h)
            return;
        if(2*s[l]>t || 2*s[h]<t)
            return;
        int i = l, j = h, sum, x;
        while (i<j){
            sum = s[i] + s[j];
            if(sum==t)
            {
                res.add(Arrays.asList(z1,z2,s[i],s[j]));
                x = s[i];
                while (++i < j && x==s[i])
                    //avoid duplicate
                    ;
                x = s[j];
                while (i<--j && x==s[j])
                    //avoid duplicate
                    ;
            }
            if(sum<t)
                i++;
            if(sum>t)
                j--;
        }
        return;
    }
}
