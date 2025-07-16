package com.vertx.eventbus.custommessage;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vertx.eventbus.custommessage.Constants.CUSTOM_ADDRESS;

public class PongVerticle extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(PongVerticle.class);
  @Override
  public Future<?> start() throws Exception {
    vertx.eventBus().registerDefaultCodec(Pong.class, new LocalMessageCodec<>(Pong.class));
    vertx.eventBus().consumer(CUSTOM_ADDRESS, handler ->{
      logger.debug("Received Message : {}",handler.body());
      handler.reply(new Pong(0));
    }).exceptionHandler(exception ->{
        logger.debug("Error : {}",exception.getMessage());
      });
    return super.start();
  }
}
