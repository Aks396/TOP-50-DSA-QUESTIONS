# Senior Interview Answers: Microservices & Spring Boot

### 31. What is the Saga Pattern?
- Manages distributed transactions across microservices. Since microservices shouldn't share a DB, a 2-Phase Commit (2PC) is hard to scale.
- **Saga**: A sequence of local transactions. Each transaction updates its own DB and triggers the next. 
- **Compensation**: If a step fails, the Saga executes "compensating transactions" (undo steps) to maintain eventual consistency.
- **Types**: Choreography (event-based) and Orchestration (centralized controller).

### 32. Monolith vs Microservices.
- **Monolith**: Single deployable unit. Easy to develop/test initially, but hard to scale and slow to deploy as it grows.
- **Microservices**: Decoupled, small services communicating via APIs (REST/gRPC). Allows independent scaling, tech diversity, and faster releases, but introduces network complexity and data consistency issues.

### 33. What is a Circuit Breaker?
- Prevents a cascading failure when a downstream service is down. 
- **Closed**: Requests go through.
- **Open**: Service fails fast, returning a fallback.
- **Half-Open**: Gradually allows few requests to check if the downstream service is healthy again. Tool: **Resilience4j**.

### 34. Service Discovery (Eureka).
- A central registry where microservices register their IP/Port. Instead of hardcoding URLs, services ask Eureka for the address of "ORDER-SERVICE", enabling dynamic scaling and load balancing.

### 35. API Gateway.
- A single entry point for clients. Responsibilities: Routing, Authentication, Rate Limiting, Request Transformation, and Response Aggregation.

### 36. Kafka vs RabbitMQ.
- **RabbitMQ**: Traditional message broker. Pushes messages to consumers. Best for simple routing and immediate consumption.
- **Kafka**: Distributed event streaming platform (Log-based). Consumers pull messages. Best for high throughput, event replays, and large-scale data processing.

### 37. Data Consistency in Microservices.
- Move from **Strong Consistency** to **Eventual Consistency**. Use **Inbox/Outbox Patterns** and Message Queues to ensure that local DB updates and event publishing happen atomically.

### 38. What is CQRS?
- **Command Query Responsibility Segregation**: Separates read and write operations. You might use a relational DB for Writes (Strict schema/Transactions) and a NoSQL/Elasticsearch for Reads (Fast/Scalable search).

### 39. Backpressure in Reactive Programming.
- A mechanism where the consumer signals to the producer that it's being overwhelmed and the producer should slow down. (e.g., Project Reactor, RxJava).

### 40. OAuth2 and JWT.
- **OAuth2**: The framework/protocol for authorization.
- **JWT**: The token format used to carry claims (User ID, Roles). It's self-contained and signed, so services don't need to call the Auth server for every request.

### 41-45 Quick Hits:
41. **Centralized Logging (ELK)**: ElasticSearch, Logstash, Kibana. Aggregates logs from all services into one searchable dashboard.
42. **@Component vs @Service vs @Repository**: They are functionally identical but offer semantic meaning and specialized error handling (e.g., `@Repository` translates SQL exceptions).
43. **Bean Lifecycle**: Instantiate -> Populate Props -> BeanPostProcessor (Before) -> Init Method -> BeanPostProcessor (After) -> Usage -> Destruction.
44. **@Transactional**: Manages DB transactions. `Propagation.REQUIRED` (joins existing), `REQUIRES_NEW` (always starts fresh).
45. **Monitoring**: **Prometheus** pulls metrics from `/actuator/prometheus`; **Grafana** visualizes them.
