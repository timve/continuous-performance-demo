package nl.vaneijndhoven.testapp.sorter.impl;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import nl.vaneijndhoven.testapp.sorter.Sorter;

public class BubbleSorter implements Sorter {

    private static final Logger LOG = LoggerFactory.getLogger(BubbleSorter.class);

    @Override
    public int[] sort(int[] num) {
        long start = System.currentTimeMillis();

        int j;
        boolean flag = true; // set flag to true to begin first pass
        int temp; // holding variable

        while (flag) {
            flag = false; // set flag to false awaiting a possible swap
            for (j = 0; j < num.length - 1; j++) {
                if (num[j] < num[j + 1]) { // change to > for ascending sort
                    temp = num[j]; // swap elements
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true; // shows a swap occurred
                }
            }
        }
        long end = System.currentTimeMillis();
        LOG.info("Bubble sort completed in " + (end - start) + " ms");

        return num;
    }

}