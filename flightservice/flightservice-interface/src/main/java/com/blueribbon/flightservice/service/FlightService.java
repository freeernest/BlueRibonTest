package com.blueribbon.flightservice.service;

import io.vertx.codegen.annotations.ProxyClose;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.List;

@ProxyGen
@VertxGen
public interface FlightService extends FlightServiceContextAware {

    String SERVICE_ADDRESS = "flight.service";

    void fetchFlights(JsonObject criteria, Handler<AsyncResult<List<JsonObject>>> resultHandler);

    void fetchFlight(String lab, String certNum, Handler<AsyncResult<JsonObject>> resultHandler);

    void upsertFlight(JsonObject object, Handler<AsyncResult<JsonObject>> resultHandler);

    @ProxyClose
    void close();
}
