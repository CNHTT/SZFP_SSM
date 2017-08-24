package com.extra.utils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Extra on 2017/8/17.
 * GitHub cnhttt@163.com
 * Work to SZFP
 */
public class Client {
    public static int binarySearch(int[] array, int target) {
        int startIndex = 0,
                endIndex = array.length - 1,
                middleIndex = (endIndex - startIndex) / 2 + startIndex;

        while(startIndex <= endIndex) {
            // 根据以下方法定义中间元素，会导致中间元素总会偏左侧
            // 例如两个元素时，有 1 / 2 + startIndex = startIndex
            // 当连续若干个元素相等时，总会找到偏右侧的
            middleIndex = (endIndex - startIndex) / 2 + startIndex;
            if (array[middleIndex] == target) {
                return middleIndex;
            } else if (array[middleIndex] < target) {
                startIndex = middleIndex + 1;    // 假设数组正序，中间元素比目标元素小，则在右侧（更大一侧）继续查找
            } else {
                endIndex = middleIndex - 1;    // 大于目标元素，则在左侧（更小一侧）查找
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(Client.binarySearch(a, 1));
//        System.out.println(Client.binarySearch(a, 2));
//        System.out.println(Client.binarySearch(a, 3));
//        System.out.println(Client.binarySearch(a, 4));
//        System.out.println(Client.binarySearch(a, 5));
//        System.out.println(Client.binarySearch(a, 6));
//        System.out.println(Client.binarySearch(a, 7));
//        System.out.println(Client.binarySearch(a, 8));
//        System.out.println(Client.binarySearch(a, 9));
//        System.out.println(Client.binarySearch(a, 10));
//        System.out.println(Client.binarySearch(a, 11));

        int[] a = { 13, 12, 11, 23, 9, 8, 7, 6, 5, 4, 5, 2, 1 };
        Client.sortA(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();

    }

    public static  void sortA(int[] arrayToSort){

        int leftIndexStart;
        int leftIndexEnd;
        int rightIndexStart;
        int rightIndexEnd;

        int midIndex = arrayToSort.length/2;
        leftIndexStart=0;
        leftIndexEnd = midIndex;
        rightIndexStart  = midIndex+1;
        rightIndexEnd = arrayToSort.length-1;

        int [] tmp = new int[arrayToSort.length];
        //递归   《《
        sortPart(arrayToSort,tmp,leftIndexStart,leftIndexEnd);


        //>>

        sortPart(arrayToSort,tmp,rightIndexStart,rightIndexEnd);


        merge(arrayToSort,tmp,leftIndexStart,leftIndexEnd,rightIndexStart,rightIndexEnd);
    }

    private static void merge(int[] arrayToSort, int[] tmp, int leftIndexStart, int leftIndexEnd, int rightIndexStart, int rightIndexEnd) {
        int leftIndex = leftIndexStart,
                rightIndex = rightIndexStart,
                tmpIndex = leftIndexStart;

        while(leftIndex<=leftIndexEnd && rightIndex <= rightIndexEnd){
            if (arrayToSort[leftIndex]<arrayToSort[rightIndex]){
                tmp[tmpIndex] =arrayToSort[leftIndex];
                tmpIndex++;
                leftIndex++;
            }else {
                tmp[tmpIndex] =arrayToSort[rightIndex];
                tmpIndex++;
                rightIndex++;
            }
        }

        // 交替遍历后，有可能一侧剩余下不定数量元素，继续将剩余元素填充进tmp
        while(leftIndex <= leftIndexEnd) {
            tmp[tmpIndex] = arrayToSort[leftIndex];
            tmpIndex++;
            leftIndex++;
        }
        // 交替遍历后，有可能一侧剩余下不定数量元素，继续将剩余元素填充进tmp
        while(rightIndex <= rightIndexEnd) {
            tmp[tmpIndex] = arrayToSort[rightIndex];
            tmpIndex++;
            rightIndex++;
        }

        // 将tmp中按顺序填充好的元素覆盖到原数组相应元素上
        for(int i = leftIndexStart; i <= rightIndexEnd; i ++) {
            arrayToSort[i] = tmp[i];
        }


    }

    private static void sortPart(int[] array, int[] tmp, int left, int right) {
        int leftIndexStart;
        int leftIndexEnd;
        int rightIndexStart;
        int rightIndexEnd;

        if ((right-left)<1){
            return;
        }

        int midIndex = (right+left)/2;
        leftIndexStart = left;
        leftIndexEnd = midIndex;
        rightIndexStart = midIndex+1;
        rightIndexEnd = right;

        sortPart(array,tmp,leftIndexStart,leftIndexEnd);
        sortPart(array,tmp,rightIndexStart,rightIndexEnd);
        merge(array,tmp,leftIndexStart,leftIndexEnd,rightIndexStart,rightIndexEnd);

    }
}