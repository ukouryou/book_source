package stdlib.edu.princeton.cs.introcs;

/*************************************************************************
 *  Compilation:  javac Out.java
 *  Execution:    java Out
 *
 *  Writes data of various types to: stdout, file, or socket.
 *
 *************************************************************************/


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

/**
 *  This class provides methods for writing strings and numbers to
 *  various output streams, including standard output, file, and sockets.
 *  <p>
 *  For additional documentation, see
 *  <a href="http://introcs.cs.princeton.edu/31datatype">Section 3.1</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Out {

    // force Unicode UTF-8 encoding; otherwise it's system dependent
    private static String charsetName = "UTF-8";

    // assume language = English, country = US for consistency with In
    private static final Locale US_LOCALE = new Locale("en", "US");

    private PrintWriter out;

   /**
     * Create an Out object using an OutputStream.
     */
    public Out(OutputStream os) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

   /**
     * Create an Out object using standard output.
     */
    public Out() { this(System.out); }

   /**
     * Create an Out object using a Socket.
     */
    public Out(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

   /**
     * Create an Out object using a file specified by the given name.
     */
    public Out(String s) {
        try {
            OutputStream os = new FileOutputStream(s);
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

   /**
     * Close the output stream.
     */
    public void close() { out.close(); }



   /**
     * Terminate the line.
     */
    public void println() {
        out.println();
    }

   /**
     * Print an object and then terminate the line.
     */
    public void println(Object x) {
        out.println(x);
    }

   /**
     * Print a boolean and then terminate the line.
     */
    public void println(boolean x) {
        out.println(x);
    }

   /**
     * Print a char and then terminate the line.
     */
    public void println(char x) {
        out.println(x);
    }

   /**
     * Print an double and then terminate the line.
     */
    public void println(double x) {
        out.println(x);
    }

   /**
     * Print a float and then terminate the line.
     */
    public void println(float x) {
        out.println(x);
    }

   /**
     * Print an int and then terminate the line.
     */
    public void println(int x) {
        out.println(x);
    }

   /**
     * Print a long and then terminate the line.
     */
    public void println(long x) {
        out.println(x);
    }

   /**
     * Print a byte and then terminate the line.
     */
    public void println(byte x) {
        out.println(x);
    }



   /**
     * Flush the output stream.
     */
    public void print() {
        out.flush();
    }

   /**
     * Print an object and then flush the output stream.
     */
    public void print(Object x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print an boolean and then flush the output stream.
     */
    public void print(boolean x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print an char and then flush the output stream.
     */
    public void print(char x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print an double and then flush the output stream.
     */
    public void print(double x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a float and then flush the output stream.
     */
    public void print(float x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print an int and then flush the output stream.
     */
    public void print(int x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a long and then flush the output stream.
     */
    public void print(long x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a byte and then flush the output stream.
     */
    public void print(byte x) {
        out.print(x);
        out.flush();
    }

   /**
     * Print a formatted string using the specified format string and arguments,
     * and then flush the output stream.
     */
    public void printf(String format, Object... args) {
        out.printf(US_LOCALE, format, args);
        out.flush();
    }

   /**
     * Print a formatted string using the specified locale, format string and arguments,
     * and then flush the output stream.
     */
    public void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }


   /**
     * A test client.
     */
    public static void main(String[] args) {
        Out out;

        // write to stdout
        out = new Out();
        out.println("Test 1");
        out.close();

        // write to a file
        out = new Out("test.txt");
        out.println("Test 2");
        out.close();
    }

}


/*************************************************************************
 *  Copyright 2002-2012, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of stdlib-package.jar, which accompanies the textbook
 *
 *      Introduction to Programming in Java: An Interdisciplinary Approach
 *      by R. Sedgewick and K. Wayne, Addison-Wesley, 2007. ISBN 0-321-49805-4.
 *
 *      http://introcs.cs.princeton.edu
 *
 *
 *  stdlib-package.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  stdlib-package.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with stdlib-package.jar.  If not, see http://www.gnu.org/licenses.
 *************************************************************************/

