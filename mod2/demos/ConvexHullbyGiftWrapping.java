import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;

public class ConvexHullbyGiftWrapping {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("How many points are in the set? ");
    int numberOfPoints = input.nextInt();
    
    double[][] p = new double[numberOfPoints][2];    
    System.out.print("Enter " + p.length + " points: ");
    for (int i = 0; i < p.length; i++)
      for (int j = 0; j < p[i].length; j++) 
        p[i][j] = input.nextDouble();
    
    ArrayList<Point2D> list = getConvexHull(p);
    
    System.out.print("The convex hull is ");
    for (int i = 0; i < list.size(); i++) {
      System.out.print("(" + list.get(i).getX() + ", " + list.get(i).getY() + ") ");
    }
  }
  
  public static ArrayList<Point2D> getConvexHull(double[][] s) {
    Point2D[] myPoints = new Point2D[s.length];
    for (int i = 0; i < myPoints.length; i++)
      myPoints[i] = new Point2D(s[i][0], s[i][1]);
    
    Point2D h0 = getRightmostLowestPoint(myPoints);
    ArrayList<Point2D> H = new ArrayList<Point2D>();
    H.add(h0);
    
    Point2D t0 = h0;
        
    while (true) {   
      Point2D t1 = myPoints[0];
      for (int i = 1; i < myPoints.length; i++) {
        double status = whichSide(t0.getX(), t0.getY(), t1.getX(), t1.getY(), myPoints[i].getX(), myPoints[i].getY());
        
        if (status < 0)
          t1 = myPoints[i];
        else if (status == 0) {
          if (distance(s[i][0], s[i][1], t0.getX(), t0.getY()) > distance(t1.getX(), t1.getY(), t0.getX(), t0.getY())) 
            t1 = myPoints[i];
        }
      }
      
      if (t1.equals(h0))
        break;
      else {
        H.add(t1);
        t0 = t1;
      }       
    }
    
    return H;
  }
  
  private static Point2D getRightmostLowestPoint(Point2D[] p) {
    int rightMostIndex = 0;
    double rightMostX = p[0].getX();
    double rightMostY = p[0].getY();
    
    for (int i = 1; i < p.length; i++) {
      if (rightMostY > p[i].getY()) {
        rightMostY = p[i].getY();
        rightMostX = p[i].getX();
        rightMostIndex = i;
      }
      else if (rightMostY == p[i].getY() && rightMostX < p[i].getX()) {
        rightMostX = p[i].getX();
        rightMostIndex = i;
      }
    }      
    
    return p[rightMostIndex];
  }
  
  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  }
  
  static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
    return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
  }
}
