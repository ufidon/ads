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
  for(int i=1; i<list.length; i++){
    int currentElement = list[i];
    int k;
    for(k=i-1; k>=0 && list[k] > currentElement; k--){
      list[k+1] = list[k];
    }
    list[k+1] = currentElement;
  }
  ```
- time complexity: $(n-1)+(n-2)+\cdots+1=\frac{(n-1)n}{2}=O(n^2)$


Bubble sort
---
-  sorts the array in multiple passes
-  each pass successively swaps unordered neighboring elements
  ```java
  boolean needNextPass = true;
  for(int k=1; k<list.length && needNextPass; k++){
    needNextPass = false;
    for(int i=0; i<list.length-k; i++){
      if(list[i] > list[i+1]){
        swap(list[i], list[i+1]);
        needNextPass = true;
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
void mergeSort(int[] list){
  int[] leftHalf = new int[list.length/2];
  System.arraycopy(list,0, leftHalf, 0, list.length/2);
  mergeSort(leftHalf);

  int rightHalfLength = list.length-list.length/2;
  int[] rightHalf = new int[rightHalfLength];
  System.arraycopy(list, list.length/2, rightHalf, 0, rightHalfLength);
  mergeSort(rightHalf);

  merge(leftHalf, rightHalf, list);
}

void merge(int[] left, int[] right, int[] merged){
  int il = 0, ir=0, im=0;
  while(il<left.length && ir <right.length){
    if(left[il]<right[ir])
      merged[im++] = left[il++];
    else
      merged[im++] = right[ir++];
  }

  while(il < left.length)
    merged[im++] = left[il++];
  while(ir < right.length)
    merged[im++] = right[ir++];
}
```
- time complexity: $T(n) = T(\frac{n}{2})$

