package nl.vaneijndhoven.testapp.service;

import io.vertx.core.json.JsonArray;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.eventbus.Message;
import nl.vaneijndhoven.testapp.sorter.Sorter;
import nl.vaneijndhoven.testapp.sorter.impl.BubbleSorter;

import java.util.List;

public class SorterService extends AbstractVerticle {

    public static final String ADDRESS = "SorterService";

    // Supported implementations: Bubble Sort, Selection Sort, Insertion Sort.
    private Sorter sorter = new BubbleSorter();

    @Override
    public void start() {
        vertx.eventBus().<JsonArray>consumer(ADDRESS).toObservable().subscribe(this::processMessage);
    }

    private void processMessage(Message<JsonArray> message) {
        List<Integer> sorted = sorter.sort(message.body().getList());
        message.replyObservable(new JsonArray(sorted));
    }

}