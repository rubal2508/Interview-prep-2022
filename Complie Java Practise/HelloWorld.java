import java.util.*;
import java.lang.*;


public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MyClass myClass = new MyClass();
        myClass.print();
    }
}


// javac -d target HelloWorld.java 
// java -cp target HelloWorld



import java.io.*;
import java.util.*;
import java.lang.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution' and should not be public.
class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        MySolution ms = new MySolution();
        
        ms.solve();
    }
}

class MySolution {
    
    public void solve(){
        System.out.println("Hello, World from MySolution");
    }
    
}