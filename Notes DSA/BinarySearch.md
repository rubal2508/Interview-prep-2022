# Binary Search

### [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/description/)

- Assume whole matrix is a linear array

### [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/) ⭐️
- Easily done

### [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/) ⭐️
- First check if `m` is on left incline or right
- Then check whether target is towards its left or right

### [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/) 
- Assume `nums[0]` is min, then do binary search
- if `m` is on left incline move right, else move left


### [Time Based Key Value Store](https://leetcode.com/problems/time-based-key-value-store/description/)	⭐️⭐️

- Use tree maps and .floorEntry() instead of binary search
- Very good question
- `HashMap<String, TreeMap<Integer,String>> hmap`

### [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/) ⭐️⭐️⭐️
- If we partition array1 into left and right, then we automatically know the size of left and righ partitions in array2. Because `left1+left2 == right1 + right2` for median
- use binary search on array1 to get the partion index `m` and see if it is correct or not
- Make sure to handle the corner cases such as either array is null or partion is on any array's edge


### [Magnetic Force Between Two Balls](https://leetcode.com/problems/magnetic-force-between-two-balls/description/) / [Aggressive cows](https://www.spoj.com/problems/AGGRCOW/) ⭐️
- Able to do in first try
