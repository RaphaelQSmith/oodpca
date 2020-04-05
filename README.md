# oodpca

This repository is part of an Object-Oriented Design Patterns Assignment.

This CLI based program was created using JAVA and making use of the following Design Patterns:
    - DAO(Data Access Object) Pattern;
    - Builder Pattern;
    - Singleton.
With these three design patterns, a modular and encapsulated solution was possible and this way the requirements were met.

The DAO Pattern:
  Is not part of the initial 23 ones described on the 1994 'Gang of Four' book, but is broadly used in the industry,
since it provides a very useful, encapsulated and modular solution when dealing with Database connection. A developer team could change
how the connection is performed (or even the whole database) without having to change anything on the other classes.

The Builder Pattern:
  Is a way to get rid of classes that need too many arguments on the constructor to be instanciated. 
  Using the Builder pattern I used an inner class to generate a Country builder with only the necessary arguments and then passed this to the Country class 
using a build method. this allowed me to create a Country object even with a private constructor.

Singleton:
  Is used when we want a class or object to be created only on Compiling time. 
  The Database connection was design here to be created when we run the program, that way it was the perfect example of a class that 
  could benefit from this design pattern.
  

  
  
  
