package heap;

/*
* A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as an array.
The root element will be at Arr[0].
Below shows indexes of other nodes for the ith node, i.e., Arr[i]:
• Arr[(i-1)/2] : Returns the parent node
• Arr[(2*i)+1] : Returns the left child node
• Arr[(2*i)+2] : Returns the right child node
*/

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    private int heapCapacity;
    private int size;
    private int[] heap;

    public MinHeap(int heapCapacity) {
        this.heapCapacity = heapCapacity;
        heap = new int[heapCapacity];
    }

    /*Which returns root element of heap, which will be highest value in the heap.
     Time Complexity of this operation is O(1)*/
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    /*Removes the maximum element from MaxHeap. Time Complexity of this Operation is O(Logn)
    as this operation needs to maintain the heap property (by calling heapify()) after removing root
    */
    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int nodeValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return nodeValue;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallIndexValue = getLeftChildIndex(index);

            if (hasRightChild(index) && getRightChildIndex(index) < getLeftChildIndex(index)) {
                smallIndexValue = getRightChildIndex(index);
            }

            if (heap[index] > heap[smallIndexValue]) {
                swapIndex(index, smallIndexValue);
            } else {
                break;
            }

            index = smallIndexValue;
        }
    }

    /*Inserting a new key takes O(Logn) time. We add a new key at the end of the tree.
    IF new key is smaller than its parent, then we don’t need to do anything.
    Otherwise, we need to traverse up to fix the violated heap property.
    */

    public void add(int item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > heap[index]) {
            swapIndex(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void ensureCapacity() {
        if (size == heapCapacity) {
            heap = Arrays.copyOf(heap, heapCapacity * 2);
            heapCapacity = heapCapacity * 2;
        }
    }

    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public boolean hasLeftChild(int nodeIndex) {
        return getLeftChildIndex(nodeIndex) < size;
    }

    public boolean hasRightChild(int nodeIndex) {
        return getRightChildIndex(nodeIndex) > size;
    }

    public boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private int getLeftChild(int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex) {
        return heap[getParentIndex(childIndex)];
    }

    private void swapIndex(int index1, int index2) {
        int value = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = value;
    }

    public void printHeapArray() {
        for (int index = 0; index < size; index++) {
            System.out.print(" " + heap[index]);
        }
    }

    public int getSize() {
        return size;
    }
}
