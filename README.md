# Java Engineering Notes
**Started:** June 2025
**Goal:** Senior Fintech Java Developer

---

## Progress

### Week 1 ✅
- [x] Streams & Lambdas — filter, map, reduce,
                          flatMap, groupingBy
- [x] Functional Interfaces — Predicate, Function,
                              Consumer, Supplier
- [x] Collections API — List, Set, Map deep dive
- [x] Interface vs Abstract Class
- [x] Unit Testing — JUnit 5 + Mockito

### Week 2 🔄
- [ ] MySQL — indexes, joins, transactions
- [ ] Concurrency — threads, virtual threads
- [ ] System Design basics

### Week 3
- [ ] Spring Security + JWT
- [ ] Clean Architecture
- [ ] Docker properly

---

## Key Insights

### Streams
Streams are lazy — nothing executes until
a terminal operation is called.
This makes them memory efficient for large datasets.
Real application: used in production batch payment
processing to filter and transform invoice collections.

### ConcurrentHashMap vs HashMap
Discovered a potential thread-safety issue in production
code where a HashMap was returned from a method called
by multiple virtual threads simultaneously.
ConcurrentHashMap or returning immutable Map.of()
would be the safer approach.

### Mockito — Stubbing
UnnecessaryStubbingException occurs when you stub
a method that your test never actually calls.
Mockito enforces clean tests — every stub must
be used or it fails loudly.

---

## Resources
- Java Brains (YouTube)
- Amigoscode (YouTube)  
- Telusko (YouTube) ← currently watching
- System Design Interview — Alex Xu (book)
