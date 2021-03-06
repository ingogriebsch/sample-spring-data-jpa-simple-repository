# Spring Data JPA simple repository sample
[![Actions Status](https://github.com/ingogriebsch/sample-spring-data-jpa-simple-repository/workflows/build/badge.svg)](https://github.com/ingogriebsch/sample-spring-data-jpa-simple-repository/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository&metric=alert_status)](https://sonarcloud.io/dashboard?id=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository&metric=coverage)](https://sonarcloud.io/dashboard?id=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository&metric=security_rating)](https://sonarcloud.io/dashboard?id=de.ingogriebsch.samples%3Asample-spring-data-jpa-simple-repository)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

This sample shows how to implement a simple repository with Spring Data JPA (and Spring Boot).

## How to build and run
If you want to see the implementation in action, simply follow these steps:

*   First, make sure that you have Java 8 or later installed and an established Internet connection.
*   Then, clone this Git repository an `cd` into the project folder.
*   Now invoke `./mvnw spring-boot:run` and wait a moment.

After the project is built and the Spring Boot service is running you can hit the following urls to act with the service:

*   [http://localhost:8080](http://localhost:8080) allows to access this site.
*   [http://localhost:8080/h2-console](http://localhost:8080/h2-console) allows to access to the underlying h2 database. Please check the log output to grab the correct JDBC URL.

## Most important annotations and classes
A collection of the most important annotations and classes that are necessary to implement this use case. 

*   [@GeneratedValue](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/GeneratedValue.html)
*   [@Id](https://javaee.github.io/javaee-spec/javadocs/javax/persistence/Id.html)
*   [@Repository](https://docs.spring.io/spring-data/commons/docs/2.4.2/api/org/springframework/data/repository/Repository.html)
*   [@Transactional](https://docs.spring.io/spring-framework/docs/5.3.2/javadoc-api/org/springframework/transaction/annotation/Transactional.html)
*   [@DataJpaTest](https://docs.spring.io/spring-boot/docs/2.4.1/api/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html)

## Used frameworks
A collection of the mainly used frameworks in this project. 
There are more, but they are not that present inside the main use case, therefore they are not listed here.

*   [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/2.4.2/reference/html/)
*   [Spring Boot](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/)

## Additional guides
The following guides illustrate how to implement this and related use cases.

*   [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

## License
This code is open source software licensed under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0.html).
