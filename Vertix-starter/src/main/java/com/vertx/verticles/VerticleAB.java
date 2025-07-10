package com.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleAB extends AbstractVerticle {

  Logger logger = LoggerFactory.getLogger(VerticleAB.class);
  @Override
  public void start() throws Exception {
    logger.debug("Start : "+getClass().getName());
  }

}
