# System Design: Load Balancing

Load balancing refers to the process of distributing network or application traffic across multiple servers.

## 🧠 Why Load Balancing?

- **Availability**: Prevents single point of failure by rerouting traffic if a server goes down.
- **Scalability**: Allows easy addition/removal of servers based on demand.
- **Performance**: Reduces the burden on a single server, leading to better response times.

## 🌉 Types of Load Balancers

1. **L4 Load Balancer (Transport Layer)**:
   - Works on IP/Port levels.
   - Faster as it doesn't look at application data (HTTP content).
2. **L7 Load Balancer (Application Layer)**:
   - Looks at HTTP headers, cookies, and data.
   - Allows complex routing (e.g., `/api` to server A, `/images` to server B).

## ⚙️ Load Balancing Algorithms

- **Round Robin**: Sequential distribution regardless of load.
- **Least Connections**: Sends traffic to the server with fewer active connections.
- **IP Hash**: The IP address of the client is used to determine which server gets the request.
- **Weighted Round Robin**: Handles servers with different processing capacities.

## 🛠️ Tools
- **Nginx**, **HAProxy**, **AWS ELB/ALB**.
