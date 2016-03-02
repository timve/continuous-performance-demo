package nl.vaneijndhoven.testapp.sorter;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public interface Sorter {

    Logger LOG = LoggerFactory.getLogger(Sorter.class);

    int[] sort(int[] input);

    default List<Integer> sort(List<Integer> input) {
        // Go from List<Integer> to int[], sort, and back from int[] to List<Integer>...
        return Arrays.asList(ArrayUtils.toObject(sort(ArrayUtils.toPrimitive(input.toArray(new Integer[0])))));
    }

}
