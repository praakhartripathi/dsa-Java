### What Are Relational Databases?
- Relational databases are a type of database management system (DBMS) that stores and provides access to data points that are related to one another. 
Based on the relational model introduced by **E.F. Codd in 1970**, they use a structure that allows data to be organized into tables with rows and columns. 
Key features include:

- Use of SQL (Structured Query Language) for querying and managing data
- Support for ACID transactions (Atomicity, Consistency, Isolation, Durability)
- Enforcement of data integrity through constraints (e.g., primary keys, foreign keys)
- Ability to establish relationships between tables, enabling complex queries and data retrieval
- Scalability and support for multi-user environments

Examples of popular relational database systems 
include MySQL, PostgreSQL, Oracle, and Microsoft SQL Server. They are widely used in various applications, from small-scale projects to large enterprise systems, due to their reliability, consistency, and powerful querying capabilities.


## RDBMS Benefits and Limitations

* Here are some of the benefits of using an RDBMS:

- Structured Data: RDBMS allows data storage in a structured way, using rows and columns in tables. This makes it easy to manipulate the data using SQL (Structured Query Language), ensuring efficient and flexible usage.
- ACID Properties: ACID stands for Atomicity, Consistency, Isolation, and Durability. These properties ensure reliable and safe data manipulation in a RDBMS, making it suitable for mission-critical applications.
- Normalization: RDBMS supports data normalization, a process that organizes data in a way that reduces data redundancy and improves data integrity.
- Scalability: RDBMSs generally provide good scalability options, allowing for the addition of more storage or computational resources as the data and workload grow.
- Data Integrity: RDBMS provides mechanisms like constraints, primary keys, and foreign keys to enforce data integrity and consistency, ensuring that the data is accurate and reliable.
- Security: RDBMSs offer various security features such as user authentication, access control, and data encryption to protect sensitive data.

 * Here are some of the limitations of using an RDBMS:
- Complexity: Setting up and managing an RDBMS can be complex, especially for large applications. It requires technical knowledge and skills to manage, tune, and optimize the database.
- Cost: RDBMSs can be expensive, both in terms of licensing fees and the computational and storage resources they require.
- Fixed Schema: RDBMS follows a rigid schema for data organization, which means any changes to the schema can be time-consuming and complicated.
- Handling of Unstructured Data: RDBMSs are not suitable for handling unstructured data like multimedia files, social media posts, and sensor data, as their relational structure is optimized for structured data.
- Horizontal Scalability: RDBMSs are not as easily horizontally scalable as NoSQL databases. Scaling horizontally, which involves adding more machines to the system, can be challenging in terms of cost and complexity.
