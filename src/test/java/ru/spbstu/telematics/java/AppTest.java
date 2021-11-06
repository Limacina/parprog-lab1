package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Arrays;
import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    private void printTest(int i, int[][] arr, int n, int[][] exp) {
        System.out.println("Test " + i);
        System.out.println("Array:");
        App.print(arr, n);
        System.out.println("Result matrix:");
        App.print(App.snake(arr, n), n);
        Assert.assertArrayEquals(exp, App.snake(arr, n));
    }
    /**
     * Rigourous Test :-)
     */

    public void test0(){
        int[][] arr = { {0, 1}, {2, 3}};
        int[][] exp = { {0, 1}, {3, 2}};
        printTest(0, arr, 2, exp);
    }

    public void test1(){
        int[][] arr = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] exp = { {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};

        printTest(1, arr, 4, exp);
    }

    public void test2(){
        int[][] arr = { {0, 15, 1, 14},
                {2, 13, 3, 12},
                {4, 11, 5, 10},
                {6, 9, 7, 8}};
        int[][] exp = { {0, 15, 1, 14},
                {10, 6, 9, 2},
                {5, 8, 7, 13},
                {11, 4, 12, 3}};
        printTest(2, arr, 4, exp);
    }

    public void test3(){
        int[][] arr = { {0, 15, 1, 14},
                {2, 13, 3, 12},
                {4, 11, 5, 10},
                {6, 9, 7, 8}};
        int[][] exp = { {0, 15, 1, 14},
                {10, 6, 9, 2},
                {5, 8, 7, 13},
                {11, 4, 12, 3}};
        printTest(3, arr, 4, exp);
    }

    public void test4(){
        int[][] arr = {{1}};
        int[][] exp = {{1}};
        printTest(4, arr, 1, exp);
    }

}
