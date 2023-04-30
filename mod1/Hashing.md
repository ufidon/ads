# Hashing
Chapter 21

Objectives
---
- Explain hashing usage, load factor and need for rehashing
- Design hash function to map a key to an index
  - obtain the hash code for an object 
- Handle collisions using 
  - open addressing 
    - linear probing, quadratic probing, and double hashing
  - separate chaining 


Why hashing?
---
- An element can be found in $O(\log n)$ time in a well-balanced search tree
- This can be improved to search, insert, and delete an element in  $O(1)$ time
  - use hashing to implement a map or a set


Map
---
- Each element (entry) contains two parts: 
  - key,  also called a search key
  - value
- Also called a dictionary, a hash table, or an associative array


What is Hashing? 
---
- In an array, an element can be retrieved using its index in O(1) time
- Hashing is 
  - store map entries in an array named hash table
    - each entry saved in a cell
    - a cell has three possible states: occupied, marked (for deletion), or empty
  - use its key to find a value
    - map a key to an index using a hash function
  - no search is needed


Hash Function and Hash Codes
---
- $i=h(k)$
  - $i$, index, an integer, also called hash code
  - $k$, key
  - $h$, hash function
- A perfect hash function maps different search key to different index
- Two or more keys are mapped to the same hash value is called a collision
- Hash functions are designed to be fast and easy-to-compute


Popular Java hash codes
---
- discuss which of them 
  - have no collision
  - have collision

| key type | hash code |
| --- | --- |
| Object | returned from its hashCode() method. <br/> the default hash code is the memory address for the object. |
| byte, short, int, char | their int cast: (int)key |
| float | Float.floatToIntBits(key), the bit representation of key |
| long | folding: (int)(key ^ (key >> 32)) |
| double | double folding: long bits = Double.doubleToLongBits(key), (int)(bits ^ (bits >> 32));  |
| String s | polynomial hash code: $\sum_{i=0}^{n-1} s[i]b^{n-1-i}$ , where n=s.length(), $b$ is a positive with good choices such as 31,33,37, 39 and 41 by experiments. $b=31$ is used in the hashCode of String. |


Compressing hash codes
---
- A hash table of length L has only indexes from 0 to L-1
- hash code compressing: hashCode % L
  - L is usually chosen to be a prime number
  - in HashMap, L is an integer power of 2 with compression
    - supplementalHash(hashCode) & (L-1)
    - the supplementalHash is defined as below

```java
private static int supplementalHash(int h){
  h ^= (h >>> 20) ^ (h >>> 12);
  return h ^ (h >>> 7) ^ (h >>> 4);
}
```


Handling Collisions Using Open Addressing
---
- finds an open location in the hash table
- open addressing: 
  - linear probing
  - quadratic probing
  - double hashing
  - separate chaining


linear probing
---
- finds the next available location sequentially
  - $hashTable[(h(key)+i)\%N]$, increment $i$ from zero until an available cell is found
- may cause groups of consecutive cells to be occupied
  - such a group is called a cluster
-  guarantees an available cell can be found for insertion in non-full table


quadratic probing
---
- finds the next available location by $hashTable[(h(key)+i^2)\%N]$
  - increment $i$ from zero until an available cell is found
- can avoid the clustering problem from linear probing
- may cause secondary clustering problem
  - the entries that collide with an occupied cell use the same probe sequence
- available cell is not guaranteed in non-full table


double hashing
---
- finds the next available location by $hashTable[(h(key)+i*h'(key))\%N]$
  - increment  $i$ from zero until an available cell is found
  - $h'(key)$ is the second hash function
    -  should never have a zero value
- probing functions should be designed to produce a probe sequence that reaches the entire table


Handling Collisions Using separate chaining
---
- chains the entries with the same hash index in a bucket
  - a bucket can be implemented as an array, ArrayList, or LinkedList
- each cell in the hash table can be viewed as the reference to its bucket


Load Factor and Rehashing
---
- Load factor is the ratio of the number of occupied cells to the total number of cells
  - a threshold is maintained in a hash table, typically
    - 0.5 for open addressing
    - 0.9 for separate chaining
    - java.util.HashMap uses 0.75
  - if the threshold is exceeded, rehashing is needed
    - increase the hash table size, typically double it
    - reload and rehash the entries into the new table
      - a new hash function is needed since the table size is changed


Practice ✏️
---
- Discuss the hash functions, hashing and rehashing schemes in the source code
- Implementing Map Using Hashing
  - [TestMyHashMap.java](./demos/TestMyHashMap.java)
  - [MyHashMap.java](./demos/MyHashMap.java)
  - [MyMap.java](./demos/MyMap.java)
- Implementing Set Using Hashing
  - [TestMyHashSet.java](./demos/TestMyHashSet.java)
  - [MyHashSet.java](./demos/MyHashSet.java)
  - [MySet.java](./demos/MySet.java)


## Online resources
- [visualgo - visualize algorithms](https://visualgo.net/)
- [Liang animation](https://liveexample.pearsoncmg.com/liang/animation/animation.html)