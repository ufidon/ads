import java.util.Comparator;

public class TestComparator {
  public static void main(String[] args) {
    GeometricObject g1 = new Rectangle(5, 5);
    GeometricObject g2 = new Circle(5);

    GeometricObject g = max(g1, g2, new GeometricObjectComparator());

    System.out.println("The area of the larger object is " + g.getArea());
  }

  public static GeometricObject max(GeometricObject g1, GeometricObject g2,
      Comparator<GeometricObject> c) {
    return c.compare(g1, g2) > 0 ? g1 : g2;
  }
}

class GeometricObjectComparator implements Comparator<GeometricObject>,
    java.io.Serializable {
  public int compare(GeometricObject o1, GeometricObject o2) {
    return o1.getArea() > o2.getArea() ? 1 : o1.getArea() == o2.getArea() ? 0 : -1;
  }
}

abstract class GeometricObject {
  public abstract double getArea();
}

class Rectangle extends GeometricObject {
  public double width, height;

  public Rectangle(double w, double h) {
    width = w;
    height = h;
  }

  @Override
  public double getArea() {
    return width * height;
  }
}

class Circle extends GeometricObject {
  public double radius;

  public Circle(double r) {
    radius = r;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }
}