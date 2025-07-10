package com.vertx.eventbus.publishsubscribe;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class PublishSubscribeExample {

  public static void main(String[] args) {
  Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new PublishVerticle());
    vertx.deployVerticle(new SubscribeVerticle2());
    vertx.deployVerticle(SubscribeVerticle.class.getName(),new DeploymentOptions().setInstances(2));
  }

}
