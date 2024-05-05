public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MyClass myClass = new MyClass();
        myClass.print();
    }
}


// javac -d target HelloWorld.java 
// java -cp target HelloWorld