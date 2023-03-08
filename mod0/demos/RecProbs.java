import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class RecProbs {
  public static void main(String[] args) {

    System.out.println("1. Print repeatedly");
    nPrintMsg("Programming is fun!", 2);

    System.out.println("2. Determine palindrome");
    System.out.println("good is a palindrome? " + isPalindrome("good"));
    System.out.println("goog is a palindrome? " + isPalindrome("goog"));
    System.out.println("good is a palindrome? " + isPalindrome2("good"));
    System.out.println("goog is a palindrome? " + isPalindrome2("goog"));

    System.out.println("3. Find gcd with Euclid algorithm");
    System.out.printf("gcd(%d,%d) = %d\n", 0, 9, Euclid(0, 9));
    System.out.printf("gcd(%d,%d) = %d\n", 9, 0, Euclid(9, 0));
    System.out.printf("gcd(%d,%d) = %d\n", 9, 243, Euclid(9, 243));

    System.out.println("4. Find gcd recursively");
    System.out.printf("gcd(%d,%d) = %d\n", 0, 9, gcd(0, 9));
    System.out.printf("gcd(%d,%d) = %d\n", 9, 0, gcd(9, 0));
    System.out.printf("gcd(%d,%d) = %d\n", 9, 243, gcd(9, 243));

    System.out.println("5. Factorial");
    System.out.println("150! = " + factorial(150));

    System.out.println("6. Tower of Hanoi");
    Hanoi(4, 'A', 'B', 'C');

    System.out.println("7. Find the size of a directory");
    String dir = "C:\\Users\\%USER%";
    long ds = directorySize(new File(dir));
    System.out.printf("The size of directory '%s': %d bytes\n", dir, ds);

    System.out.println("8. Binary search");
    int[] list = {1, 3, 5, 10, 16, 20, 37, 99};
    int loc = -1;
    loc = bsearch(list, 11);
    System.out.printf("%d is found at %d\n", 11, loc);
    loc = bsearch(list, 99);
    System.out.printf("%d is found at %d\n", 99, loc);

    System.out.println("9. Selection sort");
    Integer[] Iarray = {1, 3, 5, 10, 16, 20, 37, 99};
    List<Integer> ilist = Arrays.asList(Iarray);
    Collections.shuffle(ilist);
    ilist.toArray(Iarray);
    System.out.println("Before sort: " + Arrays.toString(Iarray));
    int[] iarray = Arrays.stream(Iarray).mapToInt(Integer::intValue).toArray();
    sort(iarray);
    System.out.println("After sort: " + Arrays.toString(iarray));

  }

  public static void nPrintMsg(String msg, int times) {
    if (times == 0) {
      return;
    } else {
      System.out.println(msg);
      nPrintMsg(msg, times - 1);
    }
  }

  public static boolean isPalindrome(String s) {
    if (s.length() <= 1) {
      return true;
    } else if (s.charAt(0) != s.charAt(s.length() - 1)) {
      return false;
    } else {
      return isPalindrome(s.substring(1, s.length() - 1));
    }
  }

  public static boolean isPalindrome2(String s) {
    return isPalindrome(s, 0, s.length() - 1);
  }

  public static boolean isPalindrome(String s, int low, int high) {
    if (high <= low) {
      return true;
    } else if (s.charAt(low) != s.charAt(high)) {
      return false;
    } else {
      return isPalindrome(s, low + 1, high - 1);
    }
  }

  public static long Euclid(long m, long n) {
    if (n == 0) {
      return m;
    }

    long am = Math.abs(m);
    long an = Math.abs(n);

    long r = am % an;
    while (r != 0) {
      am = an;
      an = r;
      r = am % an;
    }
    return an;
  }

  public static long gcd(long m, long n) {
    if (n == 0)
      return m;
    else if (m % n == 0) {
      return n;
    } else {
      return gcd(n, m % n);
    }
  }

  public static BigInteger factorial(long n) {
    return factorial(n, BigInteger.valueOf(1));
  }

  public static BigInteger factorial(long n, BigInteger result) {
    // result is the productive accumulator
    if (n == 0) {
      return result;
    } else {
      return factorial(n - 1, BigInteger.valueOf(n).multiply(result));
    }
  }

  public static void Hanoi(int n, char from, char via, char to) {
    if (n == 1) {
      System.out.printf("Move disk %d from %c to %c\n", n, from, to);
    } else {
      Hanoi(n - 1, from, to, via);
      System.out.printf("Move disk %d from %c to %c\n", n, from, to);
      Hanoi(n - 1, via, from, to);
    }
  }

  public static long directorySize(File p) {
    long size = 0;

    if (p.isDirectory()) {
      File[] fs = p.listFiles();
      for (File file : fs) {
        if (file != null)
          size += directorySize(file);
      }
    } else {
      size += p.length();
    }

    return size;
  }

  public static int bsearch(int[] list, int key) {
    int low = 0;
    int high = list.length - 1;
    return bsearch(list, key, low, high);
  }

  public static int bsearch(int[] list, int key, int low, int high) {
    if (low > high) { // exhausted without a match
      return -low - 1;
    }

    int mid = (low + high) / 2;
    if (list[mid] == key) {
      return mid;
    } else if (key < list[mid]) {
      return bsearch(list, key, low, mid - 1);
    } else {
      return bsearch(list, key, mid + 1, high);
    }
  }

  public static void sort(int[] list) {
    sort(list, 0, list.length - 1); 
  }
  private static void sort(int[] list, int low, int high) {
    if (low < high) {
      int indexOfMin = low;
      int min = list[low];
      for (int i = low + 1; i <= high; i++) {
        if (list[i] < min) {
          min = list[i];
          indexOfMin = i;
        }
      }

      list[indexOfMin] = list[low];
      list[low] = min;

      sort(list, low + 1, high);
    }
  }  
}