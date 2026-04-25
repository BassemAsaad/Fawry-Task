package com.pioneers.fawry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HybridEngine implements Engine {
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private Engine activeEngine;
    private static final int MAX_ELECTRIC_SPEED = 50;

    public HybridEngine() {
        this.activeEngine = new ElectricEngine();
    }

    @Override
    public void start() {
        activeEngine.start();
    }

    @Override
    public void stop() {
        activeEngine.stop();
    }

    @Override
    public void increase() {
        activeEngine.increase();
    }

    @Override
    public void decrease() {
        activeEngine.decrease();
    }

    @Override
    public void onSpeedChange(final int targetSpeed) {
        log.info("onSpeedChange");
        log.info("current Speed is: " + activeEngine.retrieveSpeed() + " and target Speed is: " + targetSpeed);

        final EngineType tempEngineType = targetSpeed >= MAX_ELECTRIC_SPEED ? EngineType.GAS : EngineType.ELECTRIC;
        log.info("tempEngineType: " + tempEngineType);

        final boolean isEnginesNotMatched = !(activeEngine.retrieveEngineType().equals(tempEngineType));

        if (isEnginesNotMatched && targetSpeed >= MAX_ELECTRIC_SPEED) {

            while (activeEngine.retrieveSpeed() < MAX_ELECTRIC_SPEED) increase();
            replaceEngine(tempEngineType);

        } else if(isEnginesNotMatched){

            while (activeEngine.retrieveSpeed() > MAX_ELECTRIC_SPEED) decrease();
            replaceEngine(tempEngineType);
        }
        activeEngine.onSpeedChange(targetSpeed);


        log.info("final speed: {}", activeEngine.retrieveSpeed());

    }
    private void replaceEngine(final EngineType tempEngineType) {
        log.info("replaceEngine");
        final int tempSpeed = activeEngine.retrieveSpeed();
        activeEngine.stop();

        activeEngine = tempEngineType == EngineType.ELECTRIC ? new ElectricEngine() : new GasEngine();
        activeEngine.start();
        activeEngine.onSpeedChange(tempSpeed);
    }

    @Override
    public boolean isStarted() {
        return activeEngine.isStarted();
    }

    @Override
    public int retrieveSpeed() {
        return activeEngine.retrieveSpeed();
    }

    @Override
    public EngineType retrieveEngineType() {
        return activeEngine.retrieveEngineType();
    }


}

