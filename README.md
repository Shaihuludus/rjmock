# RJMOCK

## Summary

It is a tool for creating mock responses. It allows to quick setup of different responses (using url and parameters) for REST services.

## Prerequisites
   * JDK 8
   * Maven 3

## How to build and run
```
mvn clean package
```
It will create build project and prepare zip file in target directory. It can be unzipped in any location. To run project use
```
java - jar <jar file name>
```
in unzipped directory

Test mock can be retrieved by calling _address:8090/rjmock/test_

## Structure

_config_ - there is config file for application
_RJMockData_ - all mocks files

## Configuration
Configuration is in _application.properties_ file 

```
server.port - application port - default: 8090
data.dir - directory with RJMockData - default is in project directory
```

## Mock description

**In progress**

