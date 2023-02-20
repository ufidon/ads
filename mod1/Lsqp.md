# Lists, Stacks, Queues, and Priority Queues
Chapter 20


Objectives
---
- Explore Java Collections Framework 
  - interfaces 
    - Iterator 
      - traverses the elements in a collection
    - Comparable and Comparator
      - compare elements
  - classes
    - Collection, Queue, LinkedList, and PriorityQueue
  - common methods
    - forEach 
      - performs an action on each element in a collection
    - foreach loop
      - traverses the elements in a collection
    - static utility methods
      - sorting, searching, shuffling lists, and finding the largest and smallest element in collections
- Applications
  - use ArrayList or LinkedList to store a list of elements
    - develop a multiple bouncing balls application using ArrayList
  - distinguish between Vector and ArrayList and to use the Stack class for creating stacks
    - use stacks to write a program to evaluate expressions


What is Data Structure?
---
- data organization
  - stores data 
  - supports operations for accessing and manipulating the data


Java Collection Framework hierarchy
---
- A collection is a container object that holds a group of objects, or elements

- two types of collections
  - collection,  stores a group of elements
    - Set and List are subinterfaces of Collection
  - map, stores key/value pairs

![Java Collection Framework hierarchy](./images/jcf.png)


Collection Interface and class
---
- [Interface Collection\<E\>](https://devdocs.io/openjdk~11/java.base/java/util/collection)
- [Class Collections](https://devdocs.io/openjdk~11/java.base/java/util/collections)

```java
import java.util.*;

public class TestCollection {
  public static void main(String[] args) {
    ArrayList<String> collection1 = new ArrayList<>();
    collection1.add("New York"); 
    collection1.add("Atlanta"); 
    collection1.add("Dallas"); 
    collection1.add("Madison"); 

    System.out.println("A list of cities in collection1:");
    System.out.println(collection1);

    System.out.println("\nIs Dallas in collection1? "
      + collection1.contains("Dallas"));

    collection1.remove("Dallas");
    System.out.println("\n" + collection1.size() + 
       " cities are in collection1 now");

    Collection<String> collection2 = new ArrayList<>();
    collection2.add("Seattle"); 
    collection2.add("Portland"); 
    collection2.add("Los Angles"); 
    collection2.add("Atlanta"); 

    System.out.println("\nA list of cities in collection2:");
    System.out.println(collection2);

    ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());
    c1.addAll(collection2);
    System.out.println("\nCities in collection1 or collection2: ");
    System.out.println(c1);

    c1 = (ArrayList<String>)(collection1.clone());
    c1.retainAll(collection2);
    System.out.print("\nCities in collection1 and collection2: ");
    System.out.println(c1);

    c1 = (ArrayList<String>)(collection1.clone());
    c1.removeAll(collection2);
    System.out.print("\nCities in collection1, but not in 2: ");
    System.out.println(c1);
  }
}
```