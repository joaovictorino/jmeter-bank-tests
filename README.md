## How to execute JMeter

Initialize the application using docker-compose on root folder
````sh
docker-compose up
````

## API actions

Create account
````sh
curl -X POST http://localhost:8080/account/123456/1000
````

Query account
````sh
curl http://localhost:8080/account/123456
````

Transfer money
````sh
curl -X POST http://localhost:8080/transfer/123456/654321/5  
````

Open JMeter software and open project files .jmx inside jmeter folder

It's possible to execute JMeter from terminal, change the path of the files
````sh
./jmeter -n -t /home/joao/Sources/Test/jmeter-bank-tests/jmeter/restBank.jmx -l /home/joao/Sources/Test/jmeter-bank-tests/jmeter/restBank.jtl -e -o /home/joao/Source/Test/jmeter-bank-tests/jmeter/report
````

## RestAssured
With application running go to restassured folder and execute
````sh
mvn test
````