# Senior Java Interview Preparation (3+ Years Experience)

This guide contains over 50 of the most frequently asked questions for developers with 3+ years of experience, covering Architecture, Java Internals, and Design Patterns.

## 🧵 Java Internals & Multithreading (1-15)
1. **Explain the working of ConcurrentHashMap.** How does it differ from a synchronized HashMap?
2. **What is the Java Memory Model (JMM)?** Explain visibility and reordering.
3. **Difference between `synchronized` block and `ReentrantLock`.** When to use which?
4. **How does Garbage Collection work in Java?** Explain G1 GC vs ZGC.
5. **What are the different thread states?** How to handle a `BLOCKED` thread?
6. **Explain the Fork/Join framework.**
7. **What is a Deadlock?** How can you programmatically detect or prevent it?
8. **What is AtomicInteger and how does it achieve lock-free synchronization?**
9. **Explain the usage of `volatile` keyword.** Does it provide atomicity?
10. **Difference between `wait/notify` and `await/signal`?**
11. **How would you implement a custom Thread Pool?**
12. **What is ThreadLocal?** Give a real-world use case.
13. **Explain the difference between `submit()` and `execute()` in ExecutorService.**
14. **What is a Race Condition?** Show a code-level fix.
15. **How does String internalization work in Java?**

## 🏗️ Design Patterns & SOLID (16-30)
16. **Explain the SOLID principles with real-world examples.**
17. **Difference between Factory and Abstract Factory patterns.**
18. **When would you use the Prototype pattern over the Factory pattern?**
19. **Explain the Proxy Pattern.** How is it used in Spring AOP?
20. **What is the Strategy pattern?** How do you choose between multiple algorithms at runtime?
21. **Explain the Observer pattern.** How does Java's Event model use it?
22. **What is the Decorator pattern?** How does Java I/O (`BufferedReader`) use it?
23. **State vs Strategy Pattern.** What are the subtle differences?
24. **Difference between Composition and Aggregation.**
25. **How do you implement a thread-safe Singleton?** Explain double-checked locking.
26. **What is Dependency Injection?** Why use a DI container like Spring?
27. **Explain the Builder pattern.** Why is it preferred for objects with many optional parameters?
28. **What is the Adapter pattern?**
29. **Explain the Command pattern.**
30. **What is a Flyweight pattern?** How does Java's Integer cache use it?

## 🌐 Microservices & Spring Boot (31-45)
31. **What is the Saga Pattern?** How do you manage distributed transactions?
32. **Difference between Monolithic and Microservices architecture.**
33. **What is a Circuit Breaker?** How does Resilience4j/Hystrix work?
34. **Explain Service Discovery (Eureka/Consul).**
35. **What is an API Gateway?** What are its core responsibilities?
36. **Explain Event-Driven Architecture.** When to use Kafka vs RabbitMQ?
37. **How to handle data consistency across microservices?**
38. **What is CQRS?** When is it used?
39. **Explain the concept of Backpressure in Reactive Programming.**
40. **How do you secure a Microservice?** (OAuth2/JWT).
41. **What is Centralized Logging?** (ELK/Splunk).
42. **Difference between Spring Boot @Component, @Service, and @Repository.**
43. **What is Bean Lifecycle in Spring?**
44. **Explain the working of @Transactional.** What are propagation levels?
45. **How to monitor microservices?** (Prometheus/Grafana).

## 🗄️ Database & System Design (46-55)
46. **Difference between SQL and NoSQL.** When to use which?
47. **What is Database Sharding?** What are the challenges?
48. **How does Caching (Redis/Memcached) improve system performance?**
49. **Explain CAP Theorem in Distributed Systems.**
50. **What is Database Indexing?** How do B-Trees work?
51. **Difference between Optimistic and Pessimistic Locking.**
52. **How would you design a Rate Limiter?**
53. **What is Content Delivery Network (CDN)?**
54. **Explain Hashing and Consistent Hashing.**
55. **How to design a URL Shortener?** (High-level design).

## 🚀 Experience-Based Questions
56. **What was the biggest technical challenge you faced?** How did you solve it?
57. **How do you perform Code Reviews?** What do you look for?
58. **Have you worked on CI/CD pipelines?** Explain the process.
59. **How do you handle technical debt in a project?**
60. **Explain a situation where you had to suggest a major architectural change.**
