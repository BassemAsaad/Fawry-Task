package com.bassem.fawry;

public final class CarFactory {

    private CarFactory() {
        throw new AssertionError("Utility class");
    }

    public static Car createCar(EngineType engineType) {
        return new Car(createEngine(engineType));
    }

    public static void replaceEngine(Car car, EngineType engineType) {
        car.replaceEngine(createEngine(engineType));
    }

    public static Engine createEngine(EngineType engineType) {
        return switch (engineType) {
            case ELECTRIC -> new ElectricEngine();
            case GAS -> new GasEngine();
            case HYBRID -> new HybridEngine();
        };
    }
}
