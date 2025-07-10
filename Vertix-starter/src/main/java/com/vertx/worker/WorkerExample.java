/*
package com.vertx.worker;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerExample extends AbstractVerticle {

  Logger LOG = LoggerFactory.getLogger(WorkerExample.class);

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new WorkerExample());
  }

  @Override
  public void start() throws Exception {
    System.out.println("Starting verticle on thread: " + Thread.currentThread().getName());

    vertx.executeBlocking(event -> {
      LOG.debug("Executing blocking code");
      try {
        Thread.sleep(5000);
        event.complete();
      } catch (InterruptedException e) {
        LOG.error("Failed: ", e);
        event.fail(e);
      }
    }, result -> {
      if (result.succeeded()) {
        LOG.debug("Blocking call done.");
      } else {
        LOG.error("Blocking call failed due to:", result.cause());
      }
    });
  }
}
*/
