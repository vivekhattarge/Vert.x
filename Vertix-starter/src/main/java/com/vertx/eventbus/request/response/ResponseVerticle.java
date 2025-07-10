package com.vertx.eventbus.request.response;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vertx.eventbus.request.response.Constants.ADDRESS;

public class ResponseVerticle extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(ResponseVerticle.class);

  @Override
  public Future<?> start() throws Exception {
    vertx.eventBus().consumer(ADDRESS,handler -> {
      logger.debug("Received message : {}",handler.body());
      handler.reply("Received your message. Thanks!");
    });
    return super.start();
  }
}
