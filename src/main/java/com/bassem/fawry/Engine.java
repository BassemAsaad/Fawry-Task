package com.bassem.fawry;

public interface Engine {
    void start();
    void stop();
    boolean isStarted();

    void increase();
    void decrease();

    void onSpeedChange(int targetSpeed);
    int retrieveSpeed();

    EngineType retrieveEngineType();
}
