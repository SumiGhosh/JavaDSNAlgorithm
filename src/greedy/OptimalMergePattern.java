package greedy;

/*
* Explanation and sample question
*
* Given n number of sorted files, the task is to find the minimum computations done to reach
 * Optimal Merge Pattern.

When two or more sorted files are to be merged all together to form a single file, the minimum
 computations done to reach this file are known as Optimal Merge Pattern.

If more than 2 files need to be merged then it can be done in pairs. For example, if need to merge 4 files A, B, C, D.
First Merge A with B to get X1, merge X1 with C to get X2, merge X2 with D to get X3 as the output file.




Node represents a file with a given size also given nodes are greater than 2

Add all the nodes in a priority queue (Min Heap).{node.weight = file size}
Initialize count = 0 // variable to store file computations.
Repeat while (size of priority Queue is greater than 1)
create a new node
new node = pq.poll().weight+pq.poll().weight;//pq denotes priority queue,
 remove 1st smallest and 2nd smallest element and add their weights to get a new node
count += node.wight
add this new node to priority queue;
count is the final answer

*/

import java.util.PriorityQueue;

public class OptimalMergePattern {

    public OptimalMergePattern(int capacity, int[] files) {
        mergeWithMinimum(capacity, files);
    }

    private void mergeWithMinimum(int capacity, int[] files) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(capacity);
        for (int index = 0; index < capacity; index++) {
            priorityQueue.add(files[index]);
        }

        int count = 0;
        while (priorityQueue.size() > 1) {
            //Find two smallest file to merge
            int temp = priorityQueue.poll() + priorityQueue.poll();

            count += temp;
            priorityQueue.add(temp);
        }

        System.out.println("Minimum computation required to merge the files: " + count);
    }

}
