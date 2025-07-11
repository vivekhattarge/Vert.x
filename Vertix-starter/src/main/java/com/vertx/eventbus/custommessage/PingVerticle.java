package com.vertx.eventbus.custommessage;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vertx.eventbus.custommessage.Constants.ADDRESS;

public class PingVerticle extends VerticleBase {

  Logger logger = LoggerFactory.getLogger(PingVerticle.class);

  @Override
  public Future<?> start() throws Exception {
    Ping ping = new Ping(true,"Hello");
    vertx.eventBus().registerDefaultCodec(Ping.class, new LocalMessageCodec<>(Ping.class));
    vertx.<Pong>eventBus().request(ADDRESS,ping).onSuccess(successHandler ->{
      logger.debug("Success message : {}",successHandler.body());
    }).onFailure(failHandler ->{
      logger.debug("Failure Message : {}",failHandler.getMessage());
    });
    return super.start();
  }
}
