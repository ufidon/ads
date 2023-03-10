import java.util.*;

public class SortString {
  public static void main(String[] args) {
    String[] cities = { "Atlanta", "Savannah", "New York", "Dallas" };

    // **P2**: Sort strings by length
    // Method 1: inner class
    java.util.Arrays.sort(cities, new SortByLength());
    // or
    // java.util.Arrays.sort(cities, (s1, s2) -> {return s1.length() - s2.length();});
    // or
    // java.util.Arrays.sort(cities, (s1, s2) -> s1.length() - s2.length());

    // Method 2: anonymous inner class
    java.util.Arrays.sort(cities, Comparator.comparing(
        new java.util.function.Function<String, Integer>() {
          public Integer apply(String s) {
            return s.length();
          }
        }));

    // Method 3: lambda expression
    // java.util.Arrays.sort(cities, Comparator.comparing(s -> s.length()));

    print(cities);

    // **P3**: Sort strings ignoring cases
    var cityList = Arrays.asList(cities);
    // Method 1: lambda expression
    // cityList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

    // Method 2: method reference
    cityList.sort(String::compareToIgnoreCase);

    print(cityList.toArray());

  }

  public static class SortByLength implements
      java.util.Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return s1.length() - s2.length();
    }
  }

  public static <E> void print(E[] arr) {
    for (E s : arr) {
      System.out.print(s + " ");
    }
    System.out.println();
  }
}