### Run all tests
`./gradlew test -Dkarate.env=<env> --tests RunAllTests`

### Run one test
`./gradlew test -Dkarate.env=<env> --tests <TestName(java file)>`

### Change Report Portal settings from cli
`./gradlew test -Dkarate.env=<env> -Drp.project=myProject -Drp.launch=karate-mocks -Drp.attributes=key:value --tests <TestName(java file)>`

### Report portal 
[Report Portal integration with junit5](https://github.com/reportportal/agent-java-junit5 "Report Portal integration with junit5")

For send test results in Report Portal used `agent-java-junit5` and `logger-java-logback`
In all java tests files must be annotation, ex:
```java
import com.epam.reportportal.junit5.ReportPortalExtension;

@ExtendWith(ReportPortalExtension.class)
class Test {

}
```

Configure connection and other settings for report portal in `resources/reportportal.properties` file, they showed in "Profile" on Report Portal, ex:
```rst
COPY AND SAVE IT AS A REPORTPORTAL.PROPERTIES FILE
REQUIRED
rp.endpoint = http://reportportal.rgs.ru:8080
rp.uuid = 44444444-4444-4444-4444-444444444444
rp.launch = TEST_EXAMPLE
rp.project = EXAMPLE_PROJECT

NOT REQUIRED
rp.enable = true
rp.description = My awesome launch
rp.attributes = key:value; value;
rp.convertimage = true
rp.mode = DEFAULT
rp.skipped.issue = true
rp.batch.size.logs = 20
rp.keystore.resource = <PATH_TO_YOUR_KEYSTORE>
rp.keystore.password = <PASSWORD_OF_YOUR_KEYSTORE>
```
### Setup enviroments for tests
[Karate env](https://github.com/intuit/karate#switching-the-environment "Karate env")

For defualt, karate searching file `karate-config-<env>.js`  for current env in classpath
We can use it for define all nessesery variables in out tests
For example set url for prod and preprod:
`test.feature`
```rst
Feature: Example test

  Background:
    * url MyTestUrl
    * path '/test'
    * configure headers = { 'Content-Type': 'application/json'}

  Scenario: test action
    Given request read('Request.json')
    When method POST
    Then status 200
```
`karate-config-prod.js`
```rst
function fn() {
  var config = {};
  config.MyTestUrl = 'http://example-prod.com';
  return config;
}
```
`karate-config-preprod.js`
```rst
function fn() {
  var config = {};
  config.MyTestUrl = 'http://example-preprod.com';
  return config;
}
```
For set env just use `-Dkarate.env=<env>` or set system variable\properties `karate.env=<env>`