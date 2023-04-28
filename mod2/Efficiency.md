# Algorithm efficiency analysis
chapter 22


Objectives
---
- Estimate algorithm efficiency using the Big O notation
  -  explain growth rates and 
     -  why constants and nondominating terms can be ignored
  - describe common growth functions 
    - constant, logarithmic, log-linear, quadratic, cubic, and exponential
- Analyze and determine the complexity of various types of algorithms
  -  binary search
  -  selection sort
  -  Tower of Hanoi
- Design efficient algorithms for 
  - finding 
    - Fibonacci numbers using dynamic programming
    - the GCD using Euclid’s algorithm
    - prime numbers using the sieve of Eratosthene
    - the closest pair of point using the divide-and-conquer approach
    - a convex hull for a set of points
  - solving
    -  the Eight Queens problem using the backtracking approach
    -  string matching using Boyer-Moor and KMP algorithms


Executing Time 
---
- can be used to measure the performance of algorithms
  - by profilers
- two problems
  - depends on execution environment
  - depends on specific input


Growth Rate
---
- a theoretical measure of algorithm performance
- find how fast the time consumed by a algorithm increases when the size of input increases
  - $t=f(input\_size)$, find the function $f$
  - its *order of magnitude* is denoted by Big $O$


Example 💡: find the growth rate of linear search
---
- The execution time of Linear search is proportional to the size of the array
  - so it has an order of $n$
  - denoted as $O(n)$
- analysis
  - ignore multiplicative constants
  - ignore non-dominating terms


Practice 📝 : determine Big-O
---
- Repetition
- Sequence 
- Selection
- Logarithm


Repetition: simple loops
---
```java
for(i=1; i<=n; i++){
  s += i;
}
```
- Time complexity: $T(n) = cn = O(n)$


Repetition: nested loops
---
- matrix multiplication: $C=A\times B$
  ```java
  for(i=1; i<=n; i++){
    for(j=1; j<=n; j++){
      for(k=1; k<=n; k++){
        c[i][j] += a[i][k]*b[k][j];
      }
    }
  }
  ```
- Time complexity: $T(n) = cn^3 = O(n^3)$

- partial sum: $S[i] = \sum_{k=1}^i k$
  ```java
  for(i=1; i<=n; i++){
    for(k=1; k<=i; k++){
      S[i] += k;
    }
  }
  ```
- Time complexity: $T(n) = c\frac{n(n+1)}{2} = O(n^2)$  

Best, Worst, and Average Cases 
---
- an analysis of inputs
- best-case: results in the shortest execution time
- worst-case: results in the longest execution time 
  - determines the lower bound of performance
  - easier to obtain and commonly used
- average-case: 
  - attempts to determine the average amount of time among all possible input of the same size
  - ideal, but difficult to perform
    - hard to determine the relative probabilities and distributions of various input instances for many problems



# Math appendix
- $\sum_{k=1}^n k = \frac{n(n+1)}{2}$
- $\sum_{k=0}^n a^k = \frac{a^{n+1}-1}{a-1}$
  - $\sum_{k=0}^n 2^k = \frac{2^{n+1}-1}{2-1}=2^{n+1}-1$

# References
- [VisualVM - All-in-One Java Troubleshooting Tool](https://visualvm.github.io/)
- [NetBeans Profiler](https://www.netbeans.info/products/profiler/index.html)
- [Open Source Profilers in Java](https://java-source.net/open-source/profilers)