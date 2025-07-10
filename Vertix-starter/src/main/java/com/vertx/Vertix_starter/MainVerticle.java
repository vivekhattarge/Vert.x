package com.vertx.Vertix_starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start() throws Exception {
    vertx.createHttpServer()
      .requestHandler(httpServerRequest -> {
        httpServerRequest.response()
          .putHeader("content-type","text/plain")
          .end("Hello from vert.x");
      }).listen(8888).onSuccess(http -> {
        System.out.println("HTTp Server started on 8888");
      });
  }

/*  @Override
  public Future<?> start() {
    return vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8888).onSuccess(http -> {
      System.out.println("HTTP server started on port 8888");
    });
  }*/
}
