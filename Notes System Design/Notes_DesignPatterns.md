# Design Patterns Notes


## SOLID Design Principles
1. Single Responsibility Principle
   - Class should have only 1 reason to change
2. Open/Closed Principle
   - Class should be open for extension but closed for modification
3. Liskov Substitution Principle
   - Superclass should be replacable with subclass
4. Interface Segregation Principle
   - Class should not be forced to implemenent methods which are not required
5. Dependency Inversion Principle
   - Class should be dependent on Interfaces rather than classes

<br>

## Creational Design Patterns
Governs how objects are created

### Singleton Design Pattern
- Use private constructor
- Add a public static method to get instance
- Instance itself is static & private
- Two ways of initialisation (Lazy and Eager)
- Eager way used extra memory
- Lazy way is not thread safe but can be made thread safe using synchronized keyword
- Singleton Design Pattern can be broken using Reflection API, Deserialization and Cloning


<br>

``` java
// Normal class

public class Animal{

    public Animal(){

    }
}
```

``` java
// Eager way of initialisation (Uses extra memory)

public class Animal{

    private static Animal instance = new Animal();
    
    private Animal(){}

    public static Animal getInstance(){
        return instance;
    }
}
```

``` java
// Lazy way of initialisation (Not thread safe)

public class Animal{

    private static Animal instance;
    
    private Animal(){}

    public static Animal getInstance(){
        if(null == instance) instance = new Animal();
        return instance;
    }
}
```

``` java
// Lazy way of initialisation with Thread safety

public class Animal{

    private static Animal instance;

    private Animal(){}

    /*
    public synchronized static Animal getInstance(){
        if(null == instance) instance = new Animal();
        return instance;
    }
    */

    public static Animal getInstance(){
        if(null == instance){
            synchronized(Animal.class){
                if(null == instance){
                    instance = new Animal();
                }
            }
        } 
        return instance;
    }

}
```

``` java
// breaking singleton design pattern

// 1. Using Java reflections API 
Animal a1 = Animal.getInstance();
System.out.println(a1.hashCode());

Constructor<Animal> constructor = Animal.class.getDeclaredConstructor();
constructor.setAccessible(true);
Animal a2 = constructor.newInstance();
System.out.println(a2.hashCode());


// 2. Using deserialization (Reading object from file or input stream) assuming the class implements seriralizable interface
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a1.ob"));
oos.writeObject(a1);
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a1.ob"));
Animal a3 = (Animal)ois.readObject();
System.out.println(a3.hashCode());


// 3. Using cloning assuming the class implements Clonable interface
Animal a4 = (Animal)a1.clone();
System.out.println(a4.hashCode());



// Solution : 
// 1. Throw run time exception from inside the constructor if instance is not null
// 2. Implement readResolve method
// 3. Override clone method

public class Animal implements Serializable, Clonable{

    private static Animal instance;

    private Animal(){
        if(instance != null){
            throw new RuntimeException("You are trying to break singleton pattern")
        }
    }

    public static Animal getInstance(){
        if(null == instance){
            synchronized(Animal.class){
                if(null == instance){
                    instance = new Animal();
                }
            }
        } 
        return instance;
    }

    public Object readResolve(){
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return instance;
    }

}
```

<br>

### Factory Design Pattern

- Focus on SOLID dependency inversion 
- Focus on creating objects for interface rather than implementation
- Loose coupling, more robust code

<br>

``` java
public interface Employee{

    public int getSalary();

}
```

``` java
public class AndroidDeveloper implements Employee{
    
    public int getSalary(){
        System.out.println("AndroidDeveloper salary is 50000");
        return 50000;
    }
}
```
``` java
public class WebDeveloper implements Employee{
    
    public int getSalary(){
        System.out.println("WebDeveloper salary is 60000");
        return 60000;
    }
}
```

``` java
public class EmployeeFactory{

    public static Employee getEmployee(String empType){
        if(empType.equalsIgnoreCase("AndroidDeveloper")) return new AndroidDeveloper();
        else if(empType.equalsIgnoreCase("WebDeveloper")) return new WebDeveloper();
        return null;
    } 
}
```

``` java
public class SpringMainApp{

    public static void main(String[] args){
        Employee e = EmployeeFactory.getEmployee("AndroidDeveloper");
        System.out.println(e.getSalary());
    }
}
```

### Abstract Factory Design Pattern
- Skipping
- Adding more abstraction in Factory Design Pattern

### Builder Design Pattern
- Complex Object Creation: If your class has a large number of parameters or optional parameters, the builder pattern can make object creation more readable and flexible.
- Method Chaining: Builders often use method chaining, which allows you to chain multiple method calls together, making the code more concise and readable.
- Immutability: In many cases, builders are used to create immutable objects, where once the object is constructed, its state cannot be changed. This can be desirable for ensuring thread safety and preventing unintended modifications.  
- Note: private constructor & inner static class
<br><br>

``` java
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String department;

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.department = builder.department;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        // Optional parameters - initialized with default values
        private Integer id;
        private String name;
        private Integer age;
        private String department;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public static void main(String[] args) {
        // Creating an Employee using the builder pattern without "new" keyword
        Employee employee1 = Employee.builder()
                                     .id(1)
                                     .name("John")
                                     .age(30)
                                     .department("IT")
                                     .build();

        // Accessing employee information
        System.out.println("Employee 1: " + employee1.getName() +
                           ", Age: " + employee1.getAge() +
                           ", Department: " + employee1.getDepartment());
    }
}


```

### Prototype Design Pattern
- When a complex logic is needed to execute before creating an object, in that case we use this pattern
- We use exisitng objects as prototypes to create new objects to prevent execution of complex logic everytime
- for eg object having db connections or instantiated after reading a file or instantiated using network calls
- Override clone method to implememt this Design Pattern

``` java
NetworkConnection n1 = new NetworkConnection();
NetworkConnection n2 = n1.clone();
```

<br><br>

## Behavioural Design Patterns
Governs how objects interact with each other

### Observer Design Pattern

``` java
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete subject
class WeatherStation implements Subject {
    private double temperature;
    private List<Observer> observers;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.receiveUpdate(temperature);
        }
    }
}

// Observer interface
interface Observer {
    void receiveUpdate(double temperature);
}

// Concrete observer
class WeatherDisplay implements Observer {
    @Override
    public void receiveUpdate(double temperature) {
        System.out.println("Weather display: Temperature is " + temperature + " degrees Celsius");
    }
}

// Client code
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create subject (WeatherStation) and observers (WeatherDisplay)
        WeatherStation weatherStation = new WeatherStation();
        WeatherDisplay weatherDisplay = new WeatherDisplay();

        // Register observer
        weatherStation.addObserver(weatherDisplay);

        // Update subject state (temperature)
        weatherStation.setTemperature(25.5); // Observer (WeatherDisplay) will be notified and updated automatically
    }
}
```


### Iterator Design Pattern

The iterator pattern provides a way to access the elements of an object without exposing its underlying implementation.
  
- Our class has a getIterator() method which return iterator which has hasNext(), next() methods


### State Design Pattern
- Skipped

<br><br>

## Structural Design Patterns
Governs how code is structured

### Adapter Design Pattern
The Adapter design pattern allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of one class into another interface that a client expects. There are two main types of adapters: class adapters and object adapters. 

``` java
// Target interface
interface Target {
    void request();
}

// Adaptee (the class we want to adapt)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specificRequest() called");
    }
}

// Adapter class (Object Adapter)
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // Delegate the request to the specificRequest() method of Adaptee
        adaptee.specificRequest();
    }
}

// Client
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create an Adaptee object
        Adaptee adaptee = new Adaptee();

        // Create an Adapter object and pass the Adaptee object to its constructor
        Target adapter = new Adapter(adaptee);

        // Call the request() method of the Target interface
        adapter.request();
    }
}

```

### Proxy Design Pattern
- Skipped


