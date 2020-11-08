# GraalVM-Workshop
GraalVM Workshop as part of the module - Enterprise Software Development 2020-2021 at Fontys Venlo University of Applied Sciences.
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
Given the Docker image was installed successfully, the next step is to run the image in a Docker container by running the command below.
```
    docker run -it --name test-graalvm docker.io/oracle/graalvm-ce bash
```
This command will run an instance of GraalVM in a container with the name of *test-graalvm* and will automatically enter into the GraalVM CLI.   
If you do not want to get into the CLI immediately, remove the `bash` part from the end of the command and enter the GraalVM CLI via Docker Desktop.
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
### JavaScript
### Python
### R
## Advanced exercises
### Performance
### Native image
### Polyglot capabilities
