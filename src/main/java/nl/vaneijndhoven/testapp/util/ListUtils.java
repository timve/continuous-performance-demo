package nl.vaneijndhoven.testapp.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static int[] toArray(List<Integer> input) {
        return ArrayUtils.toPrimitive(input.toArray(new Integer[0]));
    }

    public static List<Integer> toList(int[] input) {
        return Arrays.asList(ArrayUtils.toObject(input));
    }
}
