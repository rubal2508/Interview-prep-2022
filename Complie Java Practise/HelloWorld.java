import java.io.*;
import java.util.*;
import java.lang.*;


public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MyClass myClass = new MyClass();
        myClass.print();

        MySolution ms = new MySolution();
        ms.solve();
    }
}


class MySolution {
    
    public void solve(){
        System.out.println("Hello, World from MySolution");
    }
    
}


// javac -d target HelloWorld.java 
// java -cp target HelloWorld

// javac HelloWorld.java 
// java HelloWorld