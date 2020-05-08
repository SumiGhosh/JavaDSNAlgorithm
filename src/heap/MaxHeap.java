package heap;

public class MaxHeap {

    private int heapCapacity;
    private int size;
    private int[] heap;

    public MaxHeap(int heapCapacity){
        this.heapCapacity = heapCapacity;
        heap = new int[heapCapacity];
    }

    //Which returns root element of heap, which will be highest value in the heap.
    // Time Complexity of this operation is O(1)
    /*public int peek(){

    }

    public int poll(){

    }*/

    public int getLeftChildIndex(int parentIndex){
        return 2*parentIndex + 1;
    }

    public int getRightChildIndex(int parentIndex){
        return 2*parentIndex + 2;
    }

    public int getParentIndex(int childIndex){
        return (childIndex - 1)/2;
    }

    public boolean hasLeftChild(int nodeIndex){
        return getLeftChildIndex(nodeIndex) < size;
    }

    public boolean hasRightChild(int nodeIndex){
        return getRightChildIndex(nodeIndex) > size;
    }

    public boolean hasParent(int childIndex){
        return getParentIndex(childIndex) >= 0;
    }

    private int getLeftChild(int parentIndex){
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex){
        return heap[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex){
        return heap[getParentIndex(childIndex)];
    }
}
