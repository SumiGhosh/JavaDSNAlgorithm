import greedy.HuffmanCoding;

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
        maxHeap.add(9);
        maxHeap.printHeapArray();*/

        /*maxHeap.poll();
        maxHeap.printHeapArray();*/

        //new KnapsackGreedyExample(InputUtils.profitArray,InputUtils.weightArray,InputUtils.maxCapacity);
        //new JobScheduleDeadlineGreedyExample(InputUtils.jobIds1, InputUtils.deadlines1, InputUtils.jobProfits1);
        //new JobScheduleDeadlineGreedyExample(InputUtils.jobIds2, InputUtils.deadlines2, InputUtils.jobProfits2);

        //int files[] = {2, 3, 4, 5, 6, 7};
        //new OptimalMergePattern(6, files);

        char[] message = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] frequency = {5, 9, 12, 13, 16, 45};
        new HuffmanCoding(message, frequency);
    }
}
