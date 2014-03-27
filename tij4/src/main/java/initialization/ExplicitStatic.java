package initialization;

//: initialization/ExplicitStatic.java
// Explicit static initialization with the "static" clause.
import static net.mindview.util.Print.*;

class Cup {
  Cup(int marker) {
    print("Cup(" + marker + ")");
  }
  /**
 *
 */
    public Cup() {
        System.out.println("default cup constructor");
    }

  void f(int marker) {
    print("f(" + marker + ")");
  }
}

class Cups {
  static Cup cup1;
  static Cup cup2 = new Cup(2);
  Cup[] cups = new Cup[12];
  Cup cup3 = new Cup(3);
  Cup cup4;
  {
      cup4 = new Cup(4);
  }
  static {
    cup1 = new Cup(1);
//    cup2 = new Cup(2);
  }
  Cups() {
    print("Cups()");
  }
}

public class ExplicitStatic {
  public static void main(String[] args) {
    print("Inside main()");
//    Cups.cup1.f(99);  // (1)
  }
//   static Cups cups1 = new Cups();  // (2)
  // static Cups cups2 = new Cups();  // (2)
  static ChildT childT = new ChildT();
} /* Output:
Inside main()
Cup(1)
Cup(2)
f(99)
*///:~

class parentT {
    static Cup cup10 = new Cup(10);
    static Cup cup11;
    Cup cup12;
    Cup cup13 = new Cup(13);
    static {
        cup11 = new Cup(11);
        System.out.println("init cup 11");
    }
    {
        cup12 = new Cup(12);
        System.out.println("init cup 12");
    }

    public parentT() {
        System.out.println("parentT");
    }

}
class ChildT extends parentT {
    static Cup cup14 = new Cup(14);
    static Cup cup15;
    Cup cup16;
    Cup cup17 = new Cup(17);
    static {
        cup15 = new Cup(15);
        System.out.println("init cup 15");
    }
    {
        cup16 = new Cup(16);
        System.out.println("init cup 16");
    }

    public ChildT() {
        System.out.println("ChildT");
    }


}

/* output
Cup(10)
Cup(11)
init cup 11
Cup(14)
Cup(15)
init cup 15
Cup(13)
Cup(12)
init cup 12
parentT
Cup(17)
Cup(16)
init cup 16
ChildT
Inside main()
 */

