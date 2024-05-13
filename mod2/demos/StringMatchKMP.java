public class StringMatchKMP {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter a string text: ");
    String text = input.nextLine();
    System.out.print("Enter a string pattern: ");
    String pattern = input.nextLine();
    
    int index = match(text, pattern);
    if (index >= 0)
      System.out.println("matched at index " + index);
    else
      System.out.println("unmatched");   
  }

  public static int match(String text, String pattern) {
    int[] fail = getFailure(pattern);
    int i = 0;
    int k = 0;
    while (i < text.length()) {
      if (text.charAt(i) == pattern.charAt(k)) {
        if (k == pattern.length() - 1) {
          return i - pattern.length() + 1;
        }
        i++;
        k++;
      }
      else {
        if (k > 0) {
          k = fail[k - 1];
        }
        else {
          i++;
        }
      }
    }

    return -1;
  }
	
  private static int[] getFailure(String pattern) {
    int[] fail = new int[pattern.length()];
    int i = 1;
    int k = 0;
    while (i < pattern.length()) {
      if (pattern.charAt(i) == pattern.charAt(k)) {
        fail[i] = k + 1;
        i++;
        k++;
      }
      else if (k > 0) {
        k = fail[k - 1];
      }
      else {
        i++;
      }
    }
    
    return fail;
  }
}
