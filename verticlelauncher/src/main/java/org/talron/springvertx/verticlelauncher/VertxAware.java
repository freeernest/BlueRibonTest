package org.talron.springvertx.verticlelauncher;

import io.vertx.core.Vertx;

/**
 * Created by avnerlevinstien on 27/03/2017.
 */
public interface VertxAware {
    void setVertx(Vertx vertx);
}
