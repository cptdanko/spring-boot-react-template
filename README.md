# Spring Boot React Template

A template to create a monolithic Spring Boot app with a reactjs based front-end.

This repository provides a temnplate for a full stack solution for a Java spring boot API with a react based front-end. This repository 
presents a monolithic web app based full stack solutions. Building microservices is often considered the norm these days, however 
monolithic apps still have valid uses for which they can be used, one example being, when doing proof of concept for a new product. 

Have a read of [this blogpost] for a walkthrough of this solution.


## Details for the Spring Boot API
A simple spring boot based REST API that can CRUD's data for accounts for customers.

### API structure
1.  a basic CRUD API for a resource i.e. account
    - maintain a simple structure without relying too much on certain design patterns
    - saves data to a in-memory list
2. react based front-end that sends data back and forth
    - keep all logic in the one app.js file
    - don't worry about writing unit tests for rect based UI
3. postman tests to validate the Spring Boot API
    - ensure postman tests are checked in the source code

## Details for the react based SPA

Added a simple react based app that allows you to CRUD data to the backend API from the frontend. The UI is simple and self-explanatory. 
The purpose of the UI is to demonstrate certain concepts of UI integration with a spring boot app.

### Build Plugin

To build a react app and launch it when running ``` mvn spring-boot:run```, the [frontend-maven-plugin] is used. Have a look at the [pom file] to know more.

# More great tutorials and code samples
I will be writing a detailed tutorial on how to work with this repo on my blog. Until then refer to [my blog] for other tutorials and "how-to" articles with detailed code samples.

If you like what I am doing, you can [buy me a coffee]

[this blogpost]: https://mydaytodo.com/spring-boot-api-with-reactjs/
[pom file]: https://github.com/cptdanko/spring-boot-react-template/blob/main/pom.xml#L59
[frontend-maven-plugin]: https://github.com/eirslett/frontend-maven-plugin
[Jokes API with Spring RestTemplate]: https://mydaytodo.com/how-to-build-a-jokes-client-in-java-spring-boot-with-resttemplate/
[Call Rest API with Spring WebClient]: https://mydaytodo.com/how-to-call-rest-api-with-webclient/
[Node Typescript CRUD Notes]: https://github.com/cptdanko/node_typescript_crud_notes
[AWS DynamoDB query by non-primary]: https://mydaytodo.com/how-to-query-dynamodb-with-non-primary-key-column/
[AWS DynamoDB how to]: https://mydaytodo.com/aws-dynamodb-typescript-how-to/
[frontend in the repo]: https://github.com/cptdanko/react_typescript_todo_list
[native iOS app]: https://apps.apple.com/au/app/my-day-to-do-smart-task-list/id1020072048
[my blog]: https://mydaytodo.com/blog/
[AWS docs]: https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-envvars.html
[blogpost]: https://mydaytodo.com/blog/
[buy me a coffee]: https://www.buymeacoffee.com/bhumansoni
