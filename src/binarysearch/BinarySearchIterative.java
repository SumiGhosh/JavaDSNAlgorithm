package binarysearch;

/*
* Important notes or Summary
*
* In order to perform binary search on an array, the array must be a sorted one.
*
* Need two index points, low anf high
*
* key element to search
*
* find mid = (low+mid)/2
*
* time taken to find an element in minimum possible is O(1) and maximum O(log n)
* */

import datautils.InputUtils;

public class BinarySearchIterative {

    public BinarySearchIterative(){
        findIndexOfElementInArray(InputUtils.sortedArray,InputUtils.arrayKeyToBeFound1);
        System.out.println("**********************************************************************");
        findIndexOfElementInArray(InputUtils.sortedArray,InputUtils.arrayKeyToBeFound2);
    }

    public void findIndexOfElementInArray(int[] arr, int key){
        int elementFoundAtIndex = -1;
        int low = 0;
        int high = arr.length-1;

        while(high>=low){
            int mid = (low+high)/2;
            if(key==arr[mid]){
                elementFoundAtIndex = mid;
                break;
            } else if(arr[mid]>key){
                high = mid - 1;
            }else if(arr[mid]<key){
                low = mid + 1;
            }
        }

        if(elementFoundAtIndex!=-1){
            System.out.println("Element found at index : "+ elementFoundAtIndex);
        } else {
            System.out.println("Element "+key+" is not in the array.");
        }

    }
}
