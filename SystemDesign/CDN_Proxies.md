# System Design: CDN & Proxies

## 🌐 Content Delivery Network (CDN)
A CDN is a highly-distributed platform of servers that helps minimize delays in loading web page content by reducing the physical distance between the server and the user.

### How it Works
- **Edge Servers**: Proxies that cache content geographically closer to users.
- **Points of Presence (PoPs)**: Data centers located in high-traffic areas.

### Benefits
- **Reduced Latency**: Faster content delivery.
- **Bandwidth Reduction**: Less traffic hitting the origin server.
- **Security**: Basic protection against DDoS.

## 🛡️ Proxies
A proxy server acts as a gateway between you and the internet.

### 1. Forward Proxy
- Sits in front of the **client**.
- Used to bypass firewalls, browse anonymously, or filter web content.

### 2. Reverse Proxy
- Sits in front of the **web servers**.
- Used for **Load Balancing**, SSL Termination, Compression, and Caching.
- Protects the identity and structure of the backend servers.

## 🌉 DNS (Domain Name System)
The phonebook of the internet. Translates human-readable names (google.com) to IP addresses.
- **DNS Caching**: Storing IP mappings locally to speed up lookups.
- **TTL (Time to Live)**: How long a DNS record is cached.
