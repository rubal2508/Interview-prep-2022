# Greedy and Intervals

### [Maximum Subarray Sum](https://leetcode.com/problems/maximum-subarray/) ⭐️
- Kedane's algo

``` java
public int maxSubArray(int[] nums) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;

    for(int i=0; i<nums.length; i++){
        currSum += nums[i];
        maxSum = Math.max(maxSum, currSum);
        if(currSum<0) currSum = 0;
    }

    return maxSum;
}
```


### [Jump Game](https://leetcode.com/problems/jump-game/description/)
- Keep a right Max pointer

### [Jump Game II](https://leetcode.com/problems/jump-game-ii/description/) ⭐️⭐️
- Slightly tricky
- What is the range you can reach from each jump?










<br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br>
<br><br><br><br><br>


Neetcode :

- Gas Station : tricky, not intuitive
- Hand of Straights : tricky
- Merge Triplets to Form Target Triplet : tricky
- Partition Labels : tricky but did own my own
- Valid Parenthesis String : tricky





Greedy :

1. Activity Selection : sort by finishing time, always take the first activity and then so on 

2. Fractional Knapsack 

3. Job Sequencing : take most profitable job first and do it as late as possible

4. Huffman Coding (TODO)


Intervals

- Insert Interval : medium, did it on my own 
- Merge Intervals : medium, did it on my own 
- Non-overlapping Intervals : saw video 
- Minimum Interval to Include Each Query : Heap is used, saw sol 
 