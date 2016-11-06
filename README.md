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

### Packages

To call mocks server link should look like that:
_http://\<address\>:8090/rjmock/\<package_name\>/\<subpath\>\<query_parameters\>_

_<package_name\>_ tells which _<package_name\>.json_ file in _descriptors_ directory should be used.

_/\<subpath\>\<query_parameters\>_ allows to select response which has been defined in package file

Example of package file:
```
{
  "responses": [
    {
      "response": "test/test.json",
      "subpath": "test",
      "code": 200,
      "type": "json",
      "conditions":[
        {
          "param": "test",
          "value": "value"
        }
      ]
    },
    {
      "response": "s",
      "subpath":"_any_",
      "code": 404,
      "type": "text"
    }
  ]
}
```

Each response has:
 * _response_ - string of response or path to file with response
 * _subpath_ - what subpath in link suggest this response. *\_any\_* is special reponse type used when no other _subpath_ is valid (conditions still can be checked)
 * _code_ - what is http return code
 * _type_ - what is response type (example: json or text)
 * _conditions_ - what are requested parameters and their values 
 
Conditions are array and each has
 * _param_ - that is parameter name
 * _value_ - required value

Link that will call first response [http://localhost:8090/rjmock/test/test?test=value](http://localhost:8090/rjmock/test/test?test=value)

**_Packages and responses are read when called so can be changed without restarting application_**

### Responses
If request has response kept in file then this file should be put in _RJMockData/responses directory_ directory structure inside is not important. The only requirement is that path inside _responses_ has to be given in package description 

Package fragment
```
"responses": [
    {
      "response": "test/test.json",
(...)
```

Structure
```
RJMockData
|
|---responses
    |
    |---test
        |
        |---test.json
```

