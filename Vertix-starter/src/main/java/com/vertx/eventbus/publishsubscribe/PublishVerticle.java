package com.vertx.eventbus.publishsubscribe;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PublishVerticle extends VerticleBase {

  @Override
  public Future<?> start() throws Exception {

    vertx.setPeriodic(Duration.ofSeconds(10).toMillis(), handler -> {
    vertx.eventBus().publish(PublishVerticle.class.getName(),"A message for subscriber...");
    });

    return super.start();
  }
}
