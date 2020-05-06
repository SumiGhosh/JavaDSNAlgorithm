package binarysearch;

import datautils.InputUtils;

public class BinarySearchRecursive {

    public BinarySearchRecursive(){
        findTheIndexOfElementThroughRecursive(0,
                InputUtils.sortedArray.length-1,
                InputUtils.arrayKeyToBeFound2,
                InputUtils.sortedArray);
    }

    private void findTheIndexOfElementThroughRecursive(int low,int high,int key,int[] arr){
        int mid = (low+high)/2;
        if(low==high){
            if(key==arr[mid]){
                System.out.println("Element found at index : "+ mid);
            } else {
                System.out.println("Element "+key+" is not in the array.");
            }
        } else {
            if(key==arr[mid]){
                System.out.println("Element found at index : "+ mid);
            } else if(arr[mid]>key){
                findTheIndexOfElementThroughRecursive(low,mid-1,key,arr);
            } else if(arr[mid]<key){
                findTheIndexOfElementThroughRecursive(mid+1,high,key,arr);
            }
        }
    }
}
