Description
===========
Sample User Management Screen Controller application demonstrating how to create a Spring MVC application with Spring Data MongoDB and Maven Project in Eclipse IDE.

Technologies Used:
========
Backend: 
Spring 4.3, JDK 1.6, Apache-Maven 3.3.3

Unit Tests: 
Mockito, Junit 

Log:
Log4j/slfj4j Library

View: 
JSF, JSP

Frontend:
JavaScript, CSS

IDE:
Eclipse JEE Luna SR2

Database:
MongoDB

Functional Specs
========
1. Add User
2. Update User
3. Delete User

In Add User Function used Captcha Field from Google API "https://developers.google.com/recaptcha/docs/display"

To run this, first you must get key from google "https://www.google.com/recaptcha/admin#createsite"

After get key you must set your key in to "your_public_key" field from webapp/WEB-INF/index.jsp

107      <script type="text/javascript"
108            src="http://www.google.com/recaptcha/api/challenge?k=your_public_key">
109      </script>

API Keys

To use reCAPTCHA, you need to sign up for API keys for your site. The keys are unique to the domain or domains you specify, and their respective sub-domains. Specifying more than one domain could come in handy in the case that you serve your website from multiple top level domains (for example: yoursite.com, yoursite.net).

By default, all keys work on "localhost" (or "127.0.0.1"), so you can always develop and test on your local machine.

visit "https://developers.google.com/recaptcha/intro"

Building
========

Preparing the data source

1. Run MongoDB, to download the mongoDB please visit http://www.mongodb.org/downloads

2. There's no need to create any collections because Spring will create them automatically

3. InitMongoService will insert our sample data automatically. If you dont want to use it you can disable from webapp/WEB-INF/ajaxDispatcherServlet-servlet.xml

REFERENCES
==========

- Spring:
http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/
http://stackoverflow.com/questions/2129876/using-spring-mapping-to-root-in-web-xml-static-resources-arent-found
http://stackoverflow.com/questions/5252065/spring-mvc-how-to-create-a-default-controller-for-index-page
http://docs.spring.io/docs/Spring-MVC-step-by-step/part1.html
http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
http://stackoverflow.com/questions/2175502/spring-application-context-access-web-xml-context-params
http://www.mkyong.com/spring/how-to-define-bean-properties-in-spring/
http://www.tutorialspoint.com/spring/spring_mvc_hello_world_example.htm
http://www.javabeat.net/spring-4/
http://www.subshell.com/en/subshell/blog/Spring-3-MVC-Dependency-Injection-for-annotated-Controllers100.html
https://www.youtube.com/user/koushks
http://www.pretechsol.com/2013/11/springdata-spring-mvc-simple-example.html#.VdoyB_ntlBc
http://www.furkanzumrut.com/jsf-proje-asamalari-project-stage

- Git:
https://help.github.com/articles/generating-ssh-keys
http://githowto.com/pushing_a_change

- MongoDB:
http://docs.mongodb.org/manual/tutorial/getting-started/
https://university.mongodb.com/courses/10gen/M101J/2014_January/courseware/Week_1_Introduction/52549da3e2d4231cc6084010/
https://github.com/krams915/spring-mongodb-tutorial/tree/master/spring-mongodb-tutorial/
https://blog.openshift.com/day-22-developing-single-page-applications-with-spring-mongodb-and-angularjs/
http://www.journaldev.com/4144/spring-data-mongodb-example-tutorial

- Maven:
http://www.mkyong.com/maven/maven-jetty-plugin-examples/
https://wiki.jasig.org/display/UPM32/Creating+a+Simple+Maven+Project
https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html
http://stackoverflow.com/questions/2619598/differences-between-dependencymanagement-and-dependencies-in-maven
http://www.kyleblaney.com/maven-best-practices/
https://docs.gradle.org/current/userguide/artifact_dependencies_tutorial.html

- Test:
https://dzone.com/articles/integration-testing-mongodb
http://blog.yohanliyanage.com/2012/11/integration-testing-mongodb-spring-data/
http://stackoverflow.com/questions/29587430/spring-data-mongodb-junit-test
http://www.luckyryan.com/2013/06/28/unit-testing-with-mockito/
https://samerabdelkafi.wordpress.com/2013/07/01/junit-test-with-mockito-and-spring/
https://gualtierotesta.wordpress.com/2013/10/03/tutorial-using-mockito/
