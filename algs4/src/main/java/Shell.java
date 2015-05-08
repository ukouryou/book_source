import stdlib.edu.princeton.cs.introcs.StdIn;
import stdlib.edu.princeton.cs.introcs.StdOut;

/*************************************************************************
 *  Compilation:  javac Shell.java
 *  Execution:    java Shell < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using shellsort.
 *
 *  Uses increment sequence proposed by Sedgewick and Incerpi.
 *  The nth element of the sequence is the smallest integer >= 2.5^n
 *  that is relatively prime to all previous terms in the sequence.
 *  For example, incs[4] is 41 because 2.5^4 = 39.0625 and 41 is
 *  the next integer that is relatively prime to 3, 7, and 16.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Shell < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Shell < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *
 *************************************************************************/

/**
 *  The <tt>Shell</tt> class provides static methods for sorting an
 *  array using Shellsort with Knuth's increment sequence (1, 4, 13, 40, ...).
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Shell {

    // This class should not be instantiated.
    private Shell() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < N/3) h = 3*h + 1;

        int jj = 0;
        System.out.println(h);
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    jj ++;
                    exch(a, j, j-h);
                }
            }
            assert isHsorted(a, h);
            h /= 3;
        }
        System.out.println(jj);
        assert isSorted(a);
    }


    public static void sortX(Comparable[] a) {

        int N = a.length;

        int h = 1;

        while (h < N/3) {
            h = h * 3 + 1;
        }
        int jj = 0;
System.out.println(h);
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                int j = i;
                Comparable v = a[j];
                while (j>=h && less(v, a[j-h])) {
                    jj++;
                    a[j] = a[j-h];
                    j -= h;
                }
                a[j] = v;
            }
            h /= 3;
        }
        System.out.println(jj++);

    }

    public static void shellSortX(Comparable[] a) {

        int inner ,outer;

        Comparable temp;

        int N = a.length;

        int h = 1;

        while (h <= N/3) {
            h = h * 3 + 1;
       }
        int jj = 0;
System.out.println(h);
        while (h > 0) {
            for (outer = h; outer < N; outer++) {
                temp = a[outer];
                inner = outer;
                while (inner > h -1 && less(temp, a[inner-h])) {
                    jj++;
                    a[inner] = a[inner-h];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h =  (h-1) / 3;
        }
        System.out.println(jj++);

    }











   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; Shellsorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
        String[] a = "S O R T E X A M P L E".split(" ");
        Shell.sort(a);
        show(a);
    }

}
