🌟 Voter ID Management System 🌟

A Hibernate-based Java application to manage Person, VotingCard, and Address entities. This project demonstrates one-to-one and many-to-one relationships, with a focus on ensuring database constraints like unique identifiers and foreign keys.

🚀 Features
🧑‍🤝‍🧑 Entity Relationships:
Person ↔ VotingCard (One-to-One)
Person ↔ Address (Many-to-One)
🔒 Unique Constraints: Enforce unique voter_id for each voting card.
📊 Database Operations: Perform CRUD operations on entities using Hibernate ORM.
🛠️ Custom Configuration: Configure database settings through hibernate.cfg.xml.

🛠️ Tech Stack
Backend: Java, Hibernate ORM
Database: MySQL
Build Tool: Maven

🧑‍💻 Entities Overview
1. Person
Fields:
aadhar_id (Primary Key)
name
voter_id (One-to-One with VotingCard)
address (Many-to-One with Address)

3. VotingCard
Fields:
v_id (Primary Key)
voter_id (Unique)
Constituency

5. Address
Fields:
pin_code (Primary Key)
city
