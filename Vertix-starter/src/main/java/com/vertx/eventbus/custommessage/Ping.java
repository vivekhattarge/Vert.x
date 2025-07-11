package com.vertx.eventbus.custommessage;

public class Ping {
  private String message;
  private boolean enabled;

  public Ping(boolean enabled, String message) {
    this.enabled = enabled;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public String toString() {
    return "Ping{" +
      "enabled=" + enabled +
      ", message='" + message + '\'' +
      '}';
  }
}
