package com.vertx.eventbus.custommessage;

import io.vertx.core.Vertx;

public class PingPongExample {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new PingVerticle());
    vertx.deployVerticle(new PongVerticle());
  }

}
