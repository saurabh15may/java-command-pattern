###### Please find the steps to build and run the project

##### Run the Project from shell\terminal

>Got to the project root directory.
> Run the below command to build the project and run all the test cases
```sh
gradle build
```

>Run the below command to run the application. Please provide the filename where all the Commands are placed as an INPUT as shown below.
```sh
gradle run -Pfilename="test-data\valid-commands-1.txt"
gradle run -Pfilename="test-data\valid-commands-2.txt"
gradle run -Pfilename="test-data\valid-commands-2.txt --log"
```

>Run the below command to run the application with addition output. 
>Append "--log" to the filename as shown below. This will also print the command execution sequence with the status of each command at the end of the output.
```sh
gradle run -Pfilename="test-data\invalid-commands.txt --log"
gradle run -Pfilename="test-data\mix-commands.txt --log"
```

##### Run the project from Eclipse/IntelliJ
```sh
Import as Gradle project.
Provide filename as argument inside Run Configuration.
Right Click Project - Run As - Java Application.
Right Click Project - Run As - JUnit Test.
```

