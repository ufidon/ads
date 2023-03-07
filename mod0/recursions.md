# Recursions
Chapter 18


Motivations
---
- Find the total size of all files in a directory
  - Find all files satisfy a criteria in a folder
  - process the directory *recursively*
- Generate [fractal figures](https://en.wikipedia.org/wiki/Fractal)
  - generate *recursively*

| name |  figure (from Wikipedia) |
| ---- |  ------ |
| fractal canopy | ![fractal canopy](https://upload.wikimedia.org/wikipedia/commons/a/af/Simple_Fractals.png) |
| Mandelbrot set | ![Mandelbrot set](https://upload.wikimedia.org/wikipedia/commons/b/b3/Mandel_zoom_07_satellite.jpg) |


Objectives
---
- Explain recursive methods and their benefits
  - divide-and-conquer
  - implemented in a call stack
  - derive a recursive method using helper methods
- Solve problems using recursion
  - recursive mathematical functions
  - selection sort
  - binary search
  - directory size
  - Tower of Hanoi
  - draw fractals
- Convert between recursion and iteration
  - tail-recursion


Recursive mathematical functions
---

| function | recursion | base cases |
| --- | --- | --- |
| factorial | $n! = n\times (n-1)!, n>0$ | $0!=1$ |
| sum | $f(n)=n+f(n-1), n\ge 1$  | $f(0)=0$ |
| Fibonacci numbers| $f(n) = f(n-1) + f(n-2), n\ge2$ | $f(1)=1, f(0)=0$ |



Solve recursive problems
---
- divide-and-conquer
  - break the problem into similar subproblems with smaller size
- Characteristics of Recursion
  - implemented using a conditional statement that leads to different cases
  - One or more base cases (the simplest cases) are used to stop
  - Every recursive call reduces the original problem increasingly closer to until becomes base cases

```java
import java.util.Scanner;

public class RecFuns {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();

    long fac = factorial(n);
    long sum = sum0ton(n);
    long fib = fibonacci(n);

    System.out.printf("factorial(%d)=%d\nsum1ton(%d)=%d\nfibonacci(%d)=%d\n",
        n, fac, n, sum, n, fib);
  }

  public static long factorial(int n) {
    if (n == 0)
      return 1;
    else
      return n * factorial(n - 1);
  }

  public static long sum0ton(int n) {
    if (n == 0) {
      return 0;
    } else {
      return n + sum0ton(n - 1);
    }
  }

  public static long fibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
}
```

Practice 📝
---
- run the code above
  - show call stacks of the three recursive functions
- show call stacks on paper



# References
- [Visual Studio Code show call hierarchy](https://stackoverflow.com/questions/49197137/visual-studio-code-show-call-hierarchy)