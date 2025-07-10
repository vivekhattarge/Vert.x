package com.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleB extends AbstractVerticle {

  Logger logger = LoggerFactory.getLogger(VerticleB.class);
  @Override
  public void start() throws Exception {
    logger.debug("Start "+getClass().getName());
  }
}
