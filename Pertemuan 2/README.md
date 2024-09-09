# Konsep Object Oriented Programming (OOP)

OOP atau Object Oriented Programming adalah suatu metode pemrograman yang berorientasi pada objek yang memiliki data atau atribut serta method didalamnya. Tujuan dari menggunakan OOP adalah untuk mempermudah pekerjaan programmer ketika melakukan pengembangan program dengan mengikuti model yang telah ada di kehidupan sehari-hari, pemrograman menjadi lebih fleksibel, dan dapat digunakan luas dalam skala besar. Dalam sebuah program, sebuah objek yang besar dibentuk dari gabungan beberapa objek yang lebih kecil, dimana objek tersebut saling berkomunikasi dan bertukar infomasi dengan objek yang lain untuk mencapai hasil akhir.

![1706481523437](https://github.com/user-attachments/assets/c217c16a-d8d1-4b59-a740-8230f44411fc)

## Konsep OOP

Dalam object oriented programming, terdapat beberapa konsep yang menjadi dasar penggunaan OOP. Konsep tersebut adalah :
### 1. Class dan Object
> A class is a blueprint or template that defines the properties and behavior of an object. An Object is an instances of a class, created using the class definition.
####  Create a Class
To create a class, use the keyword class:
```
public class Main {
  int x = 5;
}
```
#### Create an Object
To create an object of Main, specify the class name, followed by the object name, and use the keyword new:
```
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}
```
#### 2. Encapsulation
> Encapsulation is the concept of hiding the implementation details of an object from the outside world and only exposing the necessary information through public 
  methods.
#### To achieve this, you must:
- declare class variables/attributes as private
+ provide public get and set methods to access and update the value of a private variable

The get method returns the variable value, and the set method sets the value.
Syntax for both is that they start with either get or set, followed by the name of the variable, with the first letter in upper case:
```
public class Person {
  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}
```
However, as the name variable is declared as private, we cannot access it from outside this class:
```
public class Main {
  public static void main(String[] args) {
    Person myObj = new Person();
    myObj.name = "John";  // error
    System.out.println(myObj.name); // error 
  }
}
```
#### 3. Inheritance
> Inheritance is a mechanism that allows a class to inherit properties and methods from another class, called the superclass or parent class.

To inherit from a class, use the extends keyword.
In the example below, the Car class (subclass) inherits the attributes and methods from the Vehicle class (superclass):
```
class Vehicle {
  protected String brand = "Ford";        // Vehicle attribute
  public void honk() {                    // Vehicle method
    System.out.println("Tuut, tuut!");
  }
}

class Car extends Vehicle {
  private String modelName = "Mustang";    // Car attribute
  public static void main(String[] args) {

    // Create a myCar object
    Car myCar = new Car();

    // Call the honk() method (from the Vehicle class) on the myCar object
    myCar.honk();

    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
    System.out.println(myCar.brand + " " + myCar.modelName);
  }
}
```
If you don't want other classes to inherit from a class, use the final keyword:
```
final class Vehicle {
  ...
}

class Car extends Vehicle {
  ...
}
```
#### 4. Polymorphism
> Polymorphism is the ability of an object to take on multiple forms.

Like we specified in the previous chapter; Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.

For example, think of a superclass called Animal that has a method called animalSound(). Subclasses of Animals could be Pigs, Cats, Dogs, Birds - And they also have their own implementation of an animal sound (the pig oinks, and the cat meows, etc.):
```
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}
```
Now we can create Pig and Dog objects and call the animalSound() method on both of them:
```
class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
}

class Dog extends Animal {
  public void animalSound() {
    System.out.println("The dog says: bow wow");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Create a Animal object
    Animal myPig = new Pig();  // Create a Pig object
    Animal myDog = new Dog();  // Create a Dog object
    myAnimal.animalSound();
    myPig.animalSound();
    myDog.animalSound();
  }
}
```

#### 5. Abstraction
> Abstraction is the concept of showing only the necessary information to the outside world while hiding unnecessary details.

Abstraction can be achieved with either abstract classes or interfaces. The abstract keyword is a non-access modifier, used for classes and methods:

- Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).

+ Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).

An abstract class can have both abstract and regular methods:
```
abstract class Animal {
  public abstract void animalSound();
  public void sleep() {
    System.out.println("Zzz");
  }
}
```
From the example above, it is not possible to create an object of the Animal class:
```
Animal myObj = new Animal(); // will generate an error
```
To access the abstract class, it must be inherited from another class. Let's convert the Animal class we used in the Polymorphism chapter to an abstract class:
```
// Abstract class
abstract class Animal {
  // Abstract method (does not have a body)
  public abstract void animalSound();
  // Regular method
  public void sleep() {
    System.out.println("Zzz");
  }
}

// Subclass (inherit from Animal)
class Pig extends Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig(); // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
  }
}
```
