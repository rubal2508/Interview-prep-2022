import java.io.*;
import java.util.*;
import java.lang.*;


public class LeetCode {
    public static void main(String[] args) {

        System.out.println("".trim());

        LeetCode leetCode = new LeetCode();
        int res = leetCode.add(1, 2);
        // System.out.println("res: " + res);
    }

    public int add(int a, int b){
        // System.out.println("a: " + a + " b: " + b + " a+b: " + (a+b));
        return a + b;
    }
}


// javac -d target HelloWorld.java 
// java -cp target HelloWorld

// javac HelloWorld.java 
// java HelloWorld