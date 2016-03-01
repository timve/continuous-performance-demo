package nl.vaneijndhoven.testapp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SorterAppTest {

    @Test
    public void testInsertionSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        SorterApp.insertionSort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }

    @Test
    public void testSelectionSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        SorterApp.selectionSort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }

    @Test
    public void testBubbleSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        SorterApp.bubbleSort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }
}