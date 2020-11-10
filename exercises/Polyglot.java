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
           context.eval("python", pythonFile);

           //Run Python code from a String
           String pythonCode = "print('Running from Python code string: ');" + "print(abs(" + input + "));";
           context.eval("python", pythonCode);

           //Run Python code from bindings
           Value pyBindings = context.getBindings("python");
           System.out.println("Running Python from bindings: " + pyBindings.getMember("abs").execute(input));
        }
    }

   public static void main(String[] args) {
        jsSqrt(9);
        System.out.println("===============");
        //Toggle comment below once you have implemented the pyAbs method
        pyAbs(-3);
    }
}