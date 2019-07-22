package com.arrays;

/*
Given non-negative integer a1,a2,.....an, where each represent a point at co-ordinate (i,ai). n vertical lines
are drawn such that the two end points of line i is at (i,ai) and (i,0).Find two lines for which the container
figure will have maximum capacity(assume all points have equal z co-ordinates);
 */

public class MostVolumeContainer {
    public static void main(String[] args) {
        int[] height = {4,5,9,7,3,6,8,10,15};
        System.out.println(maxArea(height));
    }
    private static int maxArea(int[] h)
    {
        int l = 0,r = h.length-1;
        int max = 0;
        while (l<r)
        {
            max=Math.max(max,Math.min(h[l],h[r])*(r-l));
            if(h[l]<h[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
