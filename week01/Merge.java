package com.at.wangxu.geektime.week1;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明：

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例：

输入：
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出：[1,2,2,3,5,6]
 

提示：

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0;
        int r = 0;
        while (l < m || r < n) {
            if (l == m) {
                while (r < n) {
                    nums1[l ++] = nums2[r ++];
                }
                return;
            }else if(r == n){
                return;
            }else {
                if (nums1[l] <= nums2[r]) {
                    l ++;
                }else {
                    insertArray(nums1,l,nums2[r]);
                    m ++;
                    r ++;
                }
            }
        }
    }

    public void insertArray(int[] array,int x,int y) {
        System.arraycopy(array, x, array, x + 1, array.length - x - 1);
        array[x] = y;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge.merge(nums1,3,nums2,3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
    
}
