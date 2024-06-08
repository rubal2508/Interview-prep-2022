The `static` keyword in Java is used to define members (variables and methods) that belong to the class itself, rather than to instances of the class. This means that a `static` member is shared across all instances of the class and can be accessed using the class name directly, without needing to create an instance of the class. Here are the main ways the `static` keyword can be used in Java:

1. **Static Variables (Class Variables)**:
   Static variables are shared among all instances of a class. They are declared using the `static` keyword. There is only one copy of a static variable, regardless of how many instances of the class are created. Static variables are initialized only once, at the start of the execution, and they retain their values until the program terminates.

   Example:
   ```java
   public class MyClass {
       static int count = 0;

       public MyClass() {
           count++; // Increment count each time a new instance is created
       }
   }
   ```

2. **Static Methods**:
   Static methods belong to the class rather than to any specific instance. They can be called directly using the class name, without the need to instantiate the class. Static methods cannot access instance variables directly (unless they are passed as parameters), but they can access static variables and other static methods.

   Example:
   ```java
   public class MathUtils {
       public static int add(int a, int b) {
           return a + b;
       }
   }

   // Calling the static method without creating an instance
   int sum = MathUtils.add(5, 3);
   ```

3. **Static Initialization Block**:
   Static initialization blocks are used to initialize static variables or perform other one-time initialization tasks for the class. They are executed once when the class is loaded into the JVM. Static initialization blocks are declared using the `static` keyword and enclosed within curly braces `{}`.

   Example:
   ```java
   public class MyClass {
       static {
           // Static initialization block
           System.out.println("Static block initialized");
       }
   }
   ```

4. **Static Nested Classes**:
   Static nested classes are nested classes that are declared with the `static` keyword. They are essentially independent of any instance of the outer class and can be instantiated without an instance of the outer class.

   Example:
   ```java
   public class OuterClass {
       static class StaticNestedClass {
           // Nested class definition
       }
   }
   ```

5. **Static Import**:
   Static imports allow static members (fields and methods) of a class to be imported directly into another class, allowing them to be used without qualification (using the class name).

   Example:
   ```java
   import static java.lang.Math.PI;

   public class Circle {
       double calculateArea(double radius) {
           return PI * radius * radius;
       }
   }
   ```

These are the main ways the `static` keyword can be used in Java to define class-level members and behavior.