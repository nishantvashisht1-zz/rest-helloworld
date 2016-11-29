[![Build Status][travis-badge]][travis-badge-url]

Rest Hello World
===================
This is  a simple REST service example using [**Spring**](https://spring.io/guides/gs/rest-service/). 

# Build
Execute the following command from the parent directory to compile the project:

```
mvn clean install
```
Once the build completes successfully, you should have the artifact `rest-helloworld.war` in the `target` folder.

# Deploy
You can deploy the `rest-helloworld.war` in a [Tomcat](http://tomcat.apache.org/) web container or any other JEE web 
container of your choice.

# Test
You can test it using RESTClient or Postman. This project has been tested using RESTClient. 
To test follow the steps below:

1. Download WizTools.org RESTClient.
2. Start REST Client: java -jar restclient-ui-3.4-jar-with-dependencies.jar

#### Testing GET operation
URL: `http://localhost:8080/rest-helloworld/customers/1`
HTTP Method: GET
Header: Accept: application/json

Expected Response Body:
```
{
  "id" : 1,
  "firstName" : "Robert",
  "lastName" : "Land",
  "address" : {
    "street" : "2486 Maxwell Farm Road",
    "city" : "Waynesboro",
    "state" : "VA",
    "zipCode" : "22980"
  }
}
```

#### Testing POST operation
URL: `http://localhost:8080/rest-helloworld/customers`
HTTP Method: POST
Header: 
Content-Type: application/json
Accept: application/json
Request Body:
```
{
  "firstName" : "John",
  "lastName" : "Doe",
  "address" : {
    "street" : "123 Nowhere Street",
    "city" : "Notown",
    "state" : "MA",
    "zipCode" : "02456"
  }
}
```

Expected Response Body:
```
{
  "id" : 4,
  "firstName" : "John",
  "lastName" : "Doe",
  "address" : {
    "street" : "123 Nowhere Street",
    "city" : "Notown",
    "state" : "MA",
    "zipCode" : "02456"
  }
}
```

#### Testing DELETE operation
URL:` http://localhost:8080/rest-helloworld/customers/4`
HTTP Method: POST
Header: 
Content-Type: application/json
Accept: application/json

Expected Response Body:
```
{
  "id" : 4,
  "firstName" : "John",
  "lastName" : "Doe",
  "address" : {
    "street" : "123 Nowhere Street",
    "city" : "Notown",
    "state" : "MA",
    "zipCode" : "02456"
  }
}
```

#### Testing UPDATE operation
URL: `http://localhost:8080/rest-helloworld/customers/1`
HTTP Method: PUT
Header: 
Content-Type: application/json
Accept: application/json
Request Body:
```
{
  "firstName" : "Robert",
  "lastName" : "Redford",
  "address" : {
    "street" : "2486 Maxwell Farm Road",
    "city" : "Waynesboro",
    "state" : "VA",
    "zipCode" : "22980"
  }
}
```

Expected Response Body:
```
{
  "id" : 1,
  "firstName" : "Robert",
  "lastName" : "Redford",
  "address" : {
    "street" : "2486 Maxwell Farm Road",
    "city" : "Waynesboro",
    "state" : "VA",
    "zipCode" : "22980"
  }
}
```

#### Testing PARTIAL UPDATE operation
URL: `http://localhost:8080/rest-helloworld/customers/1`
HTTP Method: PATCH
Header: 
Content-Type: application/json
Accept: application/json
Request Body:
```
{
  "firstName" : "John",
}
```

Expected Response Body:
```
{
  "id" : 1,
  "firstName" : "John",
  "lastName" : "Redford",
  "address" : {
    "street" : "2486 Maxwell Farm Road",
    "city" : "Waynesboro",
    "state" : "VA",
    "zipCode" : "22980"
  }
}
```

If you are interested in knowing more about this project, you can find in my blog 
['REST with Spring'](https://indrabasak.wordpress.com/2016/04/01/rest-with-spring/).


[travis-badge]: https://travis-ci.org/indrabasak/rest-helloworld.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/rest-helloworld/