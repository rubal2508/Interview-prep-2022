# Bitwise

- `&` `|` `~` `^` `<<` `>>`
- `a<<1` means `a * 2^1` &  `a<<2` means `a * 2^2`
- `a>>1` means `a / 2^1` &  `a>>2` means `a / 2^2`

### Time complexity of operations
- Complexity of * = $O(n^2)$
- Complexity of % = $O(n^3)$
- Complexity of bitwise = $O(n)$



### Find unique number
`int[] nums` where all elements occur twice except 1, find it.
- Take XOR of all the elements

### Check Odd/Even
- `n&1 == 1` ODD
- `n&1 == 0` EVEN

### Minimum number of bits to convert numA to numB
- Count the set bits in `numA ^ numB`

### Count number of set bits in n ⭐️

``` java
while(n>0){
    count += (n&1);
    n == n>>1;
}
```

``` java
while(n>0){
    count ++;
    n == n&(n-1);
}
```
``` java
NumberOfSetBits[n] = NumberOfSetBits[ n & (n-1) ] + 1
```

### Swapping two numbers without using a third variable ⭐️

``` java
a = a^b;
b = b^a;
a = a^b
```

### Extracting ith bit from right
- Assume rightmost (least significant) bit at `0`th and leftmost as `n-1`th
- `n & (1<<i)`

### Change ith bit to 1
- `n = n | (1<<i)`


### Change ith bit to 0
- Make a mask like `11101111` and take `&` wiith it
- `n = n & ~(1<<i)`

### all subsequences of a string of length n
- Number of subsequences = $2^n-1$ or `(1<<n)-1`
- Iterate over all numbers from 0 to $2^n-1$

### [Single Number III](https://leetcode.com/problems/single-number-iii/description/) ⭐️⭐️
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. 

- Take XOR of all numbers, lets say we got a number k
- find the rightmost set bit of k (lets say its jth bit)
- Divide the array into two parts, one of all the numbers which have jth bit set and second of all the numbers where jth bit is not set
- Take XOR of two parts, you will get the number


### [Single Number II](https://leetcode.com/problems/single-number-ii/description/) ⭐️
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

- Add number of bits at each position, it will be either `3n` or `3n+1` take modulo with 3 at each bit 

``` java
class Solution {
    public int singleNumber(int[] nums) {

        // Loner
        int loner = 0;

        // Iterate over all bits
        for (int shift = 0; shift < 32; shift++) {
            int bitSum = 0;

            // For this bit, iterate over all integers
            for (int num : nums) {

                // Compute the bit of num, and add it to bitSum
                bitSum += (num >> shift) & 1;
            }

            // Compute the bit of loner and place it
            int lonerBit = bitSum % 3;
            loner = loner | (lonerBit << shift);
        }
        return loner;
    }
}
```


### [Missing Number](https://leetcode.com/problems/missing-number/description/)

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
- Take XOR of all, then take XOR from 0 to n 


### [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/description/)
Given two integers a and b, return the sum of the two integers without using the operators + and -
- Kinda hard, skipped


### [Reverse Bits](https://leetcode.com/problems/reverse-bits/description/)

Reverse bits of a given 32 bits unsigned integer.
- Simple left shift right shift and AND operators

``` java
for(int i=0; i<32; i++){
    sol = sol<<1;
    sol = sol | (n&1);
    n = n>>1;
}
```

### [Reverse Integer](https://leetcode.com/problems/reverse-integer/description/)

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0. 
- Simple reverse using `/10` `%10` and `*10`
- Keep a check of overflow at each step


