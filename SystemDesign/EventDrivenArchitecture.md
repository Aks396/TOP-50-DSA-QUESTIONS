# System Design: Event-Driven Architecture (EDA)

EDA is a software architecture paradigm promoting the production, detection, consumption of, and reaction to events.

## 🧠 What is an Event?
A change in state, or an update (e.g., "Item Added to Cart", "Payment Success").

## 🚀 Core Concepts
- **Event Producer**: Detects/gathers data and sends events to the router.
- **Event Router (Broker)**: Filters and pushes the events to consumers.
- **Event Consumer**: Reacts to the event.

## 🔄 Patterns
1. **Event Sourcing**: Storing the state of a system as a sequence of events. To get the current state, you "replay" all events from the start.
2. **CQRS**: Separating Read and Write models (often used with Event Sourcing).
3. **Event Streaming**: Processing infinite logs of data in real-time (e.g., Kafka).

## ⚖️ Trade-offs
- **Pros**: Agility, Scalability, Loose Coupling.
- **Cons**: Complexity in debugging, Eventual Consistency challenges, Error handling (poison pill messages).
