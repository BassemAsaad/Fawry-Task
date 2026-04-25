package com.bassem.fawry;

public class Car {
    private int speed;
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        this.speed = 0;
        if (!engine.isStarted()) {
            engine.start();
        }
    }

    public void stop(){
        engine.stop();
    }

    public void accelerate(){
        if (speed >= 200){
            return;
        }
        speed+=20;
        engine.onSpeedChange(speed);
    }

    public void brake(){
        if (speed == 0){
            return;
        }
        speed-=20;
        engine.onSpeedChange(speed);
    }


    public void replaceEngine(Engine engine){
        System.out.println("replacing engine from " + this.engine.retrieveEngineType() + " to " + engine.retrieveEngineType());
        this.engine = engine;
        this.engine.start();
        this.engine.onSpeedChange(speed);
    }
}
