# System Design: API Gateway & Rate Limiting

## 🚪 API Gateway
An API Gateway is a server that acts as an API front-end, receiving API requests, enforcing throttling and security policies, and passing requests to the back-end service.

### Key Responsibilities
- **Routing**: Mapping client requests to appropriate microservices.
- **Authentication & Authorization**: Centralized security checks.
- **Rate Limiting**: Preventing system overload from excessive requests.
- **Logging & Monitoring**: Tracking API usage and performance.
- **Protocol Translation**: Translating between protocols (e.g., HTTP to gRPC).

## 🛑 Rate Limiting
Rate limiting is a strategy for limiting network traffic. It puts a cap on how often someone can repeat an action within a certain timeframe.

### Common Algorithms
- **Token Bucket**: Tokens are added to a bucket at a fixed rate. Each request takes a token. No tokens = request denied.
- **Leaky Bucket**: Requests enter a bucket and are processed at a steady rate. Excess requests "overflow" and are dropped.
- **Fixed Window Counter**: Divides time into fixed intervals and counts requests. Simple but prone to bursts at window boundaries.
- **Sliding Window Log**: Tracks a timestamp for every request. Precise but memory-intensive.
- **Sliding Window Counter**: Hybrid of Fixed Window and Sliding Window Log.

### Why use it?
- Prevent **DoS/DDoS** attacks.
- Reduce costs (e.g., if using a 3rd party API).
- Fair usage for all clients.
