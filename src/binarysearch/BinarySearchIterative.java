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

public class BinarySearchIterative {

    int[] elements = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    int keyToFound1 = 6;
    int keyToFound2 = 23;

    public BinarySearchIterative(){
        findIndexOfElementInArray(elements,keyToFound1);
        System.out.println("**********************************************************************");
        findIndexOfElementInArray(elements,keyToFound2);
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
