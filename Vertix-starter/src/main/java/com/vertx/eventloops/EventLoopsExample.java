package com.vertx.eventloops;

import io.vertx.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class EventLoopsExample extends VerticleBase {

Logger logger = LoggerFactory.getLogger(EventLoopsExample.class);

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx(
      new VertxOptions()
        .setMaxEventLoopExecuteTime(500)
        .setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS)
        .setBlockedThreadCheckInterval(1)
        .setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS)
    );
    vertx.deployVerticle( EventLoopsExample.class.getName(),new DeploymentOptions().setInstances(4));
  }

  @Override
  public Future<?> start() throws Exception {
    logger.debug("Start : {}",getClass().getName());
    Thread.sleep(5000);
    return super.start();
  }
}
