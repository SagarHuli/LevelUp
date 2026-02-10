## SQL Queries

### Question 1: The "Top N" Per Group Challenge
You have an Orders table with columns: order_id, customer_id, order_date, and total_amount.
Task: Write a query to find the 3 most recent orders for every customer. If a customer has fewer than 3 orders, return all of them.
Note: For a senior role, aim for a solution that is efficient and handles ties gracefully.

```
SELECT customer_id, order_id, order_date
FROM (
    SELECT *, ROW_NUMBER() OVER (
        PARTITION BY customer_id 
        ORDER BY order_date DESC) AS rn
    FROM Orders
) AS ranked_orders
WHERE rn <= 3;
```

----
### Question 2: Performance & Indexing
Imagine the Orders table has 50 million rows. The query we just wrote (using ROW_NUMBER()) is running extremely slowly, causing a full table scan.
Task: What specific Index would you create to make this "Top N per Customer" query highly performant? Explain why you chose those specific columns and their order.
What is your indexing strategy?

```aiignore
The Answer: Composite Indexing
To optimize that query, you would create a Composite Index on:
INDEX(customer_id, order_date DESC)
Why this specific order?
customer_id (Equality/Partition): The database first needs to group the data by customer. Having this as the first column allows the engine to jump directly to all records for a specific ID.
order_date (Sorting): By including this in the index, the data is already physically sorted within each customer_id block. The database can simply pick the first 3 rows it finds and move to the next customer, avoiding a "Filesort" operation.

```
---
### Question 3: Identifying Data Gaps
Let's test your ability to find "missing" data. You have two tables:
Users (id, name, created_at)
Logins (id, user_id, login_timestamp)
Task: Write a query to find all users who signed up in 2023 but have never logged in.
Constraint: For senior-level efficiency, try to avoid using IN or NOT IN if the Logins table is massive.

```aiignore
SELECT id, name 
FROM Users u
WHERE created_at BETWEEN '2023-01-01' AND '2023-12-31'
  AND NOT EXISTS (
      SELECT 1 FROM Logins l WHERE l.user_id = u.id
  );
  

 SELECT u.id, u.name
FROM Users u
LEFT JOIN Logins l ON u.id = l.user_id
WHERE u.created_at >= '2023-01-01' AND u.created_at <= '2023-12-31'
  AND l.user_id IS NULL; -- This is the 'Anti-Join' pattern

```
---
### Question 4: Handling Concurrency
You are building a high-traffic inventory system. Two different backend processes try to deduct stock from the same product at the same millisecond.
Product A currently has 10 items in stock.
Process 1 wants to buy 6 items.
Process 2 wants to buy 5 items.
Task: Write a single SQL UPDATE statement that ensures the stock never drops below zero, even if both processes run simultaneously.
What does that UPDATE statement look like?

The Answer: The Atomic Update
You handle this entirely within the WHERE clause of the UPDATE statement:
```aiignore
UPDATE Inventory 
SET stock_count = stock_count - 6
WHERE product_id = 'A' 
  AND stock_count >= 6;

```
Why this is the "Senior" way:
 * Atomicity: The database locks that specific row during the update.
 * Validation: By adding AND stock_count >= 6, the database checks the balance at the exact moment of the write.
 * Result: If Process 1 finishes first, the stock becomes 4. When Process 2 tries to run, its WHERE clause (stock_count >= 5) will fail, 0 rows will be affected, and your backend code can then return an "Out of stock" error to the user.

---
### Question 5: Managing Hierarchy
You have an Employees table: id, name, and manager_id (which refers back to another id in the same table).
Task: Write a query to find the "Management Chain" for a specific employee (e.g., ID 101). You need to return their name, their manager's name, their manager's manager's name, all the way up to the CEO.
Hint: This requires a feature introduced in MySQL 8.0 for traversing tree-like structures.
Do you know which SQL structure is used for this?

In MySQL 8.0+, you use the WITH RECURSIVE syntax. This allows a query to "loop" over itself until it hits the top of the chain (where manager_id is NULL).

```aiignore
WITH RECURSIVE ManagementChain AS (
    -- Anchor member: start with the specific employee
    SELECT id, name, manager_id, 1 AS level
    FROM Employees
    WHERE id = 101
    
    UNION ALL
    
    -- Recursive member: join the previous result with the Employees table
    SELECT e.id, e.name, e.manager_id, mc.level + 1
    FROM Employees e
    INNER JOIN ManagementChain mc ON e.id = mc.manager_id
)
SELECT * FROM ManagementChain ORDER BY level;

```
---
### Question 6: The "Soft Delete" Problem
In many production systems, we don't actually DELETE rows. We use a column like deleted_at (DATETIME) or is_active (BOOLEAN). This is called Soft Deletion.
Scenario: You have a Users table and a Posts table. Both use soft deletes.
Task: Write a query to get a list of all Posts written by active users, but only include posts that haven't been deleted.
What would that query look like?

```aiignore
SELECT u.user_id, p.post_id
FROM Users u
INNER JOIN Posts p ON u.user_id = p.user_id
WHERE u.is_active = true
AND p.deleted_at IS NULL
```
The "Senior" Feedback on Performance
Since you are targeting a senior role, you should mention Filtered (Partial) Indexes.
If 90% of your Posts are deleted, a standard index on user_id still scans a lot of "dead" data. In databases that support it (like PostgreSQL), you’d use a Partial Index. In MySQL, since partial indexes aren't supported, you'd use a Composite Index including the status:
INDEX(user_id, deleted_at) or INDEX(is_active).
---
### Question 7: Aggregation with Filters
You have a Sales table: id, sale_date, amount, and category.
Task: Write a query that returns a single row per category, showing two columns:
The total revenue from 2023.
The total revenue from 2024.
Challenge: Avoid using two separate queries or multiple joins. Try to do it in one pass of the table.

```aiignore
SELECT 
    category,
    SUM(CASE WHEN sale_date BETWEEN '2023-01-01' AND '2023-12-31' THEN amount ELSE 0 END) AS revenue_2023,
    SUM(CASE WHEN sale_date BETWEEN '2024-01-01' AND '2024-12-31' THEN amount ELSE 0 END) AS revenue_2024
FROM Sales
GROUP BY category;

```
---
### Evaluation of Question 8
Your answer captures the high-level intent, but the syntax is not valid SQL. In a senior interview, precision with DDL (Data Definition Language) is expected.
The Issues:
primary_key: This isn't a valid type or constraint syntax in most engines; it's usually PRIMARY KEY or SERIAL PRIMARY KEY.
CONSTRAINTS: You don't usually declare basic nullability and defaults using a separate CONSTRAINTS block for a single column; it's done inline.
Missing Type: Every column needs a data type (e.g., VARCHAR(50)).
Requirement Check: You missed the Default Value requirement ('GENERATING...').

```aiignore
CREATE TABLE Products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    SKU VARCHAR(50) NOT NULL UNIQUE DEFAULT 'GENERATING...'
);

```
### Question 9: Identifying Duplicate Records
A bug in the ingestion pipeline has caused duplicate entries in your Users table.
Task: Write a query to find all email addresses that appear more than once in the Users table, and show exactly how many times each email appears.
What is your query?

```
SELECT email, COUNT(*) as count
FROM Users
GROUP BY email
HAVING count > 1;

```
---
### Question 10: The De-Duplication Challenge
Building on the previous question: Finding duplicates is easy; cleaning them up is the "Senior" task.
Task: Write a query (or describe the logic) to DELETE the duplicate rows, keeping only the one record with the lowest id for each email.
Hint: In MySQL, you can use a DELETE statement combined with an INNER JOIN to the same table.

```aiignore
DELETE u1 FROM Users u1
INNER JOIN Users u2 
    ON u1.email = u2.email 
    AND u1.id > u2.id;

```
### Question 11: The "N+1" Database Impact
As a Senior Developer, you often review code from juniors. You see a loop in the application code that fetches a list of Posts and then, for every single post, executes a separate SQL query to fetch the Author name.
Task:
What is the name of this performance anti-pattern?
How would you explain to the junior why this is dangerous for the database's Connection Pool and Latency?

```aiignore
database connection pool has limited active connection threads, there will be latency in the case of every post acquired a connection from pool, querying the db and releasing the connection for re-use. Instead get all the authors for all the posts in a single query

Spot on. You’ve nailed the core architectural concern.
The Assessment
Anti-pattern Name: This is the infamous N+1 Query Problem.
The Impact: As you correctly noted, the bottleneck isn't just the database engine—it's the Network Latency and Connection Exhaustion. Each round-trip adds milliseconds of overhead. If your pool has 20 connections and a junior triggers a loop of 100 queries, they can effectively "DoS" (Denial of Service) your own application by locking up the pool.
```
---
