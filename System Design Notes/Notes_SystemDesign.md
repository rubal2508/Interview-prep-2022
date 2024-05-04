# System Design HLD 

## Microservices Design Patterns 

- Ref: [Concepts and Coding - Microservices Design Patterns | Part1: Introduction and Decomposition Pattern | HLD System Design](https://www.youtube.com/watch?v=l1OCmsBnQ3g&list=PL6W8uoQQ2c63W58rpNFDwdrBnq5G3EfT7&index=5&ab_channel=Concept%26%26Coding-byShrayansh)
- Ref: [HLD SAGA Pattern | Strangler Pattern | CQRS | Microservices Design Patterns | System Design](https://youtu.be/qGlUKtjqaEQ?si=oGE58LWuYYFEA5ED)
- Microservice vs Monolith

### Disadvantages of microservices:
- Latency of a request increases if multiple microservices are tightly coupled with each other as services will be dependant on each other to serve a request
- ServiceA might break if there are changes in serviceB, Hard to monitor and keep track
- Transaction management is hard. Each service will have its own transaction in its DB. Hard to mainting Atomicity across multiple services. Easy to roll back in a Monolith
- 


### Decomposition Patten:
Tells how to break a requirement. How "micro" should a microservice be?

- Decomposition: 
  - Decompose by business functionality 
  - Decompose by Subdomain (DDD Domain Driven Design)
- DB:
  - Seperate DB for each microservice or shared DB
- Communication:
  - API communcation
  - Kafka
- Integration:
  - API gateway? (didnt understand)

### Strangler Patten:
Used when we are migrating monolith to a microservice
- Slowly move the traffic from monolith to microservice
- Initial 10% then 20% and so on
- Only trasnfer few functionalities at first


### DB Management in microservices:
- Demerits of shared DB:
  - Difficult to scale
  - Difficult to make modifications as other services might get impacted
- Benefits of shared DB:
  - Easy to join (Solved by CQRS pattern)
  - Can implement ACID properties (Solved by SAGA pattern)
- Benfits of seperate DB:
  - Each service can have DB cater to its needs (sql, nosql)
  - Easy to scale as per each service requirements


### SAGA pattern
- Sequence of Local Transactions
- Choreography: Use Kafka events to send Success/Fail messages to rollback the local txns (Cycle dependency)
- Orchestrator: talks to each service to make sure they are success, else send rollback request to other services


### CQRS pattern
- Command Query Request Aggregation
- Create a new db "VIEW" with data from other individual dbs
- Create Update Delete will happen in service's db
- Select query will run on View db
- Now we will able to join data from diff dbs
- How to update view db? Can use kafka events or DB triggers / Procedures


## Back of the Envelope Estimation

- Ref: [Back-Of-The-Envelope Estimation for System Design Interview | Capacity Planning of Facebook | HLD](https://youtu.be/WZjSFNPS9Lo?si=EYDFesSEfYFoaZmk)

- Cheat sheet 

| Zeros     | Traffic     | Storage |
| --------- | ----------- | ------- |
| $10^3$    | Thousand    | KB      |
| $10^6$    | Million     | MB      |
| $10^9$    | Billion     | GB      |
| $10^{12}$ | Trillion    | TB      |
| $10^{15}$ | Quadrillion | PB      |

<br>


| Data         | Storage |
| ------------ | ------- |
| ASCII Char   | 1 Byte  | 
| Unicode Char | 2 Byte  |
| Long Double  | 8 Byte  |
| Image        | 500 KB  |

<br>




- Steps for estimations :
  1. Estimate Traffic 
      - Daily Active Users (DAU)
      - Queries per second  = (DAU * Query per user) / seconds per day
      - Peak Query per second = QPS x 2
      - Read / Write ratio
  2. Estimate Storage
  3. Estimate RAM
  4. Trade offs (CAP theorm)

- Useful common things:
  - Seconds per day : 100,000
  - One server can handle about 100-1000 requests per second. There may be multiple requests needed for each query
  - 1 million per day ~ 10 per sec  
- [Latency numbers every programmer should know](https://static.googleusercontent.com/media/sre.google/en//static/pdf/rule-of-thumb-latency-numbers-letter.pdf
) 





## Framework to solve System Design Questions

- Refer the book