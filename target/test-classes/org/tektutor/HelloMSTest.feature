Feature: Develop a hello microservice

    Scenario: I should be access microservice
        Given The microservice is deployed
        When  I invoke endpoint "http://localhost:8085/tektutor-hello-ms/microservices/hello/sayHello"
        Then I expect the response code to be "200"