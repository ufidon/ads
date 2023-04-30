import java.util.Scanner;

public class WeightedNineTail {
  public static void main(String[] args) {
    System.out.print("Enter an initial nine coins' Hs and Ts: ");
    Scanner input = new Scanner(System.in);
    String s = input.nextLine();
    s = s.toUpperCase();
    char[] initialNode = s.toCharArray();

    WeightedNineTailModel model = new WeightedNineTailModel();
    java.util.List<Integer> path =
      model.getShortestPath(NineTailModel.getIndex(initialNode));

    System.out.println("The steps to flip the coins are ");
    for (int i = 0; i < path.size(); i++)
      NineTailModel.printNode(NineTailModel.getNode(path.get(i)));    

    System.out.println("The number of flips is " + 
      model.getNumberOfFlips(NineTailModel.getIndex(initialNode)));    
  }
}
