package nl.vaneijndhoven.testapp;

import nl.vaneijndhoven.testapp.sorter.impl.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SorterTest {

    @Test
    public void insertionSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        int[] result = new InsertionSorter().sort(arr);
        assertThat(result, is(new int[]{4,3,2,1}));
    }

    @Test
    public void selectionSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        int[] result = new SelectionSorter().sort(arr);
        assertThat(result, is(new int[]{4,3,2,1}));
    }

    @Test
    public void bubbleSort() throws Exception {
        int[] arr = new int[]{1,2,3,4};
        int[] result = new BubbleSorter().sort(arr);
        assertThat(arr, is(new int[]{4,3,2,1}));
    }
}