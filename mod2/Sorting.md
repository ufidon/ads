# Sorting
chapter 23


Objectives
---
- Design, implement, and analyze popular sorting algorithms
  - insertion sort
  - bubble sort
  - merge sort
  - quick sort
  - heap sort
    - binary heap
  - bucket sort
    - radix sort
  - external sort of large files


Sorting
---
- rearrange data in ascending or descending order
- the data to be sorted might be primitive types, or objects
- the java.util.Arrays and java.util.Collections class provide several overloaded sort methods
- for simplicity, assume sort data in an ArrayList or a LinkedList *ascendingly*


Insertion sort
---
- insert an unsorted element into a sorted sublist until the whole list is sorted
  ```java
  public static void insertionSort(int[] list) {
    for (int i = 1; i < list.length; i++) {
      int currentElement = list[i];
      int k;
      for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
        list[k + 1] = list[k];
      }

      list[k + 1] = currentElement;
    }
  }
  ```
- time complexity: $(n-1)+(n-2)+\cdots+1=\frac{(n-1)n}{2}=O(n^2)$


Bubble sort
---
-  sorts the array in multiple passes
-  each pass successively swaps unordered neighboring elements
  ```java
  public static void bubbleSort(int[] list) {
    boolean needNextPass = true;
    
    for (int k = 1; k < list.length && needNextPass; k++) {
      needNextPass = false;
      for (int i = 0; i < list.length - k; i++) {
        if (list[i] > list[i + 1]) {
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
          
          needNextPass = true;
        }
      }
    }
  }
  ```
- time complexity: $(n-1)+(n-2)+\cdots+1=\frac{(n-1)n}{2}=O(n^2)$  


Merge sort
---
- divide and conquer
- divides the array into two halves 
  - applies a merge sort on each half recursively
- merge the two sorted halves

```java
public static void mergeSort(int[] list) {
  if (list.length > 1) {
    int[] firstHalf = new int[list.length / 2];
    System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
    mergeSort(firstHalf);

    int secondHalfLength = list.length - list.length / 2;
    int[] secondHalf = new int[secondHalfLength];
    System.arraycopy(list, list.length / 2,
      secondHalf, 0, secondHalfLength);
    mergeSort(secondHalf);

    merge(firstHalf, secondHalf, list);
  }
}

public static void merge(int[] list1, int[] list2, int[] temp) {
  int current1 = 0;
  int current2 = 0;
  int current3 = 0;

  while (current1 < list1.length && current2 < list2.length) {
    if (list1[current1] < list2[current2])
      temp[current3++] = list1[current1++];
    else
      temp[current3++] = list2[current2++];
  }

  while (current1 < list1.length)
    temp[current3++] = list1[current1++];

  while (current2 < list2.length)
    temp[current3++] = list2[current2++];
}
```
- time complexity: $T(n) = T(\frac{n}{2})+T(\frac{n}{2})+2n-1=O(n\log n)$


Quicksort
---
-  1. select a pivot in the array
-  2. It divides the array into two parts 
   -  all elements in the left <= pivot
   -  all elements in the right > pivot
-  3. quick sort the two halves recursively

```java
public static void quickSort(int[] list) {
  quickSort(list, 0, list.length - 1);
}

private static void quickSort(int[] list, int first, int last) {
  if (last > first) {
    int pivotIndex = partition(list, first, last);
    quickSort(list, first, pivotIndex - 1);
    quickSort(list, pivotIndex + 1, last);
  }
}

private static int partition(int[] list, int first, int last) {
  int pivot = list[first];
  int low = first + 1;
  int high = last;

  while (high > low) {
    while (low <= high && list[low] <= pivot)
      low++;

    while (low <= high && list[high] > pivot)
      high--;

    if (high > low) {
      int temp = list[high];
      list[high] = list[low];
      list[low] = temp;
    }
  }

  while (high > first && list[high] >= pivot)
    high--;

  if (pivot > list[high]) {
    list[first] = list[high];
    list[high] = pivot;
    return high;
  }
  else {
    return first;
  }
}
```
- time complexity: 
  - worst-case: $O(n^2)$
  - best-case:  $T(n) = T(\frac{n}{2})+T(\frac{n}{2})+n=O(n\log n)$
  - average case: $O(n\log n)$


Heap sort
---
- sort using a binary heap
- binary heap properties
  -  Shape property: It is a complete binary tree
     -  each non-last level is full
     -  the last level may not be full and all its leaves are placed leftmost
  -  Heap property: Each node is greater than or equal to any of its children
- a binary heap can be stored in 
  - an ArrayList or 
  - an array if the heap size is known in advance
    - The root is at position 0, 
      - its two children are at positions 1 and 2 
    - For a node at position i, 
      - its left child is at position 2i + 1
      - its right child is at position 2i + 2 
      - its parent is (i - 1)/2

the heap class
---
- The add(E newObject) method - *bubbling up*
  - appends the object to the tree 
  - swaps the object with its parent if the object is greater than its parent - This process continues until 
    - the new object becomes the root or 
    - is not greater than its parent
- The remove() method - *sinking down*
  - removes and returns the root, To maintain the heap property, 
    - moves the last object to the root position 
    - swaps it with its larger child if it is less than the larger child 
    - This process continues until the last object becomes a leaf or is not less than its children

```java
public class Heap<E> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();
  private java.util.Comparator<? super E> c;
  
  public Heap() {
    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
  }

  public Heap(java.util.Comparator<E> c) {
    this.c = c;
  }
  
  public Heap(E[] objects) {
    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  public void add(E newObject) {
    list.add(newObject);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      if (c.compare(list.get(currentIndex),
          list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      }
      else
        break;

      currentIndex = parentIndex;
    }
  }

  public E remove() {
    if (list.size() == 0) return null;

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      if (leftChildIndex >= list.size()) break;
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (c.compare(list.get(maxIndex),
            list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      if (c.compare(list.get(currentIndex), 
          list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      }
      else
        break;
    }

    return removedObject;
  }

  public int getSize() {
    return list.size();
  }
  
  public boolean isEmpty() {
    return list.size() == 0;
  }
}
```


heap sort
---
- create a heap and add all the elements from the list
- remove all the elements from the heap and put back to the list

```java
import java.util.Comparator;

public class HeapSort {
  public static <E> void heapSort(E[] list) {
    heapSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
  }
  
  public static <E> void heapSort(E[] list, Comparator<E> c) {
    Heap<E> heap = new Heap<>(c);

    for (int i = 0; i < list.length; i++)
      heap.add(list[i]);

    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();
  }

  public static void main(String[] args) {
    Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
    heapSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}
```  
- time complexity: $O(n\log n)$


Bucket Sort
---
- general sorting algorithms work for any types of keys
  - sort the elements by comparing their keys
  - can not be better than $O(n\log n)$
- bucket sort works for keys of small integers without comparing the keys
  - also called index sort
  - Given key domain [0, N-1], we need N buckets labeled 0, 1, ..., and N-1 
  - an element’s with key i is put into bucket i 
  - each bucket holds the elements with the same key value
- bucket sort is stable, i.e
  -  the order of two unsorted elements with the same key value is not changed in the sorted list

```java
public static int N = 200;
public static <E> void bucketSort(E[] list) {
  E[] bucket = (E[]) new java.util.ArrayList[N + 1];
  for (int i = 0; i < list.length; i++) {
    int key = list[i].getKey();
    if (bucket[key] == null)
      bucket[key] = new java.util.ArrayList<>();

    bucket[key].add(list[i]);
  }

  int k = 0;
  for (int i = 0; i < bucket.length; i++) {
    if (bucket[i] != null) {
      for (int j = 0; j < bucket[i].size(); j++)
        list[k++] = bucket[i].get(j);
    }
  }
}
```
- time complexity: $O(list.length+N)$


Radix Sort 
---
- order positive integers by their digits from right to left
  - only radix-number of buckets are needed, for decimal numbers, it is 10
- time complexity: $O(dn)$
  - $d$ - the maximum number of digits of the integers in the list
  - $n$ - number of elements in the list


External sort
---
- sort data in a large external file with $n$ elements using a variation of merge sort
  - suppose internal sort can handle $N$ elements each time
  - read a part of size $N$, sort it, and save the sorted part until done
    - denoted the sorted parts as $S_1, S_2, \cdots, S_n$
  - merge the sorted parts pairwise into $S_{(1,2)}, S_{(3,4)}, \cdots, S_{(n-1,n)}$
    - keep merging until done
- time complexity: $O(n\log n)$


Practice 📝 on external sort
---
- create a large data file
  - using [CreateLargeFile.java](./demos/CreateLargeFile.java)
  ```bash
  javac CreateLargeFile.java
  java CreateLargeFile
  ```
- sort the large data file iteratively
  - using [SortLargeFile.java](./demos/SortLargeFile.java)
  ```bash
  javac SortLargeFile.java
  java SortLargeFile 
  ```

# References
- [Sorting algorithm](https://en.wikipedia.org/wiki/Sorting_algorithm)
  - [Comparison of Sorting Algorithms](https://coderslegacy.com/comparison-of-sorting-algorithms/)
- [visualgo](https://visualgo.net/)
- [Liang animation](https://liveexample.pearsoncmg.com/liang/animation/animation.html)

