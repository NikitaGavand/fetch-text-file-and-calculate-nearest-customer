# intercom-home-test
Problem Statement: We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

Pre Requistes:
1. Eclipse/IntelliJ (Any IDE which supports Java Web Project)
2. Java 1.8
3. Tomcat Server to run the project on localhost:8080
4. Jar files: Are already in "WebContent/libs" folder
5. Junit Tools from Eclipse Marketplace
6. Configure the build path by the jar files mentioned in libs folder
7. Set your context root

Overview:
I have created a Java Web Project from which we can take the input parameter such as
1. URL path of the customer.txt file
2. Latitude of the Dublin office
3. Longitude of the Dublin office

and the ouput parameter is the text file is which is automatically download after we click on "get customer" button

Description:
Entry point:
I have created index.jsp which is the main UI of the test.
It consists of 3 input parameters mentioned above.
and a submit button which generates the text file.

Example given:
Customer Details Path: https://s3.amazonaws.com/intercom-take-home-test/customers.txt
Latitude: 53.339428
Longitude:-6.257664
and click on the submit button
This will automatically download the text file(Output.txt)
It contains User Id(ascending order) and customer Names which is in 100 kms radius


Test Cases:

I have written JUnit in com.intercom.home.assignment.test package
1. Controller Test
2. Service Test

I have also perform manual testing for jsp pages and created error.jsp for any UI input errors

Please Note:
1. All the input parameters are mandatory
2. I have also pushed the output.txt file into the repository to see the output

