# System Design: Database Sharding

Sharding is a method of splitting and distributing a single dataset across multiple databases (shards), which can then be stored on multiple nodes.

## 🧠 Sharding vs. Partitioning

- **Partitioning**: Splitting a table within the *same* database instance.
- **Sharding**: Splitting data across *different* database instances (Horizonal Scaling).

## 🚀 Sharding Strategies

1. **Key-Based (Hash-Based)**: Use a hash function on a key (e.g., `user_id % 4`) to determine the shard.
2. **Range-Based**: Shard based on a range of values (e.g., users A-M in Shard 1, N-Z in Shard 2).
3. **Directory-Based**: A lookup service maps keys to their respective shards.

## ⚠️ Challenges of Sharding

- **Complexity**: The application logic becomes more complex.
- **Joins Across Shards**: Very difficult and expensive to perform joins between two different shards.
- **Resharding**: If one shard becomes too large, moving data across shards is technically challenging.
- **Data Distribution**: Risk of "Hotspots" (one shard receiving much more traffic than others).

## ⚖️ Alternatives
Before sharding, consider:
- **Read Replicas**: Distributing read traffic.
- **Vertical Scaling**: Expanding the existing DB server.
- **Database Indexing**: Optimizing queries.
