# headersFilter

### Programming exercise for Citi vacancy

###### It is a problem, which must be presented every day in the micros that develop:

1. Imagine that you have to remove all the headers from the HttpServletRequest that arrives on a micro.

2. To get them they have to return an object of this type: Map <String, List <String>>, where the key of that map represents the name of the header, and the value is a list of Strings, because List, because they can obtain more than one value for the same header (Check the HTTP specification)

3. To get a list of all the headers in a request, it can be done as follows: request.getHeaderNames ()

4. To obtain the value of a header you can obtain it in the following way: request.getHeaders (<<headerName>>)

Write the code using functional or declarative programming, to take all the request headers and put them in an object of type Map <String, List <String>>.

###### Additional:

• Write another method to return the same Map <String, List <String>> object, but filtered with only the headings that you indicate, through a list of Strings.

• The parameters of this second method are: HttpServletRequest request, List <String> headerNames, the return would be of type: Map <String, List <String>>

Again, the code for both methods has to be programmatically functional.

It has to be efficient, and meet basic quality standards (include UnitTest in the mentioned use cases).

###### Having into account the following specifications, the following microservice was created 
__________________________________________________________________________________________________________________________________

#### the next steps explain how to run this micro service

1. Clone this repository
.
2. Open terminal and go to the directory and run the following command using maven (this micro run in port **9090**).

            mvn clean install spring-boot:run 

3. Open Some programs to test the functionality of this micro, the routes exposed are:

>http://localhost:9090/v1/api/headers/extraction
> - this api is a GET request that returns a Map <String, List <String>>.
  
  
>http://localhost:9090/v1/api/headers/filter
> - this api is a POST request that returns a map <String, List <String>> filtering the headers that are requested.


#### to generate the uni test report use the following command

            mvn surefire-report:report


 

--------------------------------------------------------------------------------------------------------------------------------
 Created by: ****Alfonso Chavez Email: alfonso.chavez@ids.com.mx | alfonso.chavez.a@gmail.com****
