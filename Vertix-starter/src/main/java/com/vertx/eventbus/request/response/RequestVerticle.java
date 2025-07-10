package com.vertx.eventbus.request.response;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import io.vertx.core.eventbus.DeliveryOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vertx.eventbus.request.response.Constants.ADDRESS;

public class RequestVerticle extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(RequestVerticle.class);

  @Override
  public Future<?> start() throws Exception {
    final String message = "Hello from Request Verticle!";
    var eventBus = vertx.eventBus();
    logger.debug("Sending: {}", message);
    eventBus.<String>request(ADDRESS, message).onSuccess(reply ->{
      logger.debug(reply.body());
    }).onFailure(failHandler -> {
      logger.debug("Failed to receive response.");
    });
    return super.start();
  }
}
