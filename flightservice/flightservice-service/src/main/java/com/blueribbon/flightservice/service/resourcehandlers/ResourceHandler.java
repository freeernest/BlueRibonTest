package com.blueribbon.flightservice.service.resourcehandlers;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;


public interface ResourceHandler {
    Router createRouter(Vertx vertx);
}
