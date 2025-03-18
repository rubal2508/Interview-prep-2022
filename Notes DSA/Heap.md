# Heaps

- Last finished 4 feb

### [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/) ⭐️⭐️

- Smaller elements add to leftHeap (Max heap), bigger elements add to right heap (Min heap)
- Rebalance: keep taking from left and add to right until size difference is <= 1, similarly keep taking from right and add to left until size difference is <= 1

### [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)

- Hashmap to store the frequencies then make a k size priority queue of pairs having key value pairs where key is element and value is freq. make a custom comparator

### [Design Twitter](https://leetcode.com/problems/design-twitter/description/) ⭐️
- Similar to merge k sorted lists


### [Task Scheduler](https://leetcode.com/problems/task-scheduler/description/) ⭐️⭐️

> You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time. Return the minimum number of intervals required to complete all tasks.

- Add all the task letters in the heap sorted by their frequencies (max heap)
- Take out top n elements from heap, reduce ther frequecy and add back to heap
- Ans += n
- Repeat until heap is empty

### [Sliding Window Median](https://leetcode.com/problems/sliding-window-median/description/)

- TODO Too Hard


<br><br><br><br>

## Max Heap Code

``` java
import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[index] > heap[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex < size && heap[leftChildIndex] > heap[maxIndex]) {
            maxIndex = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] > heap[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (index != maxIndex) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(2);
        maxHeap.insert(10);

        System.out.println("Max heap:");
        maxHeap.printHeap();

        System.out.println("Extracting max: " + maxHeap.extractMax());
        System.out.println("Max heap after extraction:");
        maxHeap.printHeap();
    }
}
```










