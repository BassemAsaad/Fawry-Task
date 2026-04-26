package com.bassem.fawry;

public class HybridEngine implements Engine {

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
        System.out.println("onSpeedChange");
        System.out.println("current Speed is: " + activeEngine.retrieveSpeed() + " and target Speed is: " + targetSpeed);

        final EngineType engineType = targetSpeed >= MAX_ELECTRIC_SPEED ? EngineType.GAS : EngineType.ELECTRIC;
        System.out.println("engineType: " + engineType);

        final boolean isEnginesNotMatched = !(activeEngine.retrieveEngineType().equals(engineType));

        if (isEnginesNotMatched && targetSpeed >= MAX_ELECTRIC_SPEED) {

            while (activeEngine.retrieveSpeed() < MAX_ELECTRIC_SPEED) increase();
            activeEngine.stop();
            activeEngine = createEngineWithCurrentSpeed(engineType, activeEngine.retrieveSpeed());

        } else if(isEnginesNotMatched){

            while (activeEngine.retrieveSpeed() > MAX_ELECTRIC_SPEED) decrease();
            activeEngine.stop();
            activeEngine = createEngineWithCurrentSpeed(engineType, activeEngine.retrieveSpeed());
        }

        activeEngine.onSpeedChange(targetSpeed);

        System.out.println("final speed: " + activeEngine.retrieveSpeed());
    }
    private Engine createEngineWithCurrentSpeed(final EngineType engineType, final int currentSpeed) {
        System.out.println("replacing engine from " + activeEngine.retrieveEngineType() + " to " + engineType);
        Engine newEngine = EngineFactory.createEngine(engineType);
        newEngine.start();
        newEngine.updateSpeed(currentSpeed);
        return newEngine;
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

    @Override
    public void updateSpeed(int targetSpeed) {
        activeEngine.updateSpeed(targetSpeed);
    }
}

