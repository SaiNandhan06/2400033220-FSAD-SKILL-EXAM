# hibernatehql

Maven Hibernate project using Java 21 and HQL.

## Setup

- Ensure the database `fsadexam` exists in MySQL.
- Update credentials in `src/main/resources/hibernate.cfg.xml` if needed.

## Run

- Build: `mvn -q -DskipTests package`
- Run: `mvn -q -DskipTests exec:java`
