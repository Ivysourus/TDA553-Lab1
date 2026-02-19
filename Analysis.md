# Dependencies

1. There are a lot of highly needed dependencies, especially those that we have with the hierarchy of our different car classes, since they all have a lot of common factors such as position, speed and more.
   Then there is the dependencies we need through composition, specifically the LoadHelper Classes that help to simplify the loading/unloading process with the objects that posses such attributes.
2. There are only a few dependencies that are technically unnecessary, that being the double back and forth dependency that both CarView and CarController have with one another, although it's almost impossible to get rid of without combining the two files in one way or another.
3. ...
4. ...

# Class Functions and Responsibility

1. Our classes have their very own responsibility sectors if you would call it, as they only focus on the core function they need to fulfil. Apart from the CarView, CarController and DrawPanel classes, not a lot of dividing is possible here.
2. They would change to limit the amount of functions needed per class and make it more clear what each class is meant for without having to dig through multiple statements and methods that generally don't relate to one another.
3. It can be implemented in the CarView, DrawPanel and CarController classes, and we have already implemented in a way with our composition helper classes. They are split up into one parent class and 3 subclasses that define the 3 different way to load/unload something from an object instead of us having one class with all 3 different functions inside of it.

# Refactorization Plan

Lorem Ipsum..