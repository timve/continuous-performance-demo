package nl.vaneijndhoven.testapp.sorter;

import java.util.List;

import static nl.vaneijndhoven.testapp.util.ListUtils.toArray;
import static nl.vaneijndhoven.testapp.util.ListUtils.toList;

public interface Sorter {

    int[] sort(int[] input);

    /** Convenience method for passing a List to sort(int[]). */
    default List<Integer> sort(List<Integer> input) {
        return toList(sort(toArray(input)));
    }

}
