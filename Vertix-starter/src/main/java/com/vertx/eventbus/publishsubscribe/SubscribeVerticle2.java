package com.vertx.eventbus.publishsubscribe;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscribeVerticle2 extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(SubscribeVerticle2.class);

  @Override
  public Future<?> start() throws Exception {
    vertx.eventBus().consumer(PublishVerticle.class.getName(),handler -> {
        logger.debug("Received : {}",handler.body());
    });
    return super.start();
  }
}
