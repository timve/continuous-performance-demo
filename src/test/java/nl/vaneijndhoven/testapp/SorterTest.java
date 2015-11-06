package nl.vaneijndhoven.testapp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SorterTest {

    @Test
    public void testInsertionSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        Sorter.insertionSort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }

    @Test
    public void testSelectionSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        Sorter.selectionSort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }

    @Test
    public void testBubbleSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        Sorter.bubbleSort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }
}