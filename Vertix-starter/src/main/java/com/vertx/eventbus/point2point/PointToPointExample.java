package com.vertx.eventbus.point2point;

import io.vertx.core.Vertx;

public class PointToPointExample {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new SenderVerticle());
    vertx.deployVerticle(new ReceiverVerticle());
  }
}
