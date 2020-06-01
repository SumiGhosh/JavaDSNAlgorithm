import datautils.InputUtils;
import greedy.JobScheduleDeadlineGreedyExample;

public class DSAlgorithmMainClass {

    public static void main(String[] args){

        /*MinHeap maxHeap = new MinHeap(10);
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(17);
        maxHeap.add(10);
        maxHeap.add(84);
        maxHeap.add(19);
        maxHeap.add(6);
        maxHeap.add(22);
        maxHeap.add(9);*/
        // maxHeap.printHeapArray();

        /*maxHeap.poll();
        maxHeap.printHeapArray();*/

        //new KnapsackGreedyExample(InputUtils.profitArray,InputUtils.weightArray,InputUtils.maxCapacity);
        new JobScheduleDeadlineGreedyExample(InputUtils.jobIds1, InputUtils.deadlines1, InputUtils.jobProfits1);
        new JobScheduleDeadlineGreedyExample(InputUtils.jobIds2, InputUtils.deadlines2, InputUtils.jobProfits2);
    }
}
