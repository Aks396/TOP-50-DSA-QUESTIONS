# System Design: Caching

Caching is the process of storing copies of data in a high-speed storage layer (like RAM) so that future requests for that data can be served faster.

## 🧠 The Cache Hit/Miss

- **Cache Hit**: Data is found in the cache.
- **Cache Miss**: Data is not in the cache; must be fetched from the source (DB).

## 🚀 Caching Strategies

1. **Cache-Aside (Lazy Loading)**:
   - App checks cache first. On miss, it fetches from DB and updates cache.
2. **Write-Through**:
   - Updates both cache and DB simultaneously.
3. **Write-Back (Write-Behind)**:
   - Updates cache and acknowledges app. Data is updated in DB asynchronously.
4. **Refresh-Ahead**:
   - Cache is automatically refreshed before it expires.

## 🧹 Eviction Policies

When the cache is full, how do we decide what to remove?
- **LRU (Least Recently Used)**: Discards the least recently used items first.
- **LFU (Least Frequently Used)**: Discards items with the lowest access frequency.
- **FIFO**: First-In, First-Out.

## 🌐 Distributed Caching
In a distributed environment, caches must be accessible by all application servers. Popular tool: **Redis**.
