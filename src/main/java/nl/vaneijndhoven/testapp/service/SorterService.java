package nl.vaneijndhoven.testapp.service;

import io.vertx.core.json.JsonArray;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.eventbus.Message;
import nl.vaneijndhoven.testapp.sorter.Sorter;
import nl.vaneijndhoven.testapp.sorter.impl.InsertionSorter;

import java.util.List;

public class SorterService extends AbstractVerticle {

    public static final String ADDRESS = "SorterService";

    // bubble -> selection -> insertion
    private Sorter sorter = new InsertionSorter();

    @Override
    public void start() {
        vertx.eventBus().<JsonArray>consumer(ADDRESS).toObservable().subscribe(this::processMessage);
    }

    private void processMessage(Message<JsonArray> message) {
        List<Integer> sorted = sorter.sort(message.body().getList());
        message.replyObservable(new JsonArray(sorted));
    }

}