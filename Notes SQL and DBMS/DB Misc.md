## Database Concurrency controls
In the context of databases, there are several terms related to concurrency control and transaction isolation. Here are some key ones, including race conditions and dirty reads:

1. **Race Condition**
   - **Definition**: A situation where the system's behavior depends on the sequence or timing of uncontrollable events, such as the order in which database operations are performed.
   - **Example**: Two transactions read the same data and then update it. The final value depends on which transaction completes last, leading to unpredictable results.

2. **Dirty Read**
   - **Definition**: Occurs when a transaction reads data that has been written by another transaction that has not yet been committed.
   - **Example**: Transaction A writes a value to the database but hasn’t committed yet. Transaction B reads this uncommitted value. If Transaction A rolls back, Transaction B has read a value that never actually existed.

3. **Non-Repeatable Read**
   - **Definition**: Happens when a transaction reads the same row twice and gets different values because another transaction has modified the data in between the two reads.
   - **Example**: Transaction A reads a row. Transaction B updates that row and commits. When Transaction A reads the row again, it sees the updated data, which is different from its initial read.

4. **Phantom Read**
   - **Definition**: Occurs when a transaction reads a set of rows that satisfy a condition, and another transaction inserts or deletes rows that would alter the set of rows returned if the first transaction repeated the query.
   - **Example**: Transaction A reads all rows where `age > 30`. Transaction B inserts a new row with `age = 35` and commits. If Transaction A re-executes the query, it will see the new row.

5. **Lost Update**
   - **Definition**: Happens when two transactions read the same data and then update it, with the first update being overwritten by the second.
   - **Example**: Transaction A and Transaction B read the same row. Transaction A updates a field. Then, Transaction B updates the same field, overwriting the change made by Transaction A.

6. **Write Skew**
   - **Definition**: A situation where two transactions read the same data, then perform a conditional update based on that data, resulting in inconsistent data.
   - **Example**: Transaction A and Transaction B check a condition (e.g., a sum of balances must not exceed a limit). They both find the condition true, so they proceed with updates, causing the condition to be violated.

7. **Deadlock**
   - **Definition**: Occurs when two or more transactions are waiting for each other to release locks, leading to a situation where none of the transactions can proceed.
   - **Example**: Transaction A holds a lock on Row 1 and wants a lock on Row 2. Transaction B holds a lock on Row 2 and wants a lock on Row 1. Neither can proceed because they are each waiting for the other to release the lock.



## Isolation Levels
Isolation levels define the degree to which the operations in one transaction are isolated from those in other transactions. They balance between consistency and concurrency.

1. **Read Uncommitted**
   - **Description**: Allows a transaction to read data that has been modified but not yet committed by other transactions.
   - **Problems**: Dirty reads, non-repeatable reads, phantom reads.
   - **Use Case**: Rarely used, typically only in environments where performance is prioritized over accuracy.

2. **Read Committed**
   - **Description**: Ensures that a transaction only reads data that has been committed.
   - **Problems**: Non-repeatable reads, phantom reads.
   - **Use Case**: Common default isolation level in many database systems.

3. **Repeatable Read**
   - **Description**: Ensures that if a transaction reads a data item, it will read the same value again even if other transactions modify it before the current transaction completes.
   - **Problems**: Phantom reads.
   - **Use Case**: Suitable for operations that require consistency but can tolerate phantom reads.

4. **Serializable**
   - **Description**: Ensures complete isolation from other transactions. Transactions are executed sequentially.
   - **Problems**: Reduced concurrency and performance.
   - **Use Case**: Used in applications where data consistency is crucial and the workload can tolerate lower concurrency.


## Types of Locks
Locks are mechanisms that prevent concurrent access to data in a database, ensuring data consistency and integrity.

1. **Shared Lock (S)**
   - **Description**: Allows multiple transactions to read a resource but not modify it. Multiple shared locks can be held on the same resource.
   - **Use Case**: Used during read operations to ensure the data is not modified during the read.

2. **Exclusive Lock (X)**
   - **Description**: Allows a transaction to both read and modify a resource. Only one exclusive lock can be held on a resource at a time.
   - **Use Case**: Used during write operations to prevent other transactions from reading or writing to the resource.

3. **Update Lock (U)**
   - **Description**: Prevents a resource from being changed while allowing it to be read. It is used to prevent deadlocks during updates.
   - **Use Case**: Acquired before a shared lock is upgraded to an exclusive lock.

4. **Intent Lock (IS, IX, SIX)**
   - **Description**: Used to indicate that a transaction intends to acquire a shared or exclusive lock on some subordinate resource.
     - **Intent Shared (IS)**: Indicates intent to acquire shared locks.
     - **Intent Exclusive (IX)**: Indicates intent to acquire exclusive locks.
     - **Shared Intent Exclusive (SIX)**: Combines intent exclusive and shared locks.
   - **Use Case**: Helps the database engine to lock resources hierarchically.

5. **Row-Level Lock**
   - **Description**: Locks a single row in a table.
   - **Use Case**: Provides higher concurrency by allowing different transactions to access different rows simultaneously.

6. **Table-Level Lock**
   - **Description**: Locks the entire table.
   - **Use Case**: Used in operations that affect a significant portion of the table, like bulk updates or deletes.

7. **Page-Level Lock**
   - **Description**: Locks a page (a fixed-length block of data).
   - **Use Case**: Balances between row-level and table-level locks, offering a compromise in concurrency and overhead.



## OLAP vs OLTP
- OLAP (Online Analytical Processing) and OLTP (Online Transaction Processing) databases serve different purposes and are optimized for different types of workloads. Here’s a detailed comparison of OLAP and OLTP databases:

- OLTP systems are designed to manage transactional data, supporting daily operations and ensuring data integrity during transactions. They handle a large number of short, atomic transactions.

- OLAP systems are designed for querying and reporting, often used for business intelligence (BI), data mining, and data warehousing. They support complex queries for analyzing historical data.


## Prepared Statements vs JPQL (Java Persistence Query Language)

**Spring Data JPA**:
  - **Pros**: Readable, maintainable, integrated with Spring, automated mapping, safer parameter binding.
  - **Cons**: Limited SQL feature set, potential performance overhead.

**Prepared Statements**:
  - **Pros**: Full SQL feature set, potential performance benefits, fine-grained control.
  - **Cons**: More complex code, manual mapping, increased risk of SQL injection if not used properly.
