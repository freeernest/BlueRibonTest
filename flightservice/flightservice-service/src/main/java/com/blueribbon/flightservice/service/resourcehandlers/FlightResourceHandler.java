package com.blueribbon.flightservice.service.resourcehandlers;

import com.blueribbon.commons.web.handler.QueryString2BodyHandler;
import com.blueribbon.flightservice.service.FlightService;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;


public class FlightResourceHandler extends AbstractResourceHandler {

    private FlightService flightService;

    public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public Router createRouter(Vertx vertx) {

        Router router = Router.router(vertx);

        router.get("/").handler(QueryString2BodyHandler.create());
        router.get("/").handler(this::handleListGems);
//        router.post("/").handler(this::handleCreateGem);
        router.get("/:ticket/:flightNum").handler(this::handleGetGem);

        return router;
    }

    private void handleGetGem(RoutingContext routingContext) {
        flightService.fetchFlight(routingContext.request().getParam("ticket")
                , routingContext.request().getParam("flightNum")
                , resultHandler(routingContext));
    }

    private void handleCreateGem(RoutingContext routingContext) {
       
        JsonObject flight = routingContext.getBodyAsJson();
        
        flightService.upsertFlight(flight, resultHandler(routingContext, 201));
    }

    private void handleListGems(RoutingContext routingContext) {
        flightService.fetchFlights(routingContext.getBodyAsJson(), resultHandler(routingContext));
    }

}
