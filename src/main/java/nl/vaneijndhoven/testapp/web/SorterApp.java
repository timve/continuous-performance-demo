package nl.vaneijndhoven.testapp.web;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.core.eventbus.Message;
import io.vertx.rxjava.core.http.HttpServerRequest;
import nl.vaneijndhoven.testapp.service.SorterService;
import rx.Observable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.valueOf;

public class SorterApp extends AbstractVerticle {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(SorterApp.class.getName());
        vertx.deployVerticle(SorterService.class.getName(), new DeploymentOptions().setWorker(true).setMultiThreaded(true));
    }

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(this::handleRequest).listen(8080);
    }

    private void handleRequest(HttpServerRequest request) {
        String countParam = request.getParam("count");
        if (countParam == null) {
            request.response().end("<html><body><form method=\"GET\">" +
                                    "<input type=\"text\" name=\"count\"/>" +
                                    "<button type=\"submit\">submit</button></form></body></html>");
            return;
        }

        // Determine input for sorting: a stream of Integers.
        List<Integer> input = IntStream.range(0, valueOf(countParam)).boxed().collect(Collectors.toList());

        // Send request to SorterService.
        Observable<Message<JsonArray>> sorterServiceResponse =
                vertx.eventBus().sendObservable(SorterService.ADDRESS, new JsonArray(input));

        // Process reply from SorterService.
        sorterServiceResponse.subscribe(message -> request.response().end("result = " + message.body().getList()));

    }

}