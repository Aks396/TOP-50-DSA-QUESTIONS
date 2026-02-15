# Concept: System Design Basics

System design is the process of defining the architecture, components, and data for a system to satisfy specified requirements. For senior roles, understanding how systems scale is mandatory.

## 🏗️ Key Principles

1. **Scalability**: The ability to handle increasing load by adding resources.
   - **Vertical**: Adding more Power (CPU/RAM) to a single machine.
   - **Horizontal**: Adding more Machines to the network.
2. **Availability**: Ensuring the system is operational for a high percentage of time (e.g., "Five Nines" 99.999%).
3. **Consistency**: Ensuring all nodes see the same data at the same time (refer to CAP Theorem).
4. **Reliability**: The system's ability to perform its function under stated conditions for a specified period.

## 🧱 The Building Blocks

- **Load Balancers**: Distributing traffic.
- **Caching**: Reducing latency and database load.
- **Databases**: Relational (SQL) vs. Non-Relational (NoSQL).
- **Messaging Queues**: Decoupling services (Kafka, RabbitMQ).
- **Proximation**: CDN (Content Delivery Networks) for static assets.

## ⚖️ Trade-offs (CAP Theorem)
In a distributed system, you can only have two out of three:
- **C**onsistency
- **A**vailability
- **P**artition Tolerance
