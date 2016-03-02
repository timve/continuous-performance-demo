package nl.vaneijndhoven.testapp.sorter.impl;

import nl.vaneijndhoven.testapp.sorter.Sorter;

public class SelectionSorter implements Sorter {

    @Override
    public int[] sort(int[] num) {
        long start = System.currentTimeMillis();

        int i, j, first, temp;
        for (i = num.length - 1; i > 0; i--) {
            first = 0; // initialize to subscript of first element
            for(j = 1; j <= i; j++) { // locate smallest element between positions 1 and i.
                if(num[j] < num[first]) {
                    first = j;
                }
            }
            temp = num[first]; //swap smallest found with element in position i.
            num[first] = num[i];
            num[i] = temp;
        }
        long end = System.currentTimeMillis();
        LOG.info("Selection sort completed in " + (end - start) + " ms");

        return num;
    }

}
