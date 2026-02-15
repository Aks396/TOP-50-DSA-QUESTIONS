# System Design: Message Queues

A message queue is a form of asynchronous service-to-service communication used in serverless and microservices architectures.

## 🧠 Core Concept
Messages are stored in the queue until they are processed and deleted. Each message is processed by only one consumer.

## 🚀 Key Benefits
- **Decoupling**: Services don't need to know about each other; they just interact with the queue.
- **Scalability**: Producers and consumers can scale independently.
- **Resilience**: If a consumer fails, messages wait in the queue until it recovers.
- **Smoothing Bursts**: Queues act as buffers during high traffic spikes.

## ⚙️ Popular Models
- **Point-to-Point**: One message, one consumer.
- **Publish-Subscribe (Pub/Sub)**: One message, multiple subscribers (Broadcast).

## 🛠️ Popular Tools
- **RabbitMQ**: Traditional broker, focuses on complex routing.
- **Apache Kafka**: High-throughput distributed log, focuses on persistent streaming.
- **Amazon SQS**: Managed queue service by AWS.
