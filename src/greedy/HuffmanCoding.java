package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public HuffmanCoding(char[] message, int[] frequency) {
        createHuffmanCode(message, frequency);
    }

    private void createHuffmanCode(char[] message, int[] frequency) {
        //Step 1: First we need to create a tree of min heap/priority queue, so the lowest frequency will come first
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(message.length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.frequency - o2.frequency;
            }
        });

        //Each node added with data into priority queue
        for (int index = 0; index < message.length; index++) {
            Node node = new Node();
            node.frequency = frequency[index];
            node.data = message[index];
            node.left = null;
            node.right = null;
            priorityQueue.add(node);
        }

        Node rootNode = null;

        while (priorityQueue.size() > 1) {
            Node minFile1 = priorityQueue.peek();
            priorityQueue.poll();

            Node minFile2 = priorityQueue.peek();
            priorityQueue.poll();

            Node newFile = new Node();
            newFile.data = '-';
            newFile.frequency = minFile1.frequency + minFile2.frequency;

            newFile.left = minFile1;
            newFile.right = minFile2;

            rootNode = newFile;
            priorityQueue.add(newFile);
        }

        printHuffmanCode(rootNode, "");
    }

    private void printHuffmanCode(Node root, String message) {
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
            System.out.println(root.data + " : " + message);
            return;
        }

        printHuffmanCode(root.left, message + "0");
        printHuffmanCode(root.right, message + "1");
    }

    class Node {
        int frequency;
        char data;

        Node left;
        Node right;
    }
}
