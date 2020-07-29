# intercom-home-test
Problem Statement: We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID
 (ascending).

Overview:
I have created a web project from which we can take the input parameter such as
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
path:https://s3.amazonaws.com/intercom-take-home-test/customers.txt
Latitude: 53.339428
Longitude:-6.257664
and click on the submit button
This will automatically download the text file
It contains User Id(ascending order) and customer Names which is in 100 kms radius
