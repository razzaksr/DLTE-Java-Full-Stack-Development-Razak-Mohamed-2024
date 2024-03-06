package testcase.app;


import junit.framework.TestResult;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


public class AppTest {
    static List<Integer> myNumbers;
    @BeforeClass
    public static void initiate(){
        myNumbers= Arrays.asList(12,45,67,45,7,57,45,23,4,57);
    }

    @Before
    public void verify(){
        System.out.println(myNumbers);
    }

    @Test
    public void readTest(){
        //assertTrue(myNumbers.size()<0);
        assertEquals(Optional.of(12), Optional.ofNullable(myNumbers.get(0)));
    }

    List<Integer> viewAll(){
        try {
            Thread.sleep(5000);
            return myNumbers;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateTest(){
        assertSame(45,myNumbers.set(2,90));
    }

    @Test(timeout = 6000)
    public void testTime(){
        assertFalse(viewAll().size()<0);
    }

    public void execution(){
        myNumbers.set(-1,90);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testExecution(){
        execution();
    }
    public void assess(){

    }

}