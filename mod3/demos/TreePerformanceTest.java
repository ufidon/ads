public class TreePerformanceTest {
  public static void main(String[] args) {
    final int TEST_SIZE = 500000;

    Tree<Integer> tree1 = new AVLTree<Integer>();
    System.out.println("AVL tree time: " +
      getTime(tree1, TEST_SIZE) + " milliseconds");

    Tree<Integer> tree2 = new Tree24<Integer>();
    System.out.println("2-4 tree time: "
      + getTime(tree2, TEST_SIZE) + " milliseconds");

    Tree<Integer> tree3 = new RBTree<Integer>();
    System.out.println("RB tree time: "
      + getTime(tree3, TEST_SIZE) + " milliseconds");
  }

  public static long getTime(Tree<Integer> tree, int testSize) {
    long startTime = System.currentTimeMillis();

    java.util.List<Integer> list = new java.util.ArrayList<Integer>();
    for (int i = 0; i < testSize; i++)
      list.add(i);

    java.util.Collections.shuffle(list);

    for (int i = 0; i < testSize; i++)
      tree.insert(list.get(i));

    java.util.Collections.shuffle(list);

    for (int i = 0; i < testSize; i++)
      tree.delete(list.get(i));

    return System.currentTimeMillis() - startTime;
  }
}
