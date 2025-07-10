package com.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleAA extends AbstractVerticle {

  Logger logger = LoggerFactory.getLogger(VerticleAA.class);
  @Override
  public void start() throws Exception {
    logger.debug("Start : "+getClass().getName());
  }

}
