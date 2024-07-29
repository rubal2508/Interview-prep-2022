
# SpringBoot Notes

### [Introduction to Spring boot | Its Advantage over Spring MVC and Servlets based Web applications](https://www.youtube.com/watch?v=TMX1kQ4W4hI&list=PL6W8uoQQ2c60g6_fcjDCLHSx1LBeVYqyZ&index=3&ab_channel=Concept%26%26Coding-byShrayansh)


### [Introduction to Maven and its Lifecycle](https://www.youtube.com/watch?v=1e4jNP8iKLo&list=PL6W8uoQQ2c60g6_fcjDCLHSx1LBeVYqyZ&index=4&ab_channel=Concept%26%26Coding-byShrayansh)


## Constructor VS Field Injection

### Constructor Injection
Constructor Injection is a method of injecting dependencies via a class constructor. This approach is preferred in most scenarios because it has several benefits.

1.	Immutability: Constructor injection allows the class to be immutable since dependencies are set only once during the creation of the object.
2.	Mandatory Dependencies: Ensures that all required dependencies are provided at the time of object creation, preventing the possibility of an object being in an inconsistent state.
3.	Testability: Makes unit testing easier by allowing the injection of mock dependencies directly through the constructor.
4.	Encourages Good Design: Promotes the use of dependency injection, leading to better design practices by emphasizing the explicit declaration of dependencies.

### Field Injection
Field Injection injects dependencies directly into the class fields using the @Autowired annotation. This method is less verbose but has some drawbacks.

Advantages:

1.	Simplicity: Less boilerplate code compared to constructor injection, making it quick to implement.
2.	Convenience: Suitable for small projects or prototypes where the simplicity and speed of development are more important than the design principles.

Disadvantages:

1.	Immutability Issues: The class cannot be made immutable since the fields can be changed after object creation.
2.	Hidden Dependencies: Dependencies are not visible in the constructor, making it harder to identify what the class depends on.
3.	Testability: More difficult to inject mock dependencies for unit testing since reflection or frameworks like Spring Test are often required to set the fields.
4.	Null Pointer Exceptions: More prone to null pointer exceptions if the dependencies are not correctly injected.


### Setter Injection
Setter Injection (not covered in detail here) is another option, which can be useful for optional dependencies or for cases where the dependency needs to be changed during the object’s lifecycle.