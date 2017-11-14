#### This application is a simulation of a toy robot moving on a square tabletop (refer PROBLEM.md for more details) developed in Java as a Gradle project using the Command Design pattern

##### Run form shell/terminal
###### Got to the project root directory and follow the instructions below.

> Run the below command to build the project and run all the test cases
```sh
gradle build
```

>Run the below command to run the application. Please provide filename where all the Commands are placed. a sample file test-data.txt" with test data is provided. This will also print the command execution log at the end of the output.
```sh
gradle run -Pfilename="test-data.txt"
```

##### Run form Eclipse/IntelliJ
>Import as Gradle project
>Provide filename as argument inside Run Configuration
>Right Click Project - Run As - Java Application
>Right Click Project - Run As - JUnit Test

