package maidez.parctices.mockitodemo;

import maidez.practices.mockitodemo.MyFibonacci;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MyFibonacciTest {
    @Test
    public void testMock_When_ThenReturn() {

        MyFibonacci mock = mock(MyFibonacci.class);

        when(mock.fibonacci(0)).thenReturn(1234L);

        long result = mock.fibonacci(0);

        Assert.assertEquals(1234L, result);
    }


    @Test
    public void testSpy_When_ThenReturn() {
        MyFibonacci myFibonacci = new MyFibonacci();
        MyFibonacci spy = spy(myFibonacci);

        try {
            when(spy.fibonacci(0)).thenReturn(1234L);
        } catch (IllegalArgumentException e) {
            //do nothing
            return;
        }
        throw new RuntimeException("Failed to catch IllegalArgumentException");
    }

    @Test
    public void testMock_doReturn_when_someMethod() {
        MyFibonacci mock = mock(MyFibonacci.class);
        doReturn(1234L).when(mock).fibonacci(0);

        long result = mock.fibonacci(0);

        Assert.assertEquals(1234L, result);
    }

    @Test
    public void testSpy_doReturn_when_someMethod() {
        MyFibonacci myFibonacci = new MyFibonacci();
        MyFibonacci spy = spy(myFibonacci);

        doReturn(1234L).when(spy).fibonacci(0);

        long result = spy.fibonacci(0);

        Assert.assertEquals(1234L, result);
    }

    @Test
    public void testSpy_verify() {
        MyFibonacci myFibonacci = new MyFibonacci();
        MyFibonacci spy = spy(myFibonacci);

        spy.fibonacci(10);

        MyFibonacci withCache = verify(spy, times(109));
        withCache.fibonacci(anyInt(), anyBoolean());
        withCache.fibonacci(anyInt(), anyBoolean());
    }

    @Test
    public void testSpy_verify_withCache() {
        MyFibonacci myFibonacci = new MyFibonacci();
        MyFibonacci spy = spy(myFibonacci);

        spy.fibonacci(10, true);

        verify(spy, times(17)).fibonacci(anyInt(), anyBoolean());
    }
}
