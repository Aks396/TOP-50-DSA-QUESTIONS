# Senior Interview Answers: Database & System Design

### 46. SQL vs NoSQL.
- **SQL (Relational)**: Structured data, predefined schema, ACID compliant. Use for complex joins and financial transactions (e.g., MySQL, PostgreSQL).
- **NoSQL (Non-Relational)**: Dynamic schema, BASE (Basically Available, Soft state, Eventual consistency). Scales horizontally. Types: Document (MongoDB), Key-Value (Redis), Column-Family (Cassandra).

### 47. Database Sharding.
- Splitting a large dataset across multiple database instances. 
- **Challenges**: Cross-shard joins are impossible, Distributed transactions are expensive, Resharding logic is complex.

### 48. Caching (Redis).
- Improves performance by storing results in memory (RAM). Reduces latency (sub-millisecond) and offloads expensive queries from the DB. Use for Session storage, Leaderboards, and frequently accessed static data.

### 49. CAP Theorem.
- In a distributed system, you can have only 2 of: **Consistency**, **Availability**, **Partition Tolerance**. In practice, we choose between Consistency (CP) and Availability (AP) during network partitions.

### 50. Database Indexing (B-Trees).
- An index is a data structure that makes searching faster. B-Trees (Balanced Trees) allow for binary search logic on disk. 
- **Trade-off**: Faster Reads, Slower Writes (as index must be updated).

### 51. Optimistic vs Pessimistic Locking.
- **Pessimistic**: Locks the record at the DB level (`SELECT FOR UPDATE`). No one else can access it. High contention.
- **Optimistic**: No lock. Uses a `version` column. Upon update, it checks if the version is still the same. If someone else changed it, the update fails. Better for high-concurrency/low-collision systems.

### 52. Rate Limiting.
- Restricting the number of requests a user can make in a timeframe. 
- **Algorithms**: Token Bucket, Leaky Bucket, Fixed Window, Sliding Window Log.

### 53. CDN (Content Delivery Network).
- A network of servers distributed globally. It serves static content (Images, CSS, JS) from a server closest to the user (the "Edge"), reducing latency and origin server load.

### 54. Consistent Hashing.
- A technique where adding or removing a node (server) doesn't require rehashing the entire keyset. Only a small fraction of keys ($K/n$) need to be re-mapped. Essential for horizontal scaling of caches/shards.

### 55. URL Shortener Design (High-Level).
- **Requirements**: Shorten URL, Redirect to long URL, Analytics.
- **Tech Stack**: NoSQL (Key-value like Redis for redirection, MongoDB for long-term storage).
- **Encoding**: Use Base62 (A-Z, a-z, 0-9) to generate a 7-character hash from a unique auto-incremented ID.

### 56-60 Experience-Based (Tips for Candidates):
56. **Technical Challenge**: Focus on "SITUATION -> TASK -> ACTION -> RESULT". Mention a production bug, scaling issue, or a complex refactoring.
57. **Code Reviews**: Check for readability, edge cases, test coverage, and adherence to DRY/SOLID.
58. **CI/CD**: Explain how code moves from Git -> Build (Maven) -> Test -> Docker -> Kubernetes (Staging/Prod).
59. **Technical Debt**: Explain how you prioritize it alongside business features (e.g., 20% rule).
60. **Architectural Change**: Discuss moving from Monolith to Microservices, changing a DB, or introducing a Caching layer.
