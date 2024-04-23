public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MyClass myClass = new MyClass();
        myClass.print();
    }
}


// javac -d bin HelloWorld.java 
// java -cp bin HelloWorld