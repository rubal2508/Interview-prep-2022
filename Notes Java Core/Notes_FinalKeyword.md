In Java, the `final` keyword is used to restrict the user from modifying variables, methods, and classes. Once initialized, a `final` variable's value cannot be changed, a `final` method cannot be overridden, and a `final` class cannot be subclassed. Here are the main ways the `final` keyword can be used in Java:

1. **Final Variables**:
   - **Final Instance Variables**: A `final` instance variable can only be assigned a value once, either at the time of declaration or in the constructor of the class. Once assigned, its value cannot be changed.
   - **Final Local Variables**: A `final` local variable is a variable that is declared and initialized only once, and its value cannot be changed after initialization.

   Example:
   ```java
   public class MyClass {
       final int constant = 10; // Final instance variable

       public void myMethod() {
           final int x = 5; // Final local variable
           // x = 10; // Error: Cannot assign a value to final variable x
       }
   }
   ```

2. **Final Methods**:
   A `final` method cannot be overridden by subclasses. This is often used when a method's implementation should not be changed in any subclass.

   Example:
   ```java
   public class Parent {
       public final void display() {
           System.out.println("Parent's display method");
       }
   }

   public class Child extends Parent {
       // This will cause a compilation error:
       // @Override
       // public void display() { }
   }
   ```

3. **Final Classes**:
   A `final` class cannot be subclassed. This is typically used when you want to prevent any further extension of a class.

   Example:
   ```java
   final class FinalClass {
       // Class definition
   }

   // This will cause a compilation error:
   // class Subclass extends FinalClass { }
   ```

4. **Final Parameters**:
   A `final` parameter in a method indicates that the parameter's value cannot be modified within the method. This is useful for ensuring that method parameters are not accidentally changed inside the method.

   Example:
   ```java
   public void myMethod(final int x) {
       // x = 10; // Error: Cannot assign a value to final parameter x
   }
   ```

5. **Finalize Method**:
   The `finalize()` method is a special method in Java used for garbage collection. While not directly related to the `final` keyword, it's worth mentioning. It's called by the garbage collector on an object when garbage collection determines that there are no more references to the object.

   Example:
   ```java
   public class MyClass {
       protected void finalize() {
           // Finalization logic
       }
   }
   ```

These are the main ways the `final` keyword can be used in Java to enforce immutability, prevent inheritance, and ensure method and variable integrity.