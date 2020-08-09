package org.example;

import org.example.Service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {
    //1.Create an instance of ArrayFlattenerService, we will need to call the function flattenArray()
    //tell Mockito that this is the service we are mocking in our test
    private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
    //2. Create an instance of the class ArrayReversor as we will need to call the method reverseArray()
    private ArrayReversor arrayReversor;

    //3. setting up the environment for the test (It can be viewed as an pre-condition of our test)
    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }
    //4. points the current instance of ArrayReversor to null. (It can be viewed as an post-condition after the test
    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }

    @Test
    public void reversedArray() {
        int[][] nestedArray = new int[][]{{1, 3}, {0}, {4, 5, 9}};
        //5. Configuring a simple return behavior for mock
        when(arrayFlattenerService.flatternArray(nestedArray)).thenReturn(new int[]{1, 3, 0, 4, 5, 9});
        int[] output = arrayReversor.reversedArray(nestedArray);
        int[] expected = {9, 5, 4, 0, 3, 1};
        //6. Test whether two arrays are equal to each other
        assertArrayEquals(expected, output);
        //7. Verify that a method has been called with certain parameters
        verify(arrayFlattenerService).flatternArray(nestedArray);
    }
}
