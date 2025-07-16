package com.vertx.Vertix_starter;

import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(VertxExtension.class)
public class FuturePromiseExample {

  Logger logger = LoggerFactory.getLogger(FuturePromiseExample.class);

  @Test
  void promise_success(Vertx vertx, VertxTestContext vertxTestContext){
    Promise<String> promise = Promise.promise();
    logger.debug("Start");
    vertx.setTimer(500,id->{
      promise.complete("Success");
      logger.debug("Success");
    });
    logger.debug("end");
  }

  @Test
  void future_success(Vertx vertx,VertxTestContext context){
    Promise<String> promise = Promise.promise();
    logger.debug("Start");
    vertx.setTimer(500,id->{
      promise.complete("Success");
      logger.debug("Timer Done.");
    });

    Future<String> future = promise.future();
    future.onSuccess(success ->{
    logger.debug("Result : {}",success);
    }).onFailure(failure ->{
      logger.debug("failed promise");
    });

  }

  @Test
  void future_failure(Vertx vertx,VertxTestContext context){
    Promise<String> promise = Promise.promise();
    logger.debug("Start");
    vertx.setTimer(500,id->{
      promise.fail("Failed");
      logger.debug("Timer Done.");
    });

    Future<String> future = promise.future();
    future.onSuccess(failure ->{
      logger.debug("Result : {}",failure);
    }).onFailure(failure ->{
      logger.debug("failed promise");
      context.completeNow();
    });

  }
}
