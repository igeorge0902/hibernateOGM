# hibernate OGM

A sample project to demonstrate Java Persistence API working witn n datasources. It means a single back-end point can serve as a SPOC (single point of contact) to access as many databases as configured from literally within the application, which therefore serves as the brain.

- sample of EntityManager with persistence.xml
- sample of SessionFactory with hibernate.cfg.xml

Packages:
- com.mongo.dao
- com.mongo.service

Basic implementations are covered in the HibernateUtil class, respectively, while the DAO class is used to create instances, and the ObjectHandlerImpl class is used for object manipulation using the persistent context. While the session created with SessionFactory is serializable, making it possible to send through for example tunnels created with Kafka - see example in the Kafka project: [Kafka](https://github.com/igeorge0902/Kafka/tree/master/src/main/java/com/queues) -, that of the EntityManager is not. For more complex object manipulation with session created by SessionFactory I think you are better off if you implement it in the DAO class itself.

The com.mongo.dao.ogm package holds the standard bean-like implementations, which I have not touched, just put in the project. I worked on the above mentioned solution, only.

Entity:
- com.mongo.dao.ogm.book.model
