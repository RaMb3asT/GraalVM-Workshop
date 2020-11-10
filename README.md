# GraalVM-Workshop
GraalVM Workshop as part of the module - Enterprise Software Development 2020-2021 at Fontys Venlo University of Applied Sciences.
## Table of contents
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
    + [Manual installation](#manual-installation)
      - [Windows](#windows)
      - [macOS](#macos)
      - [Linux](#linux)
    + [Docker installation](#docker-installation)
      - [Step 1](#step-1)
      - [Step 2](#step-2)
      - [Step 3](#step-3)
  * [Basic exercises](#basic-exercises)
    + [Java](#java)
      - [Java file](#java-file)
      - [Run Java](#run-java)
    + [JavaScript](#javascript)
      - [JavaScript file](#javascript-file)
      - [Run JavaScript](#run-javascript)
    + [Python](#python)
      - [Python file](#python-file)
      - [Run Python](#run-python)
    + [R](#r)
      - [R file](#r-file)
      - [Run R](#run-r)
  * [Advanced exercises](#advanced-exercises)
    + [Performance](#performance)
      - [Create the file](#create-the-file)
      - [Compile it](#compile-it)
      - [Run it on GraalVm](#run-it-on-graalvm)
      - [Run it on the default JVM](#run-it-on-the-default-jvm)
      - [Results discussion](#results-discussion)
    + [Native image](#native-image)
      + [Install native image](#install-native-image)
        - [On Linux or MacOS](#on-linux-or-macos)
        - [On Windows](#on-windows)
      - [Build an image](#build-an-image)
    + [Polyglot capabilities](#polyglot-capabilities)
## Prerequisites
For the successful participation in the workshop, [Docker](https://www.docker.com/get-started) as well as a text editor (e.g. Visual Studio Code) have to be previously installed by the participants.
## Installation
### Manual installation
For the manual installation of GraalVM on your machine, follow the corresponding to your operating system tutorial below.  
*The preferred and quicker way of installing GraalVM for this workshop however is with Docker.*
#### Windows
[Windows Tutorial](https://www.graalvm.org/docs/getting-started-with-graalvm/windows/)
#### macOS
[macOS Tutorial](https://www.graalvm.org/docs/getting-started-with-graalvm/macos/)
#### Linux
[Linux Tutorial](https://www.graalvm.org/docs/getting-started-with-graalvm/linux/)
### Docker installation
For the Docker installation of GraalVM, there are a few steps that have to be followed.  
#### Step 1
Depending on your operating system, open the **Command Prompt/PowerShell** for Windows or **Terminal** for macOS and Linux.  
Run the command below:
```
    docker pull oracle/graalvm-ce
```
This command will pull a Docker image of GraalVM that would be accessible both via Docker Desktop as well as your command line.
#### Step 2
Given the Docker image was installed successfully, the next step is to run the image in a Docker.
To do so, first create a folder called *exercises* on your Desktop, then via the command line navigate to that folder and run the command below. The folder will be used as a directory that connects the docker container and your machine and will store the files used in the workshop.

```
    //For Windows Command Prompt
    docker run -it -v %cd%:/exercises --name test-graalvm docker.io/oracle/graalvm-ce bash
    //Or
    //For Windows PowerShell and Linux terminal
    docker run -it -v ${pwd}:/exercises --name test-graalvm docker.io/oracle/graalvm-ce bash
````

This command will run an instance of GraalVM in a container with the name of *test-graalvm* and will automatically enter into the GraalVM CLI.   
If you do not want to get into the CLI immediately, remove the `bash` part from the end of the command and enter the GraalVM CLI via Docker Desktop.

If you closed the GraalVM bash, the line below will reopen it without running another instace of GraalVM.
```
    docker exec -it test-graalvm bash
```
#### Step 3
To check if GraalVM is running properly, run the command below in the GraalVM CLI. It gives information about the Java version, Runtime Environment as well Virtual machine utilized.
```
    java -version
```
The result:
```
    openjdk version "1.8.0_262"
    OpenJDK Runtime Environment (build 1.8.0_262-b10)
    OpenJDK 64-Bit Server VM GraalVM CE 20.2.0 (build 25.262-b10-jvmci-20.2-b03, mixed mode)
```
The third line of the result states that the virtual machine used by Java is actually GraalVM and not the standard JVM as seen below when you run the same command outside of the GraalVM environment.
```
    java version "1.8.0_181"
    Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
    Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```
## Basic exercises
### Java
Java is the default programming language supported by GraalVM. In addition, GraalVM supports other JVM based languages, such as Kotlin and Scala.
#### Java file
Create a file called `JavaTest.java` in your preferred text editor in the *exercises* directory on your Desktop and paste the following code:
```
public class JavaTest {

    public static void main(String[] args){
        long millis = System.currentTimeMillis();
        java.util.Date now = new java.util.Date(millis);
        System.out.println(now);
        System.out.println("Hello World!");
    }
}
```
#### Run Java
In order to run java you must first use the javac command to create a .class file.
```
javac JavaTest.java
```
Then you can run the .class file, by writing the following command:
```
java JavaTest
```
### JavaScript
The javascript runtime is provided included in GraalVM by default, so no installations will be needed.
#### JavaScript file
Create a file called `javascriptTest.js` in your preferred text editor in the *exercises* directory on your Desktop and paste the following code:
```
var now = new Date();
console.log(now);
console.log("Hello world!");
```
#### Run JavaScript
There are two ways to run the js file, using the standard "js" command, like so:
```
js javascriptTest.js
```
Or by using node, like so:
```
node javascriptTest.js
```
Node js is supported by default in graalvm, which is quite convenient for creating server applications.
### Python
The Python runtime is not provided by default and it can be added with the GraalVM Updater tool by running the command below in the GraalVM bash.
```
gu install python
```
#### Python file
Create a file called `pythonTest.py` using your preferred text editor in the *exercises* directory on your Desktop and paste the following code.
```
print ('Hello from Python file!')
```
#### Run Python
In order to run simple Python commands just use the line below, which will open an interactive shell:
```
graalpython
```
As to run the file created previously, navigate via the GraalVM bash to the *exercises* directory and run:
```
graalpython testPython.py
```
### R
The R runtime is not provided by default and it can be added with the GraalVM Updater tool by running the command below in the GraalVM bash.
```
gu install r
```
#### R file
Create a file called `rTest.r` using your preferred text editor in the *exercises* directory on your Desktop and paste the following code.
```
print ('Hello from R file!')
```
#### Run R
In order to run simple R commands just use the line below, which will open an interactive shell:
```
R
```
As to run the file created previously, navigate via the GraalVM bash to the *exercises* directory and run:
```
Rscript testR.py
```
## Advanced exercises
### Performance
In this exercise we will observe the performance benefits of GraalVM over the default HotSpot JVM.
#### Create the file
In order for this example to work, create an empty file called HeavyStreamComputation.java. In it, place the following code:
```
/* This application at its core reads a sentence as an execution argument,
and counts the uppercase characters in the sentence many times through
the usage of stream operations and lambdas. It is used for benchmarking purposes.
 */

public class HeavyStreamComputation {
    static final int ITERATIONS = Math.max(Integer.getInteger("iterations", 1), 1);


    // args contains commandline arguments
    public static void main(String[] args) {
        //Combines commandline args as a sentance.
        String sentence = String.join(" ", args);
        //nested forloop for extra computation)
        for (int iter = 0; iter < ITERATIONS; iter++) {
            if (ITERATIONS != 1) System.out.println("-- iteration " + (iter + 1) + " --");

            //total uppercase characters counted
            long total = 0;

            //time vars
            long start = System.currentTimeMillis();
            long last = start;

            //use stream operations 10 million times
            for (int i = 1; i < 10_000_000; i++) {
                total += sentence.chars().filter(Character::isUpperCase).count();

                //every 1 million iterations print and reset time.
                if (i % 1_000_000 == 0) {
                    long now = System.currentTimeMillis();
                    System.out.printf("%d (%d ms)%n", i / 1_000_000, now - last);
                    last = now;
                }
            }
            //print out the total uppercase chars counted, as well as the total exec time
            System.out.printf("total: %d (%d ms)%n", total, System.currentTimeMillis() - start);
        }
    }
}
```
#### Compile it
In order for us to test running it on GraalVM and the JVM, we must first compile it. Write down the following command in the GraalVM command line:
```
javac HeavyStreamComputation.java 
```

#### Run it on GraalVM
In order to run it on GraalVM, we must first compile it, and then execute like a normal java application. If you read the comment in the application code, you would know that you need to provide a sentance through the program arguments. The sentence chosen for this example is:
```
I aM a RanDom peRson that LoVes to Use aRbiTrarY CapItAliZaTion
```
so, the full command looks like so.
```
java HeavyStreamComputation I aM a RanDom peRson that LoVes to Use aRbiTrarY CapItAliZaTion
```
#### Run it on the default JVM
To run it on the default JVM, we must specify an option before the java execution command, namely ```-XX:-UseJVMCICompiler```. The javac command should then look like this:
```
java -XX:-UseJVMCICompiler HeavyStreamComputation I aM a RanDom peRson that LoVes to Use aRbiTrarY CapItAliZaTion
```

#### Results discussion
Generally speaking the GraalVM version should be faster. By how much depends on system factors, such as processor core count, memory, etc. A large advantage of GraalVM is its utilization of threading and multiprocessing in terms of StreamAPI.

### Native image
In this exercise we will see how to create a simple native image executable, as well as a native image class library. Native image is not a part of the default GraalVM, and must be downloaded and installed seperately.
#### Install native image
Fortunately you have all you need to install native image in GraalVM. In order to install native image, paste this command in the GraalVM CLI:
```
gu install native-image
```
Docker should already provide the rest of the necessary tools, such as gcc, which are needed for native images. In case you are not usin docker, you need to take a few extra steps:
##### On Linux or MacOS
The extra tools needed are:  glibc-devel, zlib-devel, gcc, and some distros of linux may need libstdc++-static. Depending on your linux distribution, enter the following commands into the commandprompt:
For Oracle Linux:
```
sudo yum install gcc glibc-devel zlib-devel
```
For Ubuntu Linux:
```
sudo apt-get install build-essential libz-dev zlib1g-dev
```
For other Linux:
```
sudo dnf install gcc glibc-devel zlib-devel libstdc++-static
```
For MacOS:
```
xcode-select --install
```
##### On Windows
You need MSVC 2017 15.5.5 or later version.

#### Build an image
In order to build an image we need a .class or a .jar file, meaning that we have to compile or .java class/application. To make this tutorial simpler, I will be using the JavaTest.java class, which we covered in the Java tutorial. First we must compile it, in case we haven't already.
```
javac JavaTest.java
```
This should yield a JavaTest.class file in the exercises directory. In order to build an image from this class file, we need to provide the following command:
```
native-image JavaTest
```
This will leave us with an executable file named javatest. The nature of the executable file depends on the OS. For example, on windows it will be an exe, and in docker it will be a linux executable file. We run it as we would run any other program:
```
./javatest
```
Note that the name is all in lowercase now.
The general syntax for building a native image can be seen below (with a .class object at the top, .jar object at the bottom):
```
native-image [options] class [imagename] [options]
```
```
native-image [options] -jar jarfile [imagename] [options]
```


### Polyglot capabilities
Copy the code below into a text editor, save it as `Polyglot.java` in the *exercises* directory and fill-in the empty spots in the method `pyAbs` as to practice the different methods of combining programming languages in GraalVM.
```java
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Polyglot {

    //Context - GraalVM polyglot class that allows to evaluate code of guest languages
    //Bindings - Values that represents the top-most members of a guest language; API to access foreign libraries

    //Embedding JavaScript - Print out the square root of a number by incorporating GraalVM polyglot features
    public static void jsSqrt(int input) {
        //Load JavaScript file
        String jsFile = "";
        try {
            jsFile = new String(Files.readAllBytes(Paths.get("javascriptTest.js")));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        //Run JavaScript code
        try (Context context = Context.create("js")){
           
           //Run JavaScript code from a file
           context.eval("js", jsFile);

           //Run JavaScript code from a String
           String jsCode = "print('Running from JavaScript code string: ');" + "print(Math.sqrt(" + input + "));";
           context.eval("js", jsCode);

           //Run JavaScript code from bindings
           Value jsBindings = context.getBindings("js");
           System.out.println("Running JavaScript from bindings: " + jsBindings.getMember("Math").getMember("sqrt").execute(input));
        }
    }

    // Embedding Python - Print out the absolute value of a number by incorporating GraalVM polyglot features
    public static void pyAbs(int input) {
        //Load Python file
        String pythonFile = "";
        try {
            pythonFile = new String(Files.readAllBytes(Paths.get("pythonTest.py")));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        //Run Python code
        try (Context context = Context.create("python")){
           //Run Python code from a file
           //Code here

           //Run Python code from a String
           //Code here

           //Run Python code from bindings
           //Code here
        }
    }

   public static void main(String[] args) {
        jsSqrt(9);
        System.out.println("===============");
        //Toggle comment below once you have implemented the pyAbs method
        //pyAbs(-3);
    }
}
```
In order to run the code above, navigate via the GraalVM bash to the *exercises* directory and run:
```
javac Polyglot.java
java Polyglot
```
