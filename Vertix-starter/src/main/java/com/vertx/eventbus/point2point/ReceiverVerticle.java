package com.vertx.eventbus.point2point;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceiverVerticle extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(ReceiverVerticle.class);

  @Override
  public Future<?> start() throws Exception {
    vertx.eventBus().<String>consumer(SenderVerticle.class.getName(),handler -> {
      logger.debug("Received : {}",handler.body());
    });
    return super.start();
  }
}
