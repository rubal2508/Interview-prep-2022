# SQL Query notes


- Count charactes of a varchar
   - len(col_name) : count to characters in a column
   - Also look at DATALENGTH() : count number of bytes used by row (counts trailing and leading spaces as well, and some special characters might use more than 1 byte)

        ``` sql
        select tweet_id from tweets where len(content) > 15
        ```

- Find mod
  - where mod(column, 2) = 1  



<br><br><br><br><br><br><br>

## Questions:

-  [Customer Who Visited but Did Not Make Any Transactions](https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/description/) ⭐️
   - Excluding using "not in" or excluding using left join
- [Rising Temperature](https://leetcode.com/problems/rising-temperature/description/) ⭐️
  - Good to learn `datediff(day, w1.recordDate, w2.recordDate) = -1`
- [Average Time of Process per Machine](https://leetcode.com/problems/average-time-of-process-per-machine/description) ⭐️ : Good ques 
- [Employee Bonus](https://leetcode.com/problems/employee-bonus/description) : Easy
- [Students and Examinations](https://leetcode.com/problems/students-and-examinations/description) ⭐️ : Hard
- [Managers with at Least 5 Direct Reports](https://leetcode.com/problems/managers-with-at-least-5-direct-reports/description/) ⭐️ : Med
- [Not Boring Movies](https://leetcode.com/problems/not-boring-movies/description/) : Mod function