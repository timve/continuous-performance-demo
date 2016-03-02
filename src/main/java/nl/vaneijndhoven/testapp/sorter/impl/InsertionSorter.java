package nl.vaneijndhoven.testapp.sorter.impl;

import nl.vaneijndhoven.testapp.sorter.Sorter;

public class InsertionSorter implements Sorter {

    @Override
    public int[] sort(int[] num) {
        long start = System.currentTimeMillis();

        int j; // the number of items sorted so far
        int key; // the item to be inserted
        int i;

        for (j = 1; j < num.length; j++) { // Start with 1 (not 0)
            key = num[j];
            for(i = j-1; (i >= 0) && (num[i] < key); i--) { // Smaller values are moving up
                num[i+1] = num[i];
            }
            num[i+1] = key; // Put the key in its proper location
        }
        long end = System.currentTimeMillis();
        LOG.info("Insertion sort completed in " + (end - start) + " ms");

        return num;
    }

}
