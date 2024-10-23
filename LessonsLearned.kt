/*
1. Hierarchy matters a lot more than I thought... In python, the declaration restrictions are more lenient. !SOURCE ON DECLARATION





   . Top-Level Declarations
Kotlin:

In Kotlin, you can declare functions, variables, enums, and classes at the top level (outside of any class), and they will be accessible throughout the file or module. If something is declared inside a class or function, it’s only accessible within that class or function unless you explicitly make it public.
Why it matters: The top-level declarations allow for clear modularity, and the scope is well-defined. If you declare something inside a class or a function, it's not available outside that block unless explicitly specified.
Python:

Python is more lenient when it comes to top-level declarations. In Python, functions, classes, and variables declared at the top level are accessible anywhere in the file or across modules if imported.
Global vs Local Scope: Python is less restrictive about the structure and allows functions, classes, and variables declared at the top level to be used anywhere in the module. However, things declared inside a function or class are scoped to that particular function or class, just like Kotlin.

Enums and Constants
Kotlin:

Enums in Kotlin are declared similarly to classes and are often used to create a predefined set of constants. You can declare enums at the top level or within a class, but they follow the scope rules as mentioned.
Hierarchical Access: An enum declared inside a class won’t be accessible outside that class unless explicitly allowed (e.g., marked public).
Python:

Python does not have built-in enums by default (prior to Python 3.4), but it introduced the Enum class in Python 3.4. Enums in Python are less structured than Kotlin and are usually defined at the top level and accessible globally.
Python Enum Declaration:
python
Copy code
from enum import Enum

class RSVPStatus(Enum):
    PENDING = 1
    ATTENDING = 2
    NOT_ATTENDING = 3
Python's enums behave more like constants, and there’s not much emphasis on access restrictions or scope as in Kotlin.
3. Class and Function Scope
Kotlin:

In Kotlin, functions and classes declared inside other functions or classes are local to that scope. For example, a function inside another function cannot be accessed from outside.
Nested Classes: Kotlin has inner classes and nested classes, which behave differently in terms of access to outer class variables. Inner classes can access the outer class’s members, while nested classes are static by default and cannot.
Example:
kotlin
Copy code
class Outer {
    class Nested {
        // Cannot access Outer class members
    }

    inner class Inner {
        // Can access Outer class members
    }
}
Python:

Python allows for nested functions and classes, but it's much more flexible. A function inside another function can only be accessed from within the outer function (similar to Kotlin), but there’s not as much distinction between static and non-static nested classes.
Example:
python
Copy code
class Outer:
    class Nested:
        pass  # Acts like a static class

    def inner_function(self):
        class Inner:
            pass  # Acts like an inner class
4. Imports and Access
Kotlin:

Kotlin has clear rules about what can be imported or accessed. If a class, function, or variable is not marked as public, it won’t be accessible outside its scope (e.g., package or module).
Private vs Public: Kotlin emphasizes visibility modifiers (public, private, protected) to control access across files or modules.
Python:

Python is less strict about access control. By convention, leading underscores (e.g., _function) are used to indicate that something is meant to be private, but it’s not enforced. Python’s philosophy tends to follow the idea of "we’re all consenting adults here," meaning that developers are trusted to respect conventions rather than rely on enforced access controls.
Example:
python
Copy code
def _private_function():
    pass  # Indicates it's meant to be private, but can still be accessed if needed
Key Differences Summarized:
Scope Handling:

Kotlin is more strict and explicit about scope and visibility. You have to declare what’s accessible and where (with public, private, etc.).
Python is more flexible and relies more on conventions. By default, everything at the top level is globally accessible unless it’s made private by convention.
Enums:

Kotlin has strongly typed enums that are more structured and have defined scope based on where they’re declared.
Python’s Enum is more flexible and usually treated as a list of constants.
Top-Level Declaration:

Kotlin enforces visibility rules for top-level declarations and makes sure that access is controlled.
Python is open to almost everything declared at the top level being globally accessible, with minimal restrictions.
Class and Nested Class Scope:

Kotlin enforces inner vs nested class distinctions, with strict rules on access to outer members.
Python doesn’t distinguish between inner and nested classes as clearly, and nested classes are more freely accessible.
Conclusion:
Kotlin has a more structured, rule-based approach to hierarchy and scope, while Python is more flexible and convention-driven. The strict scope and access control in Kotlin are beneficial for large-scale projects where visibility and encapsulation matter, whereas Python’s flexibility offers simplicity and rapid development for many applications.

If you’re transitioning from Python to Kotlin, you’ll find Kotlin to be more rigid in its structure, but this rigidity brings a lot of clarity and reduces potential errors in large projects.







2. MODULARITY
Planning the overall structure, then deconstructing to the lowest levels before creating any code allows for modularity. Through modularity, I can test individual pieces of code to ensure functionality, and slowly reintegrate to larger structures. Through this, I can ensure cohesion and sound functionality and avoid building upon an unstable foundation. 


3. SPLITTING UP CODE INTO SEPARATE FILES... AKA 'ONE CLASS PER FILE'... AKA MORE MODULARITY
1. Efficiency in Development and Collaboration
Modular Code: By keeping classes separate, developers can work on different parts of the codebase independently without worrying about accidentally affecting other parts. This becomes especially useful when multiple people are working on a project.
Faster Debugging and Updates: If something goes wrong with the RSVP status, for example, you can jump directly into the RSVPStatus.kt file without sorting through other unrelated code. This leads to faster debugging and updates.
2. Compile-Time Efficiency
Incremental Compilation: Android Studio and other modern IDEs use incremental compilation, meaning only the files that have been changed need to be recompiled. If you modify just the RSVPStatus.kt file, the compiler will only recompile that file, speeding up the build process.
If everything were in one large file, any change would require recompiling the entire file, which could slow down development, especially in larger projects.
3. Runtime Efficiency
Memory and Performance: While separating files doesn't directly affect runtime speed significantly on its own, modularity can lead to better memory management and more optimized code during runtime because each class can be loaded and used as needed.
Lazy Loading and Modularity: In larger apps, separating code can allow for lazy loading, where only the parts of the app needed at any given time are loaded into memory. This helps conserve memory usage and can improve the app’s performance.
4. Easier Future Optimization
As the app grows, having a modular structure allows for more efficient refactoring. You can optimize individual components without needing to refactor large portions of the codebase. This makes scaling and optimizing the app much easier.
For example, if you later introduce a database or network call, you can optimize just those portions without impacting the entire app’s code.
5. Separation of Concerns and Single Responsibility Principle
Each class does one thing well. This helps keep the logic focused and the code more efficient.
For example, if you decide to optimize the way RSVP statuses are handled or introduce a caching mechanism for events, you can do this directly in RSVPManager.kt or EventManager.kt without touching the rest of the app.
6. Maintainability and Readability
Well-structured code is easier to extend and maintain over time. You can quickly identify where new features need to be added or optimized.
It also makes reviewing code easier for others (or for your future self!)—leading to a more productive development process.
Summary:
Modular files improve development efficiency and runtime memory management.
Incremental compilation speeds up build times, as only modified files are recompiled.
Separation of concerns leads to better optimization and scalability in the future.
Though splitting files won’t directly speed up runtime in simple apps, it plays a role in making the app more efficient overall, particularly as the app scales.
So, by splitting your classes into individual files, you're setting yourself up for success both in terms of development speed and the app's future performance.

