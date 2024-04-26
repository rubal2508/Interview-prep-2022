# DSA Heaps Notes

### [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/) ⭐️⭐️

- Smaller elements add to leftHeap (Max heap), bigger elements add to right heap (Min heap)
- Rebalance: keep taking from left and add to right until size difference is <= 1, similarly keep taking from right and add to left until size difference is <= 1

### [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)

- Hashmap to store the frequencies then make a k size priority queue of pairs having key value pairs where key is element and value is freq. make a custom comparator

### [Design Twitter](https://leetcode.com/problems/design-twitter/description/) ⭐️
- Similar to merge k sorted lists


### [Task Scheduler](https://leetcode.com/problems/task-scheduler/description/) ⭐️⭐️

> You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time. Return the minimum number of intervals required to complete all tasks.

- Add all the task letters in the heap sorted by their frequencies
- Take out top n elements from heap, reduce ther frequecy and add back to heap
- Ans += n
- Repeat until heap is empty

### [Sliding Window Median](https://leetcode.com/problems/sliding-window-median/description/)

- Too Hard











