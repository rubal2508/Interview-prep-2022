# DP

## NeetCode.io 1D DP

- Last done Nov 2024

### [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/description/)
You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top? 


### [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/description/)

You are given an integer array cost where `cost[i]` is the cost of `ith` step on a staircase. Once you pay the cost, you can either climb one or two steps. You can either start from the step with index `0`, or the step with index `1`. Return the minimum cost to reach the top of the floor.


### [House Robber](https://leetcode.com/problems/house-robber/description/)

Array of houses, cant steal from adjacent houses. Given an integer array `nums` representing the amount of money of each house, return the maximum amount of money you can rob.
- `dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2])`


### [House Robber II ⭐️](https://leetcode.com/problems/house-robber-ii/description/)

All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
- Solve once for `0` to `n-2` then for `1` to `n-1`


### [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/) ⭐️

Given a string s, return the longest palindromic substring in s.

- Go to each position in s, then expand from middle and see how far can you go. Consider both odd and even length palindroms while expanding

### [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/description/)

Given a string s, return the number of palindromic substrings in it.

- Expand on each character, add to total

### [Decode Ways](https://leetcode.com/problems/decode-ways/description/) ⭐️

Given a string s containing only digits, return the number of ways to decode it.
For example, `"11106"` can be mapped into: 
- `"AAJF"` with the grouping `(1 1 10 6)` 
- `"KJF"` with the grouping `(11 10 6)`
- `(1 11 06)` is invalid because `"06"` cannot be mapped into `'F'` since `"6"` is different from `"06"`

- Hint: `dp[i] = dp[i-1] + dp[i-2]` (Make sure to consider all edge cases whether you can pick 1 number or two numbers

### [Coin Change](https://leetcode.com/problems/coin-change/description/)

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. Assume that you have an infinite number of each kind of coin.

- Use `long` instead of `int`, initialise dp with `Integer.MAX_VALUE`
- `dp[sum] = Math.min(dp[sum], 1 + dp[sum-coin])`;


### [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/description/) ⭐️⭐️

Given an integer array nums, find a subarray that has the largest product, and return the product.


``` java
public int maxProduct(int[] nums) {
    int curMax = 1;
    int curMin = 1;
    int ans = Integer.MIN_VALUE;

    for(int n : nums){
        ans = Math.max(ans,n);
    }

    for(int num : nums){
        
        if(num == 0){
            curMax = 1;
            curMin = 1;
            continue;
        }

        int temp1 = curMax * num ;
        int temp2 = curMin * num ;


        curMax = Math.max(num, Math.max(temp1, temp2));
        curMin = Math.min(num, Math.min(temp1, temp2));

        ans = Math.max(ans, curMax);
    }

    return ans;
}
```

### [Word Break](https://leetcode.com/problems/word-break/description/)

Given a string `s` and a dictionary of strings `wordDict`, return `true` if `s` can be segmented into a space-separated sequence of one or more dictionary words. Note that the same word in the dictionary may be reused multiple times in the segmentation.

- Add all the wordDict in a set
- Try to break the word and each `i` and recursevely solve for `s[i+1 : n]`


### [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/description/) ⭐️

Given an integer array `nums`, return `true` if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or `false` otherwise.

- A variation of 0-1 knapsack. Take sum(arr)/2 as goal and see if you can make a knapsack of this sum
- Total of arr should be even
- Create a set of all possible sums of all subarrays and see of we hit the target (Slightly tricky to think) 


<br><br>

## NeetCode.io 2D DP

### [Unique Paths](https://leetcode.com/problems/unique-paths/description/)
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

### [Coin Change II](https://leetcode.com/problems/coin-change-ii/description/)
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

- `dp[currAmount][coin_i] =  dp[currAmount][coin_i-1] + dp[currAmount - coins[coin_i]][coin_i]`


### [Target Sum](https://leetcode.com/problems/target-sum/description/) ⭐️
You are given an integer array `nums` and an integer `target`. Return the number of different expressions that you can build using +/-, which evaluates to `target`. For example, if `nums = [2, 1]`, you can add a `'+'` before `2` and a `'-'` before `1` and concatenate them to build the expression `"+2-1"`.

- No hint needed, can be done (Wasnt able to do after 6 months)
- `return foo(nums, currSum-nums[i], target, i+1) + foo(nums, currSum+nums[i], target, i+1)`

### [Interleaving String](https://leetcode.com/problems/interleaving-string/description/) ⭐️
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

- Can be done, no specific hint needed

- `dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1])`

### [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/) ⭐️

Given an `m x n` integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

- `dp[i][j]` will store length of longest path starting from `matrix[i][j]`;
- call `foo` on each `(i,j)`
- `foo(i,j)` will recursevely call on all directions and select the direction with longest path

### [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/description/) ⭐️

Given two strings s and t, return the number of distinct subsequences of s which equals t.

- Slightly tricky base case but doable

``` java 
if(s.charAt(i) == t.charAt(j)){
    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
}
else dp[i][j] = dp[i-1][j];
```

### [Edit Distance](https://leetcode.com/problems/edit-distance/description/)

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
Operations: insert, replace, delete

```java
if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
else dp[i][j] = 1 + Math.min( Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1] );
```

### [Burst Balloons](https://leetcode.com/problems/burst-balloons/description/) ⭐️⭐️⭐️⭐️
Return the maximum coins you can collect by bursting the balloons wisely.

- Quite hard
- For each ballon think what is it was burst last, and divide left and right array and solve recursevely
- if `ith` balloon is burst last then, `res = l*nums[i]*r + foo(l,i-1) + foo(i+1,r)`

### [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/description/) ⭐️⭐️ 
- TODO

<br><br>

## Variations of Longest Increasing Subsequence

### [Finding length of LCS](https://leetcode.com/problems/longest-increasing-subsequence/description/)

Given an integer array nums, return the length of the longest strictly increasing 
subsequence. A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

- 1D DP
- $O(n^2)$ time complexity
  - Initialise `dp[i] = 1` then, For each element `arr[i]`:
    - Check the length of LIS ending at i
    - `dp[i] = 1 + max(dp[j])` where `j<i and arr[j] < arr[i]`
- $O(nlogn)$ solution also exists: ⭐️⭐️⭐️
  - `dp[i]` will store the minimum possible element in the LIS of length `i+1`
  - for each element `arr[i]`:
    - if `dp.getLast() < arr[i]` then `dp.add(arr[i])`
    - else replace `arr[i]` with `dp[j]` such that `dp[j]` is smallest greater element (ceiling element)
  - length of dp is answer



### [Minimum number of deletions to make a sorted sequence](https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1)

Given an array arr of size N, the task is to remove or delete the minimum number of elements from the array so that when the remaining elements are placed in the same sequence order form an strictly increasing sorted sequence.

- Same as 1.1

### [Maximum sum increasing subsequence](https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1) ⭐️

Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence. 

- In 1.1 we consider the weight of each element as 1 (as we are only caring about length), here we will use weight as actual value and use that to maximize
- 1D DP
- O($n^2$) time complexity
- Initialise `dp[i] = arr[i]` then, For each element `arr[i]` :
  - Check the sum of LIS ending at i
  - `dp[i] = arr[i] + max(dp[j])` where `j<i and arr[j] < arr[i]`



### [Longest Bitonic Subsequence](https://www.geeksforgeeks.org/longest-bitonic-subsequence-dp-15/) ⭐️

Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence. 
A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly, decreasing order sequence is considered Bitonic with the increasing part as empty.

- Find LIS array
- Find longest decreasing subsequence array (begining with every element) or reverse the array and find LIS 
- Iterate the two arrays and see where `lis[i] + lds[i]` is max


### [Building Bridges](https://www.geeksforgeeks.org/dynamic-programming-building-bridges/) ⭐️

Consider a 2-D map with a horizontal river passing through its center. There are n cities on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with x-coordinates b(1) … b(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. When connecting cities, you can only connect city a(i) on the northern bank to city b(i) on the southern bank. Maximum number of bridges that can be built to connect north-south pairs with the above mentioned constraints.

- Sort the array based on first index, if its same then consider second index 
- Now find LIS based on second value

### [Maximum Length of Pair Chain](https://leetcode.com/problems/maximum-length-of-pair-chain/description/) ⭐️

You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs. 

- Sort the array acc to first value : Do LIS 
- Greedy: Same as activity selection problem : Sort by second value then pick iterately whichever pair can be picked first



<br><br>

## Variations of Longest Common Subsequence

### [Finding the length of LCS](https://leetcode.com/problems/longest-common-subsequence/description/)

Given two strings, S1 and S2, the task is to find the length of the Longest Common Subsequence, i.e. longest subsequence present in both of the strings.

- 2D dp of size $n$x$m$ where $n$ is size of s1 and $m$ is size of s2
- if `s1[i] == s2[j]` then `dp[i][j] = 1 + dp[i-1][j-1]`
  - else `dp[i][j] = max(dp[i-1][j],dp[i][j-1])`
- We can optimise space by using 1D dp, as we only need pevious column and previous row for each iteration ⭐️⭐️


##### Printing LCS ⭐️

```java
    // assume dp has been made
    StringBuilder sb=new StringBuilder();
    int i=m,j=n;
    while(i>0&&j>0){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            sb.append(s1.charAt(i-1));
            i--;
            j--;
        }
        else if(dp[i-1][j]>dp[i][j-1])i--;
        else j--;
    }
    return sb.reverse().toString();
```



### [Minimum number of deletions and insertions to transform one string into another](https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/)

Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted at some another point. eg: str1 = "heap", str2 = "pea" then Minimum Deletion = 2 and Minimum Insertion = 1

- Find LCS length l
- number of del = str1.length - l
- number of insert = str2.length - l


### [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/description/) ⭐️⭐️⭐️

Given two strings str1 and str2, the task is to find the shortest string that has both str1 and str2 as subsequences.

- If only length to be found then Length of the shortest supersequence  = (Sum of lengths of given two strings) - (Length of LCS of two given strings) 

``` java
public String shortestCommonSupersequence(String s1, String s2) {
    String str=lcs(s1,s2);
    String ans="";
    int p1=0,p2=0,p3=0;
    
    for(char c:str.toCharArray()){
        while(p1<s1.length()&&s1.charAt(p1)!=c){
            ans+=s1.charAt(p1++);
        }
        while(p2<s2.length()&&s2.charAt(p2)!=c){
            ans+=s2.charAt(p2++);
        }
        ans+=c;
        p1++;
        p2++;
        
    }

    if(p1<s1.length())ans+=s1.substring(p1);
    if(p2<s2.length())ans+=s2.substring(p2);
    // ans+=s1.substring(p1)+s2.substring(p2);
    return ans;
}
```

### [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/description/) ⭐️

Given a string s, return the longest 
palindromic subsequence's length in s.

- Reverse `s1` to get `s2`, find LCS of both 
- Another approach: consider a string window `i` to `j` if `s[i] == s[j]` then `dp[i][j] = 2 + dp[i+1][j-1]` else `dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])`



### [Longest repeating subsequence](https://www.geeksforgeeks.org/longest-repeating-subsequence/) ⭐️

Given a string, find the length of the longest repeating subsequence, such that the two subsequences don’t have same string character at the same position, i.e. any ith character in the two subsequences shouldn’t have the same index in the original string. 
e.g. "aabb" : 2, "aaa" : 3

- Normal LCS with this change :
- if `s1[i] == s2[j] && i != j` then `dp[i][j] = 1 + dp[i-1][j-1]`
  - else `dp[i][j] = max(dp[i-1][j],dp[i][j-1])`




<br><br>

## Other DP Problems


### [Egg Drop with 2 eggs and N floors](https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/description/) 

Return the minimum number of moves that you need to determine with certainty what the value of f is
- Go to each floor `i` and try dropping the gg from it. 
- Consider both scenarios : egg breaks (now only 1 egg remains, hence number of attempts needed will be equal to no. of floors) and egg does not break (now only `n-i` floors remain and 2 eggs)
- Assume the worst and take the max of both scenarios and try to minimise the worst

``` java
public int twoEggDrop(int n) {
    if(n <= 1) return n;
    int sol = Integer.MAX_VALUE;

    // iterate each floor and drop egg on it. 
    for(int i=1; i<=n; i++){

        // egg breaks at ith floor, only 1 eggs remains so attempts needed are equal to floors
        int attempts_break = i-1;

        // egg does not break, still two eggs remain. but only n-i floors remain
        int attempts_notBreak = twoEggDrop(n-i);

        // assume the worst
        int ans = 1 + Math.max(attempts_break, attempts_notBreak);

        // minimise the worst
        sol = Math.min(sol, ans);
    }
    return sol;
}
```

### [Super Egg Drop](https://leetcode.com/problems/super-egg-drop/description/) ⭐️⭐️⭐️

n floors, k eggs

- Similar to previous. It will be O(k.n.n)
- More optimal solution exists but I did not understand it

``` java
public int superEggDrop(int k, int n) {
    if(k==1 || n<=1) return n;
    int sol = Integer.MAX_VALUE;
    for(int i=1; i<=n; i++){        
        //egg breaks
        int attempts_break = superEggDrop(k-1, i-1);

        // egg doesnt not break
        int attempts_not_break = superEggDrop(k, n-i);

        // assume the worst
        int ans = 1 + Math.max(attempts_break, attempts_not_break);

        // minimise the worst
        sol = Math.min(sol, ans);
    }
    return sol;
}

```

### [Matrix Chain Multiplication](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1) ⭐️⭐️
Find the min multiplications needed to multiply a chain of matrices
- ref: [Coding blocks](https://www.youtube.com/watch?v=D1U74eFLg_g&ab_channel=CodingBlocks), [Pep Coding](https://www.youtube.com/watch?v=pEYwLmGJcvs&pp=ygUbbWF0cml4IGNoYWluIG11bHRpcGxpY2F0aW9u)
- 2D dp, `dp[i][j]` contains the answer for chain of matrix `i` to `j`
- Iterate the array and try to break the array at each point and do recursion on left and right partition
- ` for(k=i, k<j, k++) foo(i,j) = Min(sol, (foo(i,k) + foo(k+1,j) + arr[i] * arr[k] * arr[j]))` 



### [Best Time to Buy And Sell Stock With Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
- Not very diff but I dont like this ques



### [Optimal Game Strategy](https://leetcode.com/problems/predict-the-winner/description/) / [Stone Game](https://leetcode.com/problems/stone-game/description/) ⭐️⭐️

At each turn, the player takes one of the numbers from either end of the array. Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner

- If size of array is even then player 1 can alway win (he can either pick all odds or all even positions)
- If problem is only asking if player1 can win then dp will be slightly simpler, if problem asks the max possible score of player1 then it will be diff

``` java
class Solution {
    public boolean predictTheWinner(int[] nums) {
        return foo(nums, 0, nums.length-1) >= 0;
    }

    public int foo(int[] nums, int i, int j){
        if(i > j) return 0;
        return Math.max(nums[i] - foo(nums, i+1, j) , nums[j] - foo(nums, i, j-1));
    }
}
```



      
