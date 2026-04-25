package com.pioneers.fawry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GasEngine implements Engine {
    protected boolean isEngineOn;
    protected int engineSpeed;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());


    @Override
    public void start() {
        if (isEngineOn) {
            log.warn("Engine Already statred");
            return;
        }
        engineSpeed = 0;
        isEngineOn = true;
        log.info("start");
    }

    @Override
    public void stop() {
        if (!isEngineOn) {
            log.warn("Engine is not started");
            return;
        }
        isEngineOn = false;
        log.info("stop");
    }

    @Override
    public boolean isStarted() {
        return isEngineOn;
    }

    @Override
    public void increase() {
        if (!isEngineOn) {
            log.warn("Engine is not started");
            return;
        }
        engineSpeed++;
        log.info("increased speed: {}", engineSpeed);
    }

    @Override
    public void decrease() {
        if (!isEngineOn) {
            log.warn("Engine is not started");
            return;
        }
        engineSpeed--;
        log.info("decreased speed: {}", engineSpeed);
    }

    @Override
    public void onSpeedChange(final int targetSpeed) {
        if (!isEngineOn) {
            log.warn("Engine is not started");
            return;
        }
        log.info("onSpeedChange");
        while (targetSpeed > engineSpeed) {
            increase();
        }
        while (targetSpeed < engineSpeed) {
            decrease();
        }
        log.info("final speed: {}", engineSpeed);
    }

    @Override
    public int retrieveSpeed() {
        return engineSpeed;
    }

    @Override
    public EngineType retrieveEngineType() {
        return EngineType.GAS;
    }
}
