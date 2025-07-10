package com.vertx.eventbus.point2point;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SenderVerticle extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(SenderVerticle.class);

  @Override
  public Future<?> start() throws Exception {
    vertx.setPeriodic(1000, id -> {
      vertx.eventBus().<String>send(SenderVerticle.class.getName(),"Sending a message");
    });
    return super.start();
  }
}
