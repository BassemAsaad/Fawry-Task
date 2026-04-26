package com.bassem.fawry;



public class GasEngine implements Engine {
    protected boolean isEngineOn;
    protected int engineSpeed;


    @Override
    public void start() {
        if (isEngineOn) {
            System.out.println("Engine Already statred");
            return;
        }
        engineSpeed = 0;
        isEngineOn = true;
        System.out.println("start");
    }

    @Override
    public void stop() {
        if (!isEngineOn) {
            System.out.println("Engine is not started");
            return;
        }
        isEngineOn = false;
        System.out.println("stop");
    }

    @Override
    public boolean isStarted() {
        return isEngineOn;
    }

    @Override
    public void increase() {
        if (!isEngineOn) {
            System.out.println("Engine is not started");
            return;
        }
        engineSpeed++;
        System.out.println("increased speed: " + engineSpeed);
    }

    @Override
    public void decrease() {
        if (!isEngineOn) {
            System.out.println("Engine is not started");
            return;
        }
        engineSpeed--;
        System.out.println("decreased speed: " + engineSpeed);
    }

    @Override
    public void onSpeedChange(final int targetSpeed) {
        if (!isEngineOn) {
            System.out.println("Engine is not started");
            return;
        }
        System.out.println("onSpeedChange");
        while (targetSpeed > engineSpeed) {
            increase();
        }
        while (targetSpeed < engineSpeed) {
            decrease();
        }
        System.out.println("final speed: " + engineSpeed);
    }

    @Override
    public int retrieveSpeed() {
        return engineSpeed;
    }

    @Override
    public void updateSpeed(int targetSpeed) {
        engineSpeed = targetSpeed;
    }

    @Override
    public EngineType retrieveEngineType() {
        return EngineType.GAS;
    }
}
