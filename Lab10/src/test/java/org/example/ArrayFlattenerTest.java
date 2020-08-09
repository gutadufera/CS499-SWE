package org.example;

import org.example.Service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ArrayFlattenerTest {
    private ArrayFlattener arrayFlattener;
    private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);

    @Before
    public void setUp() throws Exception {
        this.arrayFlattener = new ArrayFlattener(arrayFlattenerService);
    }

    @After
    public void tearDown() throws Exception {
        this.arrayFlattener = null;
    }

    @Test
    public void arrayFlattenerTest() {
        int[][] input = new int[][]{new int[]{1, 3}, new int[]{0}, new int[]{4, 5, 9}};
        int[] expected = new int[]{1, 3, 0, 4, 5, 9};
        int[] actual = this.arrayFlattener.arrayFlattener(input);
        assertArrayEquals(expected, actual);
    }
}